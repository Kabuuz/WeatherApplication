package sample;

import java.util.ArrayList;
import java.util.List;

public class Cities {
    //Singleton
    private static Cities instance = null;

    private Cities() {
    }

    public static Cities getInstance() {
        if (instance == null) instance = new Cities();
        return instance;
    }
    //***********
    private List<String> cityList = new ArrayList<>();//lista do przechowywania wszystkich miast

    public List<String> getCityList(){
        return cityList;
    }

    public void setCityList(List<String> cityList) {
        this.cityList = cityList;
    }

    public List<String> getCitiesFromList(String text) {//dostaje liste miast z dana sekwencja znakow
        List<String> list = new ArrayList<>();
        list.clear();
        for(int i=0;i<cityList.size();i++){
            if(cityList.get(i).toLowerCase().contains(text.toLowerCase())){
                list.add(cityList.get(i));
            }
        }
        return list;
    }
}
