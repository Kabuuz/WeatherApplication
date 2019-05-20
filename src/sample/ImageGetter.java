package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class ImageGetter {
    public void setImage(ImageView imageView, Weather weather) {
        Image image;
        if (weather.getDescription().contains("broken") && weather.getDescription().contains("clouds")) {
            File file = new File("icons\\broken_clouds.png");
            image = new Image(file.toURI().toString());
            imageView.setImage(image);
        } else if (weather.getDescription().contains("clear")) {
            File file = new File("icons\\clear.png");
            image = new Image(file.toURI().toString());
            imageView.setImage(image);
        } else if (weather.getDescription().contains("few") && weather.getDescription().contains("clouds")) {
            File file = new File("icons\\few_clouds.png");
            image = new Image(file.toURI().toString());
            imageView.setImage(image);
        } else if (weather.getDescription().contains("mist")) {
            File file = new File("icons\\mist.png");
            image = new Image(file.toURI().toString());
            imageView.setImage(image);
        } else if (weather.getDescription().contains("rain") && weather.getDescription().contains("shower")) {
            File file = new File("icons\\shower_rain.png");
            image = new Image(file.toURI().toString());
            imageView.setImage(image);
        } else if (weather.getDescription().contains("scattered") && weather.getDescription().contains("clouds")) {
            File file = new File("icons\\scattered_clouds.png");
            image = new Image(file.toURI().toString());
            imageView.setImage(image);
        } else if (weather.getDescription().contains("rain")) {
            File file = new File("icons\\rain.png");
            image = new Image(file.toURI().toString());
            imageView.setImage(image);
        } else if (weather.getDescription().contains("snow")) {
            File file = new File("icons\\snow.png");
            image = new Image(file.toURI().toString());
            imageView.setImage(image);
        } else if (weather.getDescription().contains("thunderstorm")) {
            File file = new File("icons\\thunderstorm.png");
            image = new Image(file.toURI().toString());
            imageView.setImage(image);
        }
    }
}
