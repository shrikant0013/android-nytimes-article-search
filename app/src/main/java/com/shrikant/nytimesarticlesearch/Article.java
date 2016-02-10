package com.shrikant.nytimesarticlesearch;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.text.TextUtils;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by spandhare on 2/9/16.
 */
public class Article {
    public final static String RESPONSE = "response";
    public final static String DOCS = "docs";
    public final static String WEB_URL = "web_url";
    public final static String HEADLINE = "headline";
    public final static String MAIN = "main";
    public final static String MULTIMEDIA = "multimedia";
    public final static String TYPE = "type";
    public final static String IMAGE = "image";
    public final static String URL = "url";
    public final static String NYTIMES_BASE_URI = "http://www.nytimes.com/";

    String webUrl = "";
    String headline = "";
    String thumbnailUrl = "";

    /*
    weburl: { "response" =>  "docs => [x] => "web_url" }
    headline: { "docs => [x] => "headline" . "main" }
    thumbnail type (image): { "docs => [x] => "multimedia" => [x] => "type" }
    thumbnail url: { "docs => [x] => "multimedia" => [x] => "url" }
   */
    public Article(JSONObject jsonArticleObject) {
        String web_url = jsonArticleObject.optString(WEB_URL);
        if (!TextUtils.isEmpty(web_url)) {
            this.webUrl = web_url;
        }
        String headline = jsonArticleObject.optJSONObject(HEADLINE).optString(MAIN);
        if (!TextUtils.isEmpty(headline)) {
            this.headline = headline;
        }
        JSONArray jsonMultimediaArray = jsonArticleObject.optJSONArray(MULTIMEDIA);
        for (int i = 0; i < jsonMultimediaArray.length(); i++) {
            JSONObject jsonMultimediaObject =  jsonMultimediaArray.optJSONObject(i);

            if (jsonMultimediaObject != null &&
                    jsonMultimediaObject.optString(TYPE).equals(IMAGE)) {
                this.thumbnailUrl = NYTIMES_BASE_URI + jsonMultimediaObject.optString(URL);
                break;
            }
        }
    }

    public static ArrayList<Article> fromJSONArray(JSONArray jsonDocsArray) {
        ArrayList<Article> results = new ArrayList<>();

        for (int i = 0; i < jsonDocsArray.length(); i++) {
            JSONObject jsonArticleObject = jsonDocsArray.optJSONObject(i);
            try {
                if (jsonDocsArray.optJSONObject(i) != null) {
                    results.add(new Article(jsonDocsArray.getJSONObject(i)));
                }
            } catch (JSONException e) {
                Log.e("JSON" ,"Exception in json parsing " + e.getMessage());
            }
        }
        return results;
    }
}
