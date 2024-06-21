package demoqa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;
//    настройки

    private ConfigReader(){
        //Singleton pattern

    }

   static {
        // static block только для переменных и трай кетч
       try {
           String path = "src/main/resources/app.properties";
           FileInputStream fileInputStream = new FileInputStream(path);
           properties = new Properties();
           properties.load(fileInputStream);
           fileInputStream.close();

       } catch (FileNotFoundException e) {
           throw new RuntimeException(e);
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
   }
// Input --> Output
public static String getValue(String key){
        return properties.getProperty(key).trim();

    }

    public static void main(String[] args) {

    }
}
