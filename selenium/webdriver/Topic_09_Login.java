package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_09_Login {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(150));
        driver.get("https://live.techpanda.org/");
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Empty() {
        // Click vào My Account tại footer
        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();
        driver.findElement(By.cssSelector("button#send2"));
// Cách này tốn tài nguyên
        //String emailText = driver.findElement(By.cssSelector("div#advice-required-entry-email")).getText();
        //Assert.assertEquals(emailText,"This is a required field.");

        //String passText = driver.findElement(By.cssSelector("div#advice-required-entry-pass")).getText();
        //Assert.assertEquals(passText,"This is a required field.");
// Cách này tiện cho những biến k cần dùng lại, bớt tốn tài nguyên hơn
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-email")).getText(),
                "This is a required field.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-pass")).getText(),
                "This is a required field.");

    }

    @Test
    public void TC_02_Invalid_Email() {
        // Click vào My Account tại footer
        // Click vào My Account tại footer
        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();
        driver.findElement(By.cssSelector("input#email")).sendKeys("12eee@k.com");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("123456y");
        driver.findElement(By.cssSelector("button#send2"));

        Assert.assertEquals(driver.findElement(By.cssSelector("div#input-text.required-entry.validate-email span")).getText(),
                "Please in clude an '@' in the email address. '12eee@k.com' is missing an '@'");

    }

    @Test
    public void TC_03_Pass_less_than_6() {
        // Click vào My Account tại footer
        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();
        driver.findElement(By.cssSelector("input#email")).sendKeys("Alcoh@gmail.com");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("12e");
        driver.findElement(By.cssSelector("button#send2"));


        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-validate-password-pass")).getText(),
                "Please enter 6 or more characters without leading or trailing spaces.");

    }

    @Test
    public void TC_04_Incorrect() throws InterruptedException {
        /// Click vào My Account tại footer
        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();
        driver.findElement(By.cssSelector("input#email")).sendKeys("Alcoh@gmail.com");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("12e22f");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button#send2"));

        Assert.assertEquals(driver.findElement(By.cssSelector("li.error-msg span")).getText(),
                "Invalid login or password.");
    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}

