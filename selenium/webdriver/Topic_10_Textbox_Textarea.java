package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_10_Textbox_Textarea {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void TC_01_TechPanda() throws InterruptedException {
        driver.get("https://live.techpanda.org/index.php/");
        driver.findElement(By.cssSelector("div.footer a[title= 'My Account']")).click();
        driver.findElement(By.cssSelector("a[title= 'Create an Account']")).click();

        String firstName = "Alcoh";
        String lastName = "Nguyen";
        String fullName = firstName + " " + lastName;
        String emailAddress = "Alcoh" + new Random().nextInt(9999) + "@gmail.com";
        String password = "123123";
        String thoughtReview = "Best phone\n1";
        String summaryReview = "TEsst";

        driver.findElement(By.id("firstname")).sendKeys(firstName);
        //driver.findElement(By.cssSelector("input[id='middlename']")).sendKeys("M123");
        driver.findElement(By.id("lastname")).sendKeys(lastName);
        driver.findElement(By.id("email_address")).sendKeys(emailAddress);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("confirmation")).sendKeys(password);

        driver.findElement(By.cssSelector("button[title='Register']")).click();
        Thread.sleep(3000);

        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),
                "Thank you for registering with Main Website Store.");

        String confirmInformation = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();
        Assert.assertTrue(confirmInformation.contains(fullName));
        Assert.assertTrue(confirmInformation.contains(emailAddress));

        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        driver.findElement(By.xpath("//a[text()='Samsung Galaxy']")).click();
        driver.findElement(By.xpath("//a[text()='Add Your Review']")).click();

        driver.findElement(By.cssSelector("input[id='Quality 1_5']")).click();
        driver.findElement(By.cssSelector("textarea#review_field")).sendKeys(thoughtReview);
        driver.findElement(By.cssSelector("input#summary_field")).sendKeys(summaryReview);
        //nickname_field sẽ tự động điền firstName,, nếu muốn điền ttin khác cần clear ttin đi r nhập thông tin mới
        driver.findElement(By.cssSelector("input#nickname_field")).clear();
        driver.findElement(By.cssSelector("input#nickname_field")).sendKeys(fullName);

        driver.findElement(By.cssSelector("button[title='Submit Review']")).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "Your review has been accepted for moderation.");

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
        //driver.quit();
    }
}

