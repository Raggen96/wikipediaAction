package com.googlehome.wikipedia_guesser;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

public class wiki_test{
    public static String[] getRandomArticle(){
        try{
            OkHttpClient client = new OkHttpClient();

            String url = "https://en.wikipedia.org/api/rest_v1/page/random/summary";

            Request req = new Request.Builder().url(url).build();

            Response response = client.newCall(req).execute();
            String content = response.body().string();

            JSONObject json = new JSONObject(content);
            String title = json.getString("title");

            String text = json.getString("extract").replace(title, "redacted");

            String newText = text.replace(title, "redacted");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
