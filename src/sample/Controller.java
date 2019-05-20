package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.Map;

public class Controller {

    @FXML
    private TextField cityTextField;

    @FXML
    private Button checkButton;

    @FXML
    private Label tempLabel;

    @FXML
    private ImageView imageView;

    @FXML
    private Label cityLabel;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Label temperatureLabel;

    @FXML
    private Label pressureLabel;

    @FXML
    private Label humidityLabel;

    @FXML
    private ListView<String> listView;

    @FXML
    private Button showGraphBtn;

    @FXML
    private void initialize() throws IOException {
        Cities cities=Cities.getInstance();
        cities.setCityList(LoadCityListFromTXT.getInstance().loadCityListFromTxt());
        listView.getItems().addAll(Cities.getInstance().getCityList());
    }

    @FXML
    void showGraphWindow(ActionEvent event) throws Exception {
        GraphWindow graphWindow=new GraphWindow();
        graphWindow.start();
    }

    @FXML
    void checkWeather(ActionEvent event) {
        if(Cities.getInstance().getCityList().contains(cityTextField.getText())&&(!cityTextField.getText().equals(""))){
            Weather weather=new Weather();
            OpenWeatherJson openWeatherJson=new OpenWeatherJson();
            Map map=openWeatherJson.mapWeather(cityTextField.getText());

            String output;
            String[] parameters;

            output = map.get("weather").toString();
            parameters = output.split(" ");
            if (parameters.length > 4) {
                parameters[2]=parameters[2].replace("description=", "");
                if(parameters[3].contains(",")){
                    parameters[3]=parameters[3].substring(0,parameters[3].indexOf(","));
                }
                weather.setDescription(parameters[2]+" "+parameters[3]);

            } else {
                weather.setDescription(parameters[2].replace("description=", ""));
            }

            output = map.get("main").toString();
            output = output.replaceAll("[^\\d.\\s\\-]", "");
            parameters = output.split(" ");
            weather. setCity(cityTextField.getText());
            weather.setTemperature(Float.parseFloat(parameters[0]));
            weather. setPressure(Float.parseFloat(parameters[1]));
            weather. setHumidity(Float.parseFloat(parameters[2]));

            tempLabel.setText(weather.getTemperature()+"°C");
            cityLabel.setText("City: "+weather.getCity());
            descriptionLabel.setText("Description: "+weather.getDescription());
            temperatureLabel.setText("Temperature: "+String.valueOf(weather.getTemperature())+"°C");
            pressureLabel.setText("Pressure: "+String.valueOf(weather.getPressure())+"hPa");
            humidityLabel.setText("Humidity: "+String.valueOf(weather.getHumidity())+"%");
            ImageGetter imageGetter=new ImageGetter();
            imageGetter.setImage(imageView, weather);
            showGraphBtn.setVisible(true);
        }else{
            tempLabel.setText("--C");
            cityLabel.setText("City: "+"--");
            descriptionLabel.setText("Description: "+"--");
            temperatureLabel.setText("Temperature: "+"--");
            pressureLabel.setText("Pressure: "+"--");
            humidityLabel.setText("Humidity: "+"--");
            imageView.setImage(null);
            showGraphBtn.setVisible(false);
        }
            }

    @FXML
    void refreshList(KeyEvent event) {
        listView.getItems().clear();
        listView.getItems().addAll(Cities.getInstance().getCitiesFromList(cityTextField.getText()));
        listView.scrollTo(0);
    }

    @FXML
    void fromListToTextBox(MouseEvent event) {
        cityTextField.setText(listView.getSelectionModel().getSelectedItem());
    }



}
