package com.googlehome.wikipediaAction;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Random;

public class Wikipedia{

    private static final String[] people = {"Albert_Einstein", "Hillary_Clinton", "Barack_Obama", "Neil_Armstrong", "Serena_Williams", "Michael_Jackson", "Julius_Caesar", "Johnny_Depp",
                                    "Mao_Zedong", "Miley_Cyrus", "Justin_Bieber", "Adolf_Hitler", "Caitlyn_Jenner", "Dante_Alighieri", "J._K._Rowling"};
    public static String[] getRandomArticle(){
        try{
            String url = "https://en.wikipedia.org/api/rest_v1/page/random/summary";
            return modify(sendRequest(url));
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static String[] getRandomPerson(){
        try{
            Random random = new Random();
            String url = "https://en.wikipedia.org/api/rest_v1/page/summary/" + people[random.nextInt(people.length)];
            return modify(sendRequest(url));
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private static Response sendRequest(String url) throws IOException{
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        return client.newCall(request).execute();
    }

    private static String[] modify(Response response){
        JSONObject jsonObject = new JSONObject(response.body().string());
        String title = jsonObject.getString("title");
        String text = jsonObject.getString("extract").replace(title, "redacted");
        return new String[]{title, text}
    }
}
