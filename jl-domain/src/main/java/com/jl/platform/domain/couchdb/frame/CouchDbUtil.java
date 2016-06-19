package com.jl.platform.domain.couchdb.frame;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.http.HttpResponse;
import org.lightcouch.CouchDbException;

import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.net.URLDecoder;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import static java.lang.String.format;

/**
 * Created by lishoubo on 16/6/19.
 */
public class CouchDbUtil {
    private CouchDbUtil() {
        // Utility class
    }

    public static void assertNotEmpty(Object object, String prefix) throws IllegalArgumentException {
        if (object == null) {
            throw new IllegalArgumentException(format("%s may not be null.", prefix));
        } else if (object instanceof String && ((String) object).length() == 0) {
            throw new IllegalArgumentException(format("%s may not be empty.", prefix));
        }
    }

    public static void assertNull(Object object, String prefix) throws IllegalArgumentException {
        if (object != null) {
            throw new IllegalArgumentException(format("%s should be null.", prefix));
        }
    }

    public static String generateUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    // JSON

    public static <T> T JsonToObject(Gson gson, JsonElement elem, String key, Class<T> classType) {
        return gson.fromJson(elem.getAsJsonObject().get(key), classType);
    }

    /**
     * @return A JSON element as a String, or null if not found.
     */
    public static String getAsString(JsonObject j, String e) {
        return (j.get(e) == null || j.get(e).isJsonNull()) ? null : j.get(e).getAsString();
    }

    /**
     * @return A JSON element as <code>long</code>, or <code>0</code> if not found.
     */
    public static long getAsLong(JsonObject j, String e) {
        return (j.get(e) == null || j.get(e).isJsonNull()) ? 0L : j.get(e).getAsLong();
    }

    /**
     * @return A JSON element as <code>int</code>, or <code>0</code> if not found.
     */
    public static int getAsInt(JsonObject j, String e) {
        return (j.get(e) == null || j.get(e).isJsonNull()) ? 0 : j.get(e).getAsInt();
    }

    // Files

    private static final String LINE_SEP = System.getProperty("line.separator");

    /**
     * List directory contents for a resource folder. Not recursive.
     * This is basically a brute-force implementation.
     * Works for regular files and also JARs.
     *
     * @param clazz Any java class that lives in the same place as the resources you want.
     * @param path  Should end with "/", but not start with one.
     * @return Just the name of each member item, not the full paths.
     * @author Greg Briggs
     */
    public static List<String> listResources(String path) {
        try {
            Class<CouchDbUtil> clazz = CouchDbUtil.class;
            URL dirURL = clazz.getClassLoader().getResource(path);
            if (dirURL != null && dirURL.getProtocol().equals("file")) {
                return Arrays.asList(new File(dirURL.toURI()).list());
            }
            if (dirURL != null && dirURL.getProtocol().equals("jar")) {
                String jarPath = dirURL.getPath().substring(5, dirURL.getPath().indexOf("!"));
                JarFile jar = new JarFile(URLDecoder.decode(jarPath, "UTF-8"));
                Enumeration<JarEntry> entries = jar.entries();
                Set<String> result = new HashSet<String>();
                while (entries.hasMoreElements()) {
                    String name = entries.nextElement().getName();
                    if (name.startsWith(path)) {
                        String entry = name.substring(path.length());
                        int checkSubdir = entry.indexOf("/");
                        if (checkSubdir >= 0) {
                            entry = entry.substring(0, checkSubdir);
                        }
                        if (entry.length() > 0) {
                            result.add(entry);
                        }
                    }
                }
                close(jar);
                return new ArrayList<String>(result);
            }
            return null;
        } catch (Exception e) {
            throw new CouchDbException(e);
        }
    }

    public static String readFile(String path) {
        InputStream instream = CouchDbUtil.class.getResourceAsStream(path);
        StringBuilder content = new StringBuilder();
        Scanner scanner = null;
        try {
            scanner = new Scanner(instream);
            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine() + LINE_SEP);
            }
        } finally {
            scanner.close();
        }
        return content.toString();
    }

    /**
     * @return {@link InputStream} of {@link HttpResponse}
     */
    public static InputStream getStream(HttpResponse response) {
        try {
            return response.getEntity().getContent();
        } catch (Exception e) {
            throw new CouchDbException("Error reading response. ", e);
        }
    }

    public static String removeExtension(String fileName) {
        return fileName.substring(0, fileName.lastIndexOf('.'));
    }

    public static String streamToString(InputStream in) {
        Scanner s = new Scanner(in);
        s.useDelimiter("\\A");
        String str = s.hasNext() ? s.next() : null;
        close(in);
        close(s);
        return str;
    }

    /**
     * Closes the response input stream.
     *
     * @param response The {@link HttpResponse}
     */
    public static void close(HttpResponse response) {
        try {
            close(response.getEntity().getContent());
        } catch (Exception e) {
        }
    }

    /**
     * Closes a resource.
     *
     * @param c The {@link Closeable} resource.
     */
    public static void close(Closeable c) {
        try {
            c.close();
        } catch (Exception e) {
        }
    }

}
