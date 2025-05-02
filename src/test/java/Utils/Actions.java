package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testcases.ObjectRepository;

public class Actions {

    public static void enterText(WebDriver driver, String txt){
        driver.findElement(By.id("password")).sendKeys(txt);
    }
    public static void eleClcik(WebDriver driver){
        driver.findElement(By.xpath(ObjectRepository.clickBtn_xpath)).click();
    }

    public static String get_Error_Message(WebDriver driver){
        String errMsg=driver.findElement(By.xpath(ObjectRepository.errorMessage_xpath)).getText();
        return errMsg;
    }

}
