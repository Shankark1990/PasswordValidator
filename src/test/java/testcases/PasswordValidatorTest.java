package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PasswordValidatorTest extends BaseClass {


    @Test(priority = 10, dataProvider = "valPassData", dataProviderClass = TestData.class)
    public void validPassword(TestData data) {

        System.out.println(data.getValidPassword());
        driver.findElement(By.id("password")).sendKeys(data.getValidPassword());
        driver.findElement(By.xpath(ObjectRepository.clickBtn_xpath)).click();
        String errorMsg = driver.findElement(By.xpath(ObjectRepository.errorMessage_xpath)).getText();
        Assert.assertEquals(errorMsg, "Congratulations ! Password is valid!");

    }

    @Test(priority = 20, dataProvider = "valPassData", dataProviderClass = TestData.class)
    public void shortPassword(TestData data){

        System.out.println(data.getShortPass());
        driver.findElement(By.id("password")).sendKeys(data.getShortPass());
        driver.findElement(By.xpath(ObjectRepository.clickBtn_xpath)).click();

        String errorMsg = driver.findElement(By.xpath(ObjectRepository.errorMessage_xpath)).getText();
        Assert.assertEquals(errorMsg, "Wrong Password ! Password must be between 8 and 15 characters.");

    }

    @Test(priority = 30, dataProvider = "valPassData", dataProviderClass = TestData.class)
    public void consecutiveLetters(TestData data){

        driver.findElement(By.id("password")).sendKeys(data.getConsecutiveLetter());
        driver.findElement(By.xpath(ObjectRepository.clickBtn_xpath)).click();

        String errorMsg = driver.findElement(By.xpath(ObjectRepository.errorMessage_xpath)).getText();
        Assert.assertEquals(errorMsg, "Wrong Password ! Password cannot have consecutive letters or numbers like 'abc' or '123'.");

    }


}
