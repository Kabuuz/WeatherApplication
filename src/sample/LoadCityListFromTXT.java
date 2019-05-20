package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoadCityListFromTXT {
    //singleton
    private static LoadCityListFromTXT instance=null;

    private LoadCityListFromTXT(){}

    public static LoadCityListFromTXT getInstance(){
        if(instance==null) instance=new LoadCityListFromTXT();

        return instance;
    }
    //****

    public List<String> loadCityListFromTxt() throws IOException { //zwraca liste z pliku

        List<String> cityList = new ArrayList<>();

        FileReader file = new FileReader("cityList.txt");
        BufferedReader output = new BufferedReader(file);
        String line;
        while ((line = output.readLine()) != null) {
            cityList.add(line.replace("    ",""));
        }
        output.close();
        file.close();

        return cityList;
    }

}
