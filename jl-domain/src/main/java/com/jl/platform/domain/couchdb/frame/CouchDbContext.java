package com.jl.platform.domain.couchdb.frame;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.lightcouch.CouchDbClient;
import org.lightcouch.CouchDbInfo;
import org.lightcouch.CouchDbProperties;
import org.lightcouch.NoDocumentException;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.List;

import static com.jl.platform.domain.couchdb.frame.CouchDbUtil.close;
import static com.jl.platform.domain.couchdb.frame.CouchDbUtil.getAsString;
import static com.jl.platform.domain.couchdb.frame.URIBuilder.buildUri;


/**
 * Created by lishoubo on 16/6/19.
 */
public class CouchDbContext {

    private static final Log log = LogFactory.getLog(CouchDbClient.class);

    private CouchDbClientBase dbc;

    CouchDbContext(CouchDbClientBase dbc, CouchDbProperties props) {
        this.dbc = dbc;
        if (props.isCreateDbIfNotExist()) {
            createDB(props.getDbName());
        } else {
            serverVersion(); // pre warm up client
        }
    }

    /**
     * Requests CouchDB deletes a database.
     *
     * @param dbName  The database name
     * @param confirm A confirmation string with the value: <tt>delete database</tt>
     */
    public void deleteDB(String dbName, String confirm) {
        if (!"delete database".equals(confirm))
            throw new IllegalArgumentException("Invalid confirm!");
        dbc.delete(buildUri(dbc.getBaseUri()).path(dbName).build());
    }

    /**
     * Requests CouchDB creates a new database; if one doesn't exist.
     *
     * @param dbName The Database name
     */
    public void createDB(String dbName) {
        InputStream getresp = null;
        HttpResponse putresp = null;
        final URI uri = buildUri(dbc.getBaseUri()).path(dbName).build();
        try {
            getresp = dbc.get(uri);
        } catch (NoDocumentException e) { // db doesn't exist
            final HttpPut put = new HttpPut(uri);
            putresp = dbc.executeRequest(put);
            log.info(String.format("Created Database: '%s'", dbName));
        } finally {
            close(getresp);
            close(putresp);
        }
    }

    /**
     * @return All Server databases.
     */
    public List<String> getAllDbs() {
        InputStream instream = null;
        try {
            Type typeOfList = new TypeToken<List<String>>() {
            }.getType();
            instream = dbc.get(buildUri(dbc.getBaseUri()).path("_all_dbs").build());
            Reader reader = new InputStreamReader(instream);
            return dbc.getGson().fromJson(reader, typeOfList);
        } finally {
            close(instream);
        }
    }

    /**
     * @return {@link CouchDbInfo} Containing the DB server info.
     */
    public CouchDbInfo info() {
        return dbc.get(buildUri(dbc.getDBUri()).build(), CouchDbInfo.class);
    }

    /**
     * @return DB Server version.
     */
    public String serverVersion() {
        InputStream instream = null;
        try {
            instream = dbc.get(buildUri(dbc.getBaseUri()).build());
            Reader reader = new InputStreamReader(instream);
            return getAsString(new JsonParser().parse(reader).getAsJsonObject(), "version");
        } finally {
            close(instream);
        }
    }

    /**
     * Triggers a database <i>compact</i> request.
     */
    public void compact() {
        HttpResponse response = null;
        try {
            response = dbc.post(buildUri(dbc.getDBUri()).path("_compact").build(), "");
        } finally {
            close(response);
        }
    }

    /**
     * Requests the database commits any recent changes to disk.
     */
    public void ensureFullCommit() {
        HttpResponse response = null;
        try {
            response = dbc.post(buildUri(dbc.getDBUri()).path("_ensure_full_commit").build(), "");
        } finally {
            close(response);
        }
    }

    /**
     * Request a database sends a list of UUIDs.
     *
     * @param count The count of UUIDs.
     */
    public List<String> uuids(long count) {
        final String uri = String.format("%s_uuids?count=%d", dbc.getBaseUri(), count);
        final JsonObject json = dbc.findAny(JsonObject.class, uri);
        return dbc.getGson().fromJson(json.get("uuids").toString(), new TypeToken<List<String>>() {
        }.getType());
    }
}
