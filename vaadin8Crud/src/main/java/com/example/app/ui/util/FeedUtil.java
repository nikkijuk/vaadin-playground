package com.example.app.ui.util;

import com.example.app.ui.model.FeedWrapper;
import com.google.gson.Gson;

/**
 * Operations for json manipulation
 */
public class FeedUtil {

    private FeedUtil() {} // helper class, not possible to instantiate

    // Xml to Json conversion api
    private final static String RSS_TO_JSON_API_API = "https://api.rss2json.com/v1/api.json?rss_url=";

    // Default feed used
    private final static String DEFAULT_RSS_URL ="http://rss.nytimes.com/services/xml/rss/nyt/Science.xml";

    // Please see here possible nyt feeds for testing
    //
    // http://www.nytimes.com/services/xml/rss/index.html
    //
    // ex. http://rss.nytimes.com/services/xml/rss/nyt/Arts.xml

    /**
     * Reads url, and uses default if preferences is empty
     */
    public static String getUrl() {
        return String.format("%s%s", RSS_TO_JSON_API_API ,DEFAULT_RSS_URL);
    }

    /**
     * Convert json to pojos using gson
     * @param json json
     * @return FeedWrapper as root of object graph
     */
    public static FeedWrapper convertToObjects(String json) {

        // GSON is created during each conversion - reusing possibilities need to be analyzed
        return new Gson().fromJson(json, FeedWrapper.class); // json -> pojos
    }

}
