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
        driver.get("http://live.techpanda.org/index.php/");
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
    public void TC_02_OrangeHRM() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        String firstName = "Donald";
        String lastName = "Trump";
        String userName = "donald" + new Random().nextInt(9999);
        String password = "Donald137^&*";
        String passportNumber = "123-456-789";
        String passportComment = "thuy\n" + "nt";

        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
        driver. findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//span[text()='PIM']")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("input[name='firstName']")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input[name='lastName'")).sendKeys(lastName);

        String employeeID = driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).getAttribute("value");
        driver.findElement(By.xpath("//p[text()='Create Login Details']/following-sibling::div/label")).click();
        driver.findElement(By.xpath("//label[text()='Username']/parent::div/following-sibling::div/input")).sendKeys(userName);
        driver.findElement(By.xpath("//label[text()='Password']/parent::div/following-sibling::div/input")).sendKeys(password);
        driver.findElement(By.xpath("//label[text()='Confirm Password']/parent::div/following-sibling::div/input")).sendKeys(password);
        driver.findElement(By.xpath("//button[contains(string(),'Save')]")).click();
        Thread.sleep(3000);

        Assert.assertEquals(driver.findElement(By.xpath("//input[@name='firstName']")).getAttribute("value"), firstName);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@name='lastName']")).getAttribute("value"), lastName);
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Employee Id']//parent::div/following-sibling::div/input")).getAttribute("value"), employeeID);
        driver.findElement(By.xpath("//a[text()='Immigration']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//h6[text()='Assigned Immigration Records']//following-sibling::button[contains(string(), 'Add')]")).click();
        driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input")).sendKeys(passportNumber);
        driver.findElement(By.xpath("//label[text()='Comments']/parent::div/following-sibling::div/textarea")).sendKeys(passportComment);
        driver.findElement(By.xpath("//button[contains(string(), 'Save')]")).click();
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("i.bi-pencil-fill")).click();
        Thread.sleep(3000);

        Assert.assertEquals( driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input")).getAttribute("value"), passportNumber);
        Assert.assertEquals( driver.findElement(By.xpath("//label[text()='Comments']/parent::div/following-sibling::div/textarea")).getAttribute("value"), passportComment);
        driver.findElement(By.cssSelector("span.oxd-userdropdown-tab")).click();
        Thread.sleep(3000);

        driver.findElement((By.xpath("//a[text()='Logout']"))).click();
        Thread.sleep(3000);

        // Normal Employee
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys(userName);
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
        driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//span[text()='My Info']")).click();
        Thread.sleep(3000);

        Assert.assertEquals(driver.findElement(By.xpath("//input[@name='firstName']")).getAttribute("value"), firstName);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@name='lastName']")).getAttribute("value"), lastName);
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Employee Id']//parent::div/following-sibling::div/input")).getAttribute("value"), employeeID);
        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Employee Id']//parent::div/following-sibling::div/input")).isEnabled());
        driver.findElement(By.xpath("//a[text()='Immigration']")).click();
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("i.bi-pencil-fill")).click();
        Thread.sleep(3000);

        Assert.assertEquals( driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input")).getAttribute("value"), passportNumber);
        Assert.assertEquals( driver.findElement(By.xpath("//label[text()='Comments']/parent::div/following-sibling::div/textarea")).getAttribute("value"), passportComment);

    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}

