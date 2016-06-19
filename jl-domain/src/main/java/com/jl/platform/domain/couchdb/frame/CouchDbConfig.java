package com.jl.platform.domain.couchdb.frame;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lightcouch.CouchDbProperties;

import java.io.InputStream;
import java.util.Properties;


/**
 * Created by lishoubo on 16/6/19.
 */
public class CouchDbConfig {
    private static final Log log = LogFactory.getLog(CouchDbConfig.class);
    private static final String DEFAULT_FILE = "couchdb.properties";

    private Properties properties = new Properties();
    private String configFile;
    private CouchDbProperties dbProperties;

    public CouchDbConfig() {
        this(DEFAULT_FILE);
    }

    public CouchDbConfig(String configFile) {
        this.configFile = configFile;
        try {
            InputStream instream = CouchDbConfig.class.getClassLoader().getResourceAsStream(configFile);
            properties.load(instream);
        } catch (Exception e) {
            String msg = "Could not read configuration file from the classpath: " + configFile;
            log.error(msg);
            throw new IllegalStateException(msg, e);
        }
        readProperties();
    }

    public CouchDbConfig(CouchDbProperties dbProperties) {
        this.dbProperties = dbProperties;
    }

    private void readProperties() {
        try {
            // required
            dbProperties = new CouchDbProperties();
            dbProperties.setDbName(getProperty("couchdb.name", true));
            dbProperties.setCreateDbIfNotExist(new Boolean(getProperty("couchdb.createdb.if-not-exist", true)));
            dbProperties.setProtocol(getProperty("couchdb.protocol", true));
            dbProperties.setHost(getProperty("couchdb.host", true));
            dbProperties.setPort(Integer.parseInt(getProperty("couchdb.port", true)));
            dbProperties.setUsername(getProperty("couchdb.username", true));
            dbProperties.setPassword(getProperty("couchdb.password", true));

            // optional
            dbProperties.setPath(getProperty("couchdb.path", false));
            dbProperties.setSocketTimeout(getPropertyAsInt("couchdb.http.socket.timeout", false));
            dbProperties.setConnectionTimeout(getPropertyAsInt("couchdb.http.connection.timeout", false));
            dbProperties.setMaxConnections(getPropertyAsInt("couchdb.max.connections", false));
            dbProperties.setProxyHost(getProperty("couchdb.proxy.host", false));
            dbProperties.setProxyPort(getPropertyAsInt("couchdb.proxy.port", false));

        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        properties = null;
    }

    public CouchDbProperties getProperties() {
        return dbProperties;
    }

    private String getProperty(String key, boolean isRequired) {
        String property = properties.getProperty(key);
        if (property == null && isRequired) {
            String msg = String.format("A required property is missing. Key: %s, File: %s", key, configFile);
            log.error(msg);
            throw new IllegalStateException(msg);
        } else {
            return (property != null && property.length() != 0) ? property.trim() : null;
        }
    }

    private int getPropertyAsInt(String key, boolean isRequired) {
        String prop = getProperty(key, isRequired);
        return (prop != null) ? Integer.parseInt(prop) : 0;
    }
}
