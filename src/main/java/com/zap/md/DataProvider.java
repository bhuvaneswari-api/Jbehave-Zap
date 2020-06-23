package com.zap.md;

import org.junit.Assert;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

// This class is created for the purpose of reading object repository properties file
public class DataProvider {
    private Properties properties = new Properties();
    private final String filePath = System.getProperty("user.dir")+"/CommonVariables.properties";
    private FileReader file;
    public static HashMap<String, String> dataFromProperties = new HashMap<>();

    // Constructor to initialize all variables in properties file and store in hashmap
    public DataProvider(){
        try {
            try{
                file = new FileReader(filePath);
            }
            catch (FileNotFoundException e){
                e.printStackTrace();
            }
            BufferedReader reader = new BufferedReader(file);
            properties.load(reader);
            reader.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        for(String key: properties.stringPropertyNames()){
            String value = properties.getProperty(key);
            dataFromProperties.put(key, value);
        }
        System.out.println("Data Properties: --------------- "+dataFromProperties.toString());
    }

    // Method to read the key value pairs stored in Hashmap from properties file

    public String readFromHashMap(String key){

        String value = "";

        if(dataFromProperties.containsKey(key)){
            value = dataFromProperties.get(key);
        }
        else{
            Assert.fail("Given key is not present in the properties file");
        }
        return value;
    }
}
