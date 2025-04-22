package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {

    ChromeDriver driver;

    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        driver.get(ObjectRepository.url);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void clearText() throws InterruptedException {

Thread.sleep(3000);
        driver.findElement(By.id("password")).clear();
    }
}
