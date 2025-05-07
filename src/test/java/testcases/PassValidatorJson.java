package testcases;

import Utils.Actions;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class PassValidatorJson extends BaseClass {

    public static void main(String[] args) throws IOException {
        /*String content = new String(Files.readAllBytes(Paths.get("resource/JsonData.json")));

        System.out.println(content);*/

        Object[][] data = null;

        ObjectMapper objMapper = new ObjectMapper();
        File jsonfile = new File("resource/JsonData.json");

        JsonData[] data1 = objMapper.readValue(jsonfile, JsonData[].class);


        System.out.println(data1);


    }

    @DataProvider(name = "json_data")
    public Object[][] get_Json_Data() throws IOException {
        Object[][] objData = null;

        ObjectMapper objMapper = new ObjectMapper();
        JsonData[] data = objMapper.readValue(new File("resource/JsonData.json"), JsonData[].class);

        objData = new Object[data.length][1];

        for (int i = 0; i < data.length; i++) {
            objData[i][0] = data[i];
        }

        return objData;

    }

    @Test(dataProvider = "json_data")
    public void readJsonData(JsonData data) {
        Actions.enterText(driver, data.getPassword());
        Actions.eleClcik(driver);
        String actualErrorMsg = driver.findElement(By.xpath(ObjectRepository.errorMessage_xpath)).getText();
        Assert.assertEquals(data.getError(), actualErrorMsg);
    }
}
