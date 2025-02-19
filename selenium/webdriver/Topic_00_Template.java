package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_00_Template {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(150));
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01() {
        driver.findElement(By.cssSelector("input[title$='Address']"));

    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}

