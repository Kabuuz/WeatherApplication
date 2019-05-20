package sample;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;

public class OpenWeatherJson {
    public Map mapWeather(String city) {
        final String APIKEY = "c27380f32a6fa3ed3863e9bfc3d00375";
        StringBuffer response = new StringBuffer();

        if (city.contains(" ")) {
            city=city.replaceAll(" ", "+");
        }

        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&units=metric&APPID=" + APIKEY;


        try {
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader((new InputStreamReader(connection.getInputStream())));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

        } catch (MalformedURLException ex) {
            System.out.println("bad url");
        } catch (IOException ex) {
            System.out.println("Connection failed");
        }

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        Map m = gson.fromJson(response.toString(), Map.class);

        return m;

    }
}
