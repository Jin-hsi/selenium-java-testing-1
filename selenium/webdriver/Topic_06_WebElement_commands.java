package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_06_WebElement_commands {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(150));
        driver.get("https://www.facebook.com/");
    }
    @Test
    public void TC_01_Element() {
        WebElement element = driver.findElement(By.cssSelector("input#FirstName"));
        // xoa dl trong 1 editable element (nhap)
        // textbox / textarea / dropdown
        element.clear();

        //nhap dl vao 1 editable element (nhap)
        element.sendKeys("");

        // 1 - Element cha dung 1 loai locator, element con 1 loai locator
        driver.findElement(By.cssSelector("div.form-fields")).findElement((By.cssSelector("input#FirstName")));

        //2- cha va con chung 1 loai locator
        driver.findElement(By.cssSelector("div.form-fields input#FirstName"));

        //tim 1 element vaf locator laf tham so truyen vao
        driver.findElement(By.cssSelector("")); //**

        //Click len clickable element
        // button / checkbox/radio/link/image/dropdown/icon
        element.click();

        //tuong duong voi submit thong tin de gui len server
        //gia lap hanh vi press enter cua end user
        //register / login / search/...
        element.submit();

        // verify thong tin / dl da action

        // ktra 1 element co hien thi hay khong?
        //Ap dung cho tat ca cac loai element
        element.isDisplayed();

        //ktra 1 element da dc chon hay chua
        //ap dung cho checkbox / radio /dwopdown
        element.isSelected();

        //ktra 1 element cos cho phep thao tac len hay khong?
        //cho phep suwa du lieu
        // true = dc phep chinh sua dl / thao tac
        // false = bij disable
        //test tinh nang phan quyen
        element.isEnabled();

        // III - lay dl
        // lay ra chieu rong chie cao cua element
        element.getSize();
        element.getText(); // lay ra text cau element
        element.getAttribute("placehoder"); // lay ra text trong attribute , ex) nam trong placehoder

        //Shdoww DOM
        element.getShadowRoot();

        //it dung / dev Fontend dung la chinh
        element.getAriaRole();
        element.getDomProperty("");
        element.getDomAttribute("");
        element.getAccessibleName();

        // font /. background / font size /... => css
        element.getCssValue("background-color"); // ra ma mau #dfhsds

        // lay ra chieu rong chie cao cua element
        element.getSize();

        //lay ra vi tri cua element goc tren ben trai so voi brower
        element.getLocation();

        Rectangle elementRect = element.getRect();
        elementRect.getDimension(); //get size
        elementRect.getPoint();

        //lay ten the HTML cua element
        // By.id /class /name/ css
        element.getTagName();

        driver.findElement(By.id("email")).getTagName();
        //input . it dung

        //take screenshot (chup hinh loi)
        element.getScreenshotAs((OutputType.FILE));
        element.getScreenshotAs((OutputType.BYTES));
        element.getScreenshotAs((OutputType.BASE64));

// dung nhieu nhat la click /senKey /isDisplayed /getText
    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}

