package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_04_Register {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(150));
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
    }
    @Test
    public void TC_01_Empty_data() {
        driver.findElement(By.xpath("//div[@class='form frmRegister']//button[text()='ĐĂNG KÝ']")).click();
        //driver.findElement(By.id("txtFirstname-error")).getText();
        Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(),"Vui lòng nhập họ tên");
        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(),"Vui lòng nhập email");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Vui lòng nhập lại địa chỉ email");
        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(),"Vui lòng nhập mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Vui lòng nhập lại mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Vui lòng nhập số điện thoại.");
    }
    @Test
    public void TC_02_Invalid_email() {
        driver.findElement(By.id("txtFirstname")).sendKeys("Nguyen Van A");
        driver.findElement(By.id("txtEmail")).sendKeys("111#gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("111#gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("123456");
        driver.findElement(By.id("txtCPassword")).sendKeys("123456");
        driver.findElement(By.id("txtPhone")).sendKeys("0987654321");

        driver.findElement(By.xpath("//div[@class='form frmRegister']//button[text()='ĐĂNG KÝ']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(),"Vui lòng nhập email hợp lệ");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Email nhập lại không đúng");
    }
    @Test
    public void TC_03_Incorrect_confirm_email() {
        driver.findElement(By.id("txtFirstname")).sendKeys("Nguyen Van A");
        driver.findElement(By.id("txtEmail")).sendKeys("111@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("111#gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("123456");
        driver.findElement(By.id("txtCPassword")).sendKeys("123456");
        driver.findElement(By.id("txtPhone")).sendKeys("0987654321");

        driver.findElement(By.xpath("//div[@class='form frmRegister']//button[text()='ĐĂNG KÝ']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Email nhập lại không đúng");
    }
    @Test
    public void TC_04_Invalid_password() {
        driver.findElement(By.id("txtFirstname")).sendKeys("Nguyen Van A");
        driver.findElement(By.id("txtEmail")).sendKeys("111@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("111@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("1234");
        driver.findElement(By.id("txtCPassword")).sendKeys("1234");
        driver.findElement(By.id("txtPhone")).sendKeys("0987654321");

        driver.findElement(By.xpath("//div[@class='form frmRegister']//button[text()='ĐĂNG KÝ']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");
    }
    @Test
    public void TC_05_Incorrect_confirm_PW() {
        driver.findElement(By.id("txtFirstname")).sendKeys("Nguyen Van A");
        driver.findElement(By.id("txtEmail")).sendKeys("111@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("111@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("123456");
        driver.findElement(By.id("txtCPassword")).sendKeys("123458");
        driver.findElement(By.id("txtPhone")).sendKeys("0987654321");

        driver.findElement(By.xpath("//div[@class='form frmRegister']//button[text()='ĐĂNG KÝ']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Mật khẩu bạn nhập không khớp");
    }
    @Test
    public void TC_06_Invalid_phone_number() {
        // less than 10 and more than 11
        driver.findElement(By.id("txtFirstname")).sendKeys("Nguyen Van A");
        driver.findElement(By.id("txtEmail")).sendKeys("111@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("111@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("123456");
        driver.findElement(By.id("txtCPassword")).sendKeys("123456");
        driver.findElement(By.id("txtPhone")).sendKeys("0987654321887");

        driver.findElement(By.xpath("//div[@class='form frmRegister']//button[text()='ĐĂNG KÝ']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại phải từ 10-11 số.");
        // contains text
        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.id("txtPhone")).sendKeys("098765432e");

        driver.findElement(By.xpath("//div[@class='form frmRegister']//button[text()='ĐĂNG KÝ']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Vui lòng nhập con số");
        //not start with: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08
        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.id("txtPhone")).sendKeys("0698765432");

        driver.findElement(By.xpath("//div[@class='form frmRegister']//button[text()='ĐĂNG KÝ']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");
    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}

