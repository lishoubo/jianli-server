package com.jl.platform.domain.couchdb.frame;

import org.apache.http.*;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.*;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.ssl.SSLContexts;
import org.lightcouch.CouchDbProperties;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.net.URLDecoder;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * Created by lishoubo on 16/6/19.
 */
public class CouchDbClient extends CouchDbClientBase {

    /**
     * Constructs a new instance of this class, expects a configuration file named
     * <code>couchdb.properties</code> to be available in your application default classpath.
     */
    public CouchDbClient() {
        super();
    }

    /**
     * Constructs a new instance of this class.
     *
     * @param configFileName The configuration file name.
     */
    public CouchDbClient(String configFileName) {
        super(new CouchDbConfig(configFileName));
    }

    /**
     * Constructs a new instance of this class.
     *
     * @param dbName             The database name.
     * @param createDbIfNotExist To create a new database if it does not already exist.
     * @param protocol           The protocol to use (i.e http or https)
     * @param host               The database host address
     * @param port               The database listening port
     * @param username           The Username credential
     * @param password           The Password credential
     */
    public CouchDbClient(String dbName, boolean createDbIfNotExist,
                         String protocol, String host, int port, String username, String password) {
        super(new CouchDbConfig(new CouchDbProperties(dbName, createDbIfNotExist, protocol, host, port, username, password)));
    }

    /**
     * Constructs a new instance of this class.
     *
     * @param properties An object containing configuration properties.
     * @see {@link CouchDbProperties}
     */
    public CouchDbClient(CouchDbProperties properties) {
        super(new CouchDbConfig(properties));
    }

    /**
     * @return {@link CloseableHttpClient} instance.
     */
    @Override
    HttpClient createHttpClient(CouchDbProperties props) {
        try {
            Registry<ConnectionSocketFactory> registry = createRegistry(props);
            PoolingHttpClientConnectionManager ccm = createConnectionManager(props, registry);
            HttpClientBuilder clientBuilder = HttpClients.custom()
                    .setConnectionManager(ccm)
                    .setDefaultConnectionConfig(ConnectionConfig.custom()
                            .setCharset(Consts.UTF_8).build())
                    .setDefaultRequestConfig(RequestConfig.custom()
                            .setSocketTimeout(props.getSocketTimeout())
                            .setConnectTimeout(props.getConnectionTimeout()).build());
            if (props.getProxyHost() != null)
                clientBuilder.setProxy(new HttpHost(props.getProxyHost(), props.getProxyPort()));
            if (props.getUsername() != null) {
                CredentialsProvider credsProvider = new BasicCredentialsProvider();
                credsProvider.setCredentials(new AuthScope(props.getHost(),
                                props.getPort()),
                        new UsernamePasswordCredentials(props.getUsername(),
                                props.getPassword()));
                clientBuilder.setDefaultCredentialsProvider(credsProvider);
                props.clearPassword();
            }
            registerInterceptors(clientBuilder);
            return clientBuilder.build();
        } catch (Exception e) {
            throw new IllegalStateException("Error Creating HTTPClient: ", e);
        }
    }

    @Override
    HttpContext createContext() {
        AuthCache authCache = new BasicAuthCache();
        authCache.put(host, new BasicScheme());
        HttpContext context = new BasicHttpContext();
        context.setAttribute(HttpClientContext.AUTH_CACHE, authCache);
        return context;
    }

    private PoolingHttpClientConnectionManager createConnectionManager(
            CouchDbProperties props, Registry<ConnectionSocketFactory> registry) {
        PoolingHttpClientConnectionManager ccm = new PoolingHttpClientConnectionManager(registry);
        if (props.getMaxConnections() != 0) {
            ccm.setMaxTotal(props.getMaxConnections());
            ccm.setDefaultMaxPerRoute(props.getMaxConnections());
        }
        return ccm;
    }

    private Registry<ConnectionSocketFactory> createRegistry(CouchDbProperties props) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        RegistryBuilder<ConnectionSocketFactory> registry = RegistryBuilder
                .<ConnectionSocketFactory>create();

        if ("https".equals(props.getProtocol())) {
            SSLContext sslcontext = SSLContexts.custom()
                    .loadTrustMaterial(null, new TrustStrategy() {
                        public boolean isTrusted(X509Certificate[] chain, String authType)
                                throws CertificateException {
                            return true;
                        }
                    }).build();

            return registry.register("https", new SSLConnectionSocketFactory(sslcontext,
                    new NoopHostnameVerifier())).build();
        } else {
            return registry.register("http", PlainConnectionSocketFactory.INSTANCE).build();
        }
    }

    /**
     * Adds request/response interceptors for logging and validation.
     *
     * @param clientBuilder
     */
    private void registerInterceptors(HttpClientBuilder clientBuilder) {
        clientBuilder.addInterceptorFirst(new HttpRequestInterceptor() {
            public void process(final HttpRequest request,
                                final HttpContext context) throws IOException {
                if (log.isInfoEnabled()) {
                    RequestLine req = request.getRequestLine();
                    log.info("> " + req.getMethod() + " " + URLDecoder.decode(req.getUri(), "UTF-8"));
                }
            }
        });
        clientBuilder.addInterceptorFirst(new HttpResponseInterceptor() {
            public void process(final HttpResponse response,
                                final HttpContext context) throws IOException {
                if (log.isInfoEnabled()) {
                    log.info("< Status: " + response.getStatusLine().getStatusCode());
                }
                validate(response);
            }
        });
    }

    public void shutdown() {
        HttpClientUtils.closeQuietly(this.httpClient);
    }
}