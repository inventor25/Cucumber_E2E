package utilities;

import java.io.FileInputStream;
import java.util.Properties;

// Bu sınıf configuration.properties file i okumak için kullanılır
//property file i okumak için properti objesi kullanılır

public class ConfigReader {

    //This class reads the configuration.properties file
    //Create Properties instance
    private static Properties properties;
    // static block : ilk çalışır
    static {
        //data çekmek istediğim dosyanın path'i
        //path of the configuration file
        String path="configuration.properties";
        try {
            //configuration.properties dosyasını açar
            //Opening configuration.properties file using FileInputStream
            FileInputStream fileInputStream = new FileInputStream(path);
            //properties objesini instantiate ediyoruz
            properties = new Properties();
            //configuration.properties dosyasındaki dataları yükler
            properties.load(fileInputStream);
            //file input stream kapatılır
            //close the file
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //This method will get the key from properties file,
    //And return the value as String
    //We create this method to read the file

    //ConfigReader.getProperty("bowser");--> chrome
    //ConfigReader.getProperty("amazon_url");--> https:/www.amazon.com
    //ConfigReader.getProperty("username"); -> ali
    public static String getProperty(String key){
        String value=properties.getProperty(key);
        return value;
    }
}