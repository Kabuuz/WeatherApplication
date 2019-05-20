package sample;

public class Weather {
    private static String city;
    private String description;
    private float temperature;
    private float pressure;
    private float humidity;


    public void setCity(String city) {
        this.city = city;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public String getCity() {
        return city;
    }

    public String getDescription() {
        return description;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getPressure() {
        return pressure;
    }

    public float getHumidity() {
        return humidity;
    }


    @Override
    public String toString () {
        return " City: " + city
                + "\n Description: " + description
                + "\n Temperature: " + temperature + "\u00b0C"
                + "\n Pressure: " + pressure + "hPa"
                + "\n Humidity: " + humidity + "%";
    }
}
