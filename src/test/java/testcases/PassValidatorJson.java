package testcases;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class PassValidatorJson extends BaseClass {

    public static void main(String[] args) throws IOException {
        /*String content = new String(Files.readAllBytes(Paths.get("resource/JsonData.json")));

        System.out.println(content);*/

        Object[][] data=null;

        ObjectMapper objMapper = new ObjectMapper();
        Map<String, String> testData = objMapper.readValue(new File("resource/JsonData.json"), Map.class);
        for(Map.Entry<String,String> entry:testData.entrySet()){

            System.out.println(entry.getKey());
            System.out.println(entry.getValue());

        }
       /* int passCount=testData.get("password").length();
        int erroCount=testData.get("error").length();

        System.out.println(passCount);
        System.out.println(erroCount);*/


    }

/*
    @Test(dataProvider = "jsonData")
    public Object[][] get_Json_Data() throws IOException {
        Object[][] data=null;

        ObjectMapper objMapper = new ObjectMapper();
        Map<String, String> testData = objMapper.readValue(new File("resource/JsonData.json"), Map.class);
        int passCount=testData.get("password").length();
        data=new Object[][]


        return testData;

    }*/
}
