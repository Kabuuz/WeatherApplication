package sample;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class GraphWindow {

    public static XYChart.Series getSeries() {
        return series;
    }

    public static GraphThread getThread() {
        return thread;
    }

    private static XYChart.Series series;
    private static GraphThread thread;

    public void start() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("graphWindow.fxml"));
        Stage graphStage = new Stage();
        graphStage.setScene(new Scene(root, 600, 400));
        graphStage.initModality(Modality.APPLICATION_MODAL);
        graphStage.setTitle("WeatherStation Graph");
        graphStage.setResizable(false);
        graphStage.show();

        graphStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent e) {
                GraphThread graphThread=GraphThread.getInstance();
                graphThread.stopThread();
            }
        });

    }
}
