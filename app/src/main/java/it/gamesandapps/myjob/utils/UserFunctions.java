package it.gamesandapps.myjob.utils;

import android.support.annotation.Nullable;

public class UserFunctions {

    String req = "";

    private JsonParser jsonParser;
    private static String BASE_URL = "http://gamesandapps.it/myjob/services/";

    private static String USERS = "user/";
    private static String REVIEWS = "review/";
    private static String COMPANIES = "company/";

    private static String GET = "GET";
    private static String POST = "POST";

    public UserFunctions() {
        jsonParser = new JsonParser();
    }

    public String getUsers(@Nullable String id) {
        return jsonParser.simpleRequest(BASE_URL + USERS + (id!=null ? id : ""), GET);
    }

    public String getReviews(@Nullable String id) {
        return jsonParser.simpleRequest(BASE_URL + REVIEWS + (id!=null ? id : ""), GET);
    }

    public String getCompanies(@Nullable String id) {
        return jsonParser.simpleRequest(BASE_URL + COMPANIES + (id!=null ? id : ""), GET);
    }
}
