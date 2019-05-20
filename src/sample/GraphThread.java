package sample;

import javafx.application.Platform;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class GraphThread extends Thread {

    private GraphThread(){}

    private static GraphThread instance=null;
    private static XYChart.Series series;
    public static GraphThread getInstance(){
        if(instance==null){
            instance=new GraphThread();
        }

        return instance;
    }

    public static GraphThread getInstance(XYChart.Series series,LineChart<Number, Number> chart){
        if(instance==null){
            instance=new GraphThread();
        }
        seconds=0;
        GraphThread.series=series;
        return instance;
    }

    private static int seconds=0;
    private static float temperature=0;
    private static boolean runnable=false;


    public void stopThread(){
        runnable=false;
    }

    @Override
    public void run() {
    runnable=true;
    seconds=0;
       while(runnable){
           try {
               Weather weather=new Weather();
               String city=weather.getCity();
               OpenWeatherJson openWeatherJson=new OpenWeatherJson();
               Map map=openWeatherJson.mapWeather(city);

               String output;
               String[] parameters;

               output = map.get("main").toString();
               output = output.replaceAll("[^\\d.\\s\\-]", "");
               parameters = output.split(" ");

               temperature= Float.parseFloat(parameters[0]);
               Platform.runLater(new Runnable() {
                   @Override
                   public void run() {
                       GraphThread.series.getData().add(new XYChart.Data(seconds,temperature));
                   }
               });

               TimeUnit.SECONDS.sleep(1);
               seconds+=1;

           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }

    }
}
