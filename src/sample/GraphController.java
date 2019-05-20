package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class GraphController {

    private static XYChart.Series series;
    private Thread thread;

    @FXML
    private LineChart<Number, Number> chart;

    private GraphThread graphThread;

    @FXML
    private void initialize() {
        chart.setTitle("Temperature Chart");
        chart.getXAxis().setLabel("Seconds");
        chart.getYAxis().setLabel("Temperature");
        chart.setLegendVisible(false);
        series = new XYChart.Series();
        graphThread=GraphThread.getInstance(series,chart);
        thread=new Thread(graphThread,"gT");
        thread.start();
        chart.getData().add(series);
    }

}

