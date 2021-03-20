package idk;

import java.net.URL;

import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
public class App {
    public static void main(String[] args) throws Exception {

        String location = "";
        String lat = "21.21362941124338";
        String lon = "72.78927097868942";
        String APIKEY = "i5voj8n0llf85am0siun3l9s78";
      
        URL url = new URL("http://api.airpollutionapi.com/1.0/aqi?lat="+lat+"&lon="+lon+"&APPID="+APIKEY);
      
        //API WITH OK HTTP

        OkHttpClient client = new OkHttpClient().newBuilder()
		.build();
        Request request = new Request.Builder()
		.url(url)
		.method("GET", null)
		.build();
        Response response = client.newCall(request).execute();
       // System.out.println(response.body().string());
        //OkHttps Ends
        JSONObject object = new JSONObject(response.body().string());
        System.out.println("Last Update: " + object.getJSONObject("data").getString("updated"));
        System.out.println("Quality: " + object.getJSONObject("data").getString("text"));
        for(int i=0;i<=9;i++){
            System.out.println("Name: " + object.getJSONObject("data").getJSONArray("aqiParams").getJSONObject(i).getString("name") +
         "\n--Value: " + object.getJSONObject("data").getJSONArray("aqiParams").getJSONObject(i).getString("value"));
        }
        
    }

}
