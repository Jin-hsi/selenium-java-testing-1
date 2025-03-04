package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_07_Browser_Excecise {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }
    @Test
    public void TC_01_Page_Url() {

        //Mở link test
        driver.get("http://live.techpanda.org/");

        // Click vào My Account tại footer
        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();

        // Khi viết code xong và muốn chạy 1 testcase nào đó thì tất cả các class nào đó
        // trong project không còn lỗi ( không báo đỏ)
        // Phải có đủ dấu bắt đầu, kết thúc : (), "", {}
        // Hàm được goi ra đúng vị trí

        // Khai báo biến với kiểu dữ liệu phù hợp
        String loginPageUrl = driver.getCurrentUrl();
        Assert.assertEquals(loginPageUrl,"http://live.techpanda.org/index.php/customer/account/login/");

        // biến chỉ dùng 1 lần mà khai báo biến thì tốn bộ nhớ => k nên làm vậy => làm cách 2 như dưới đây
        Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");

        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/create/");


    }
    @Test
    public void TC_02_Page_Title() {

        //Mở link test
        driver.get("http://live.techpanda.org/");
        Assert.assertEquals(driver.getTitle(),"Home page");
        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();
        Assert.assertEquals(driver.getTitle(),"Customer Login");
        driver.findElement(By.xpath("div.footer a[title='Create an Account']")).click();
        Assert.assertEquals(driver.getTitle(),"Create New Customer Account");

    }
    @Test
    public void TC_03_Nagative() {

        //Mở link test
        driver.get("http://live.techpanda.org/");

        //Click chuyển sang trang My account
        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();

        // Click chuyển sang trang Create account
        driver.findElement(By.xpath("div.footer a[title='Create an Account']")).click();

        //Quay lại trang trước đó
        driver.navigate().back();

        // Chuyển về trang ước đó
        driver.navigate().forward();

    }
    @Test
    public void TC_04_Page_Source_Code() {

        //Mở link test
        driver.get("http://live.techpanda.org/");

        // Click chuyển sang trang Register
        //Click chuyển sang trang My account
        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();

        // Tuyệt đối dùng assert
        //Assert.assertEquals(driver.getPageSource(),"Login or Create an Account");

        // Tương đối
        Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));

        // Click chuyển sang trang Create account
        driver.findElement(By.xpath("div.footer a[title='Create an Account']")).click();

        Assert.assertTrue(driver.getPageSource().contains("Create an Account"));

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}

