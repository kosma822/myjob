package it.gamesandapps.myjob.utils;

import android.content.Context;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

public class JsonParser {

    public JsonParser(){}

    public String simpleRequest(String url, String method){
        try {
            URL obj = new URL(url);
            HttpURLConnection conn = (HttpURLConnection)obj.openConnection();
            conn.setConnectTimeout(10000);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestMethod(method);

            Log.d("URL", conn.getURL().toString());

            int responseCode = conn.getResponseCode();
            StringBuilder response = new StringBuilder();

            if(responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_PARTIAL){
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;

                while((line = br.readLine()) != null){
                    response.append(line);
                }
                return response.toString();
            }

        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public String multiRequest(String method, String requestURL, HashMap<String, String> params){

        URL url;
        try {
            url = new URL(requestURL);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(15000);
            conn.setRequestProperty("Accept","application/json");
            conn.setRequestMethod(method);
            conn.setDoInput(true);
            conn.setDoOutput(true);

            OutputStream os = conn.getOutputStream();

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));

            writer.write(getPostDataString(params));

            writer.flush();
            writer.close();
            os.close();

            Log.d("URL", conn.getURL().toString());

            int responseCode=conn.getResponseCode();

            if (responseCode == HttpsURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_PARTIAL) {

                String response = "";
                String line;
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                while ((line=br.readLine()) != null) {
                    response+=line;
                }
                return response;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getPostDataString(HashMap<String, String> params) throws UnsupportedEncodingException{
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for(Map.Entry<String, String> entry : params.entrySet()){
            if (first)
                first = false;
            else
                result.append("&");
            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }

        return result.toString();
    }
}
