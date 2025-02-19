package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_10_Textbox_Textarea {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //driver.get("https://www.facebook.com/");
    }
    @Test
    public void TC_01_TechPanda() {
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");
        driver.findElement(By.cssSelector("div.footer a[title= 'My Account']")).click();
        driver.findElement(By.cssSelector("a[title= 'Create An Account']")).click();

        String firstname = "Donald";
        String lastname = "Nguyen";
        String emailAddress = "Nguyen";
        String password = "Nguyen";

    }
    @Test
    public void TC_02_OrangeHRM() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("admin123");
        driver.findElement(By.cssSelector("oxd-form-actions orangehrm-login-action")).click();
        //driver.findElement(By.xpath("span[tex()='PIM']/parent::a");
        //Thread.sleep(4000);

        driver.findElement(By.xpath(
                "//label[text()='Employee Id']/parent::div/following-sibling::div/input")).getAttribute("value");


        String firstname = "Donald";
        String lastname = "Nguyen";
        String emailAddress = "Nguyen";
        String password = "Nguyen";

    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}

