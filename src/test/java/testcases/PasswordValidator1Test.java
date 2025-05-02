package testcases;

import Utils.Actions;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PasswordValidator1Test extends BaseClass {

    @Test(priority = 10, dataProvider = "excel_data", dataProviderClass = ExcelData.class)
    public void validPassword(ExcelData data) throws InterruptedException {

        Thread.sleep(2000);
        Actions.enterText(driver, data.getValidPass());
        Actions.eleClcik(driver);

/*
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitBtn = driver.findElement(By.xpath(ObjectRepository.clickBtn_xpath));

        passwordField.sendKeys(data.getValidPass());
        submitBtn.click();
*/

        Thread.sleep(3000);
        errorMsg = driver.findElement(By.xpath(ObjectRepository.errorMessage_xpath)).getText();
        Assert.assertEquals(errorMsg, "Congratulations ! Password is valid!");

    }

    @Test(priority = 20, dataProvider = "excel_data", dataProviderClass = ExcelData.class)
    public void invalidPass(ExcelData data) throws InterruptedException {

        Thread.sleep(2000);
        Actions.enterText(driver, data.getInvalidPass());
        Actions.eleClcik(driver);

/*
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitBtn = driver.findElement(By.xpath(ObjectRepository.clickBtn_xpath));

        Thread.sleep(2000);
        passwordField.sendKeys(data.getInvalidPass());
        submitBtn.click();
*/

        errorMsg = driver.findElement(By.xpath(ObjectRepository.errorMessage_xpath)).getText();
        Assert.assertEquals(errorMsg, "Wrong Password ! Password must contain uppercase, lowercase, number and special character (!@#$%_).");


    }

    @Test(priority = 30, dataProvider = "excel_data", dataProviderClass = ExcelData.class)
    public void shortPass(ExcelData data) throws InterruptedException {

        Thread.sleep(2000);
        Actions.enterText(driver, data.getShortPass());
        Actions.eleClcik(driver);

/*
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitBtn = driver.findElement(By.xpath(ObjectRepository.clickBtn_xpath));

        Thread.sleep(2000);
        passwordField.sendKeys(data.getShortPass());
        submitBtn.click();
*/

        errorMsg = driver.findElement(By.xpath(ObjectRepository.errorMessage_xpath)).getText();
        Assert.assertEquals(errorMsg, "Wrong Password ! Password must be between 8 and 15 characters.");

    }

    @Test(priority = 40, dataProvider = "excel_data", dataProviderClass = ExcelData.class)
    public void consecutivePass(ExcelData data) throws InterruptedException {

        Thread.sleep(2000);
        Actions.enterText(driver, data.getConsecutivePass());
        Actions.eleClcik(driver);

       /* WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitBtn = driver.findElement(By.xpath(ObjectRepository.clickBtn_xpath));

        Thread.sleep(2000);
        passwordField.sendKeys(data.getConsecutivePass());
        submitBtn.click();*/

        errorMsg = Actions.get_Error_Message(driver);
        Assert.assertEquals(errorMsg, "Wrong Password ! Password cannot have consecutive letters or numbers like 'abc' or '123'.");

    }

}
