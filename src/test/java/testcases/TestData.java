package testcases;

import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestData {

    private String validPassword;
    private String shortPass;

    public String getShortPass() {
        return shortPass;
    }

    public void setShortPass(String shortPass) {
        this.shortPass = shortPass;
    }


    public String getValidPassword() {
        return validPassword;
    }

    public void setValidPassword(String validPassword) {
        this.validPassword = validPassword;
    }

    @DataProvider(name = "valPassData")
    public static Object[][] getData() throws IOException {

        TestData testData=new TestData();

        Properties prop=new Properties();
        FileInputStream fis=new FileInputStream("resource/testPasswords.properties");
        prop.load(fis);
        fis.close();

        testData.setValidPassword(prop.getProperty("validPassword"));
        testData.setShortPass(prop.getProperty("shortPass"));

        Object[][] data={{testData}};
        return data;

    }


}
