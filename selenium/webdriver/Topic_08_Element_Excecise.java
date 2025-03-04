package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_08_Element_Excecise {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //driver.manage().window().maximize();
        //Mở link test
        //driver.get("https://automationfc.github.io/basic-form/index.html");
    }

    @Test
    public void TC_01_Displayed() {
        // ktra 1 element co hien thi hay khong? Người dùng có thể nhìn thấy, có kích thước cụ thể
        // Ap dung cho tat ca cac loai element
        // trái ngc với disabled là undisplay
        // element.isDisplayed();
        driver.get("https://automationfc.github.io/basic-form/index.html");
        if (driver.findElement(By.cssSelector("input#mail")).isDisplayed()) {
            driver.findElement(By.cssSelector("input#mail")).sendKeys("Auto test 1");
            System.out.println("Email textbox is Displayed.");
        } else {
            System.out.println("Email textbox is Un-displayed.");
        }

        if (driver.findElement(By.cssSelector("textarea#edu")).isDisplayed()) {
            driver.findElement(By.cssSelector("textarea#edu")).sendKeys("Auto Education test 1");
            System.out.println("Education textbox is Displayed.");
        } else {
            System.out.println("Education textbox is Un-displayed.");
        }

        if (driver.findElement(By.cssSelector("input#under_18")).isDisplayed()) {
            driver.findElement(By.cssSelector("input#under_18")).click();
            System.out.println("Age Under 18 radio is Displayed.");
        } else {
            System.out.println("Age Under 18 radio is Un-displayed.");
        }

        if (driver.findElement(By.xpath("//h5[text()='Name: User5']")).isDisplayed()) {
            driver.findElement(By.cssSelector("//h5[text()='Name: User5']/following-sibling::a")).click();
            System.out.println("Name Picture is Displayed.");
        } else {
            System.out.println("Name Picture is Un-displayed.");
        }

    }
    @Test
    public void TC_02_Selected() {
        //ktra 1 element đã đc chọn hay chưa
        //ap dung cho checkbox / radio /dwopdown
        //   element.isSelected();

    }
    @Test
    public void TC_03_Enabled() {
        //ktra 1 element cos cho phep thao tac len hay khong?
        //cho phep suwa du lieu
        // true = dc phep chinh sua dl / thao tac
        // false = bị disable
        //test tinh nang phan quyen
        //   element.isEnabled();
        driver.get("https://automationfc.github.io/basic-form/index.html");
        if (driver.findElement(By.cssSelector("input#mail")).isEnabled()) {
            System.out.println("Email textbox is Enabled.");
        } else {
            System.out.println("Email textbox is Displayed.");
        }

        if (driver.findElement(By.cssSelector("input#disable_password")).isEnabled()) {
            System.out.println("Password textbox is Enabled.");
        } else {
            System.out.println("Password textbox is Displayed.");
        }




    }

    @AfterClass
    public void afterClass(){
       // driver.quit();
    }
}

