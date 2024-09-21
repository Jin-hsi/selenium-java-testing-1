package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_02_Locator {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(150));
        //driver.get("https://profile.w3schools.com/signup?redirect_url=https%3A%2F%2Fwww.w3schools.com%2F");
    }
    @Test
    public void TC_01_ID() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.id("txtFirstname"));
        //driver.findElement(By.id("launcher")).sendKeys(...keysToSend: "AAAAAA");

    }
    @Test
    public void TC_02_Class() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.className("field_L"));

    }
    @Test
    public void TC_03_name() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.name("txtFirstname"));
    }

    @Test
    public void TC_04_Link() {
        // Chỉ dùng đc đường link có text vd: <a href="https://www.w3schools.com/" target="_blank" rel="noopener noreferrer">Privacy Policy</a>
        // Text phải là text trên UI ( tránh nhầm với text HTML)
        // Truyền hết cả chuỗi text
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.linkText("Hướng dẫn sử dụng"));
    }

    @Test
    public void TC_05_Partial_Link() {
        // truyền hết or 1 phần link text
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.partialLinkText("Hướng"));
        driver.findElement(By.partialLinkText("sử dụng"));
    }

    @Test
    public void TC_06_TagName() {
        // Cùng tên thẻ nhưng khác element
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        int linkNumber =   driver.findElements(By.tagName("a")).size();
        System.out.println("Tổng số link của là:" + linkNumber);
        //driver.findElement(By.partialLinkText("Terms"));
    }

    @Test
    public void TC_07_Css() {
        // css và Xpath mang tính chính xác cao hơn với cùng tagName nhương element khác nhau
        // Thẻ input: textbox/button/.... xem chia tiết các loại input trên w3s - html input type
        // driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        //int textNumber =   driver.findElements(By.cssSelector("div[id='txtCEmail']")).size();
        //System.out.println("Tổng số link của button là:" + textNumber);
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        // Css vs id
        driver.findElement(By.cssSelector("input[id='txtSearch']"));
        driver.findElement(By.cssSelector("#txtSearch"));
        driver.findElement(By.cssSelector("input#txtSearch"));

        // css vs class
        driver.findElement(By.cssSelector("div[class='searchwp']"));
        driver.findElement(By.cssSelector("div.searchwp"));
        driver.findElement(By.cssSelector(".searchwp"));

        // Ngoại lệ của class: khi có khoảng trắng
        driver.findElement(By.cssSelector("div[class='header-bot hidden-xs']"));
        driver.findElement(By.cssSelector("div.header-bot.hidden-xs"));
        driver.findElement(By.cssSelector("div.hidden-xs.header-bot"));

        // Css vs name
        driver.findElement(By.cssSelector("input[name='txtFirstname']"));

        // css vs link ( css k làm việc đc với text)
        driver.findElements(By.cssSelector("a[href='https://alada.vn/gioi-thieu.html']"));
        driver.findElements(By.cssSelector("a[href*='gioi-thieu.html']"));

        // css vs partial link
        driver.findElements(By.cssSelector("a[href*='halada.vn/gioi-thieu']")); // ngàu nhiên
        driver.findElements(By.cssSelector("a[href^='https://alada.vn/gioi']"));  // đầu
        driver.findElements(By.cssSelector("a[href$='.vn/gioi-thieu.html']"));  // cuói

        // css vs tagName
        int linkNumber1 = driver.findElements(By.cssSelector("a")).size();
        System.out.println("Tổng số link a là:" + linkNumber1);
    }


    @Test
    public void TC_08_Xpath() {

        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        // Xpath vs id
        driver.findElement(By.xpath("//input[@id='txtSearch']"));

        // Xpath vs class
        driver.findElement(By.xpath("//div[@class='temp-div-popup']"));

        // Xpath vs name
        driver.findElement(By.xpath("//input[@name='txtSearch']"));

        // Xpath vs link ( css làm việc đc với text. text html)
        driver.findElement(By.xpath("//a[@href='https://alada.vn/gioi-thieu.html']"));
        driver.findElement(By.xpath("//a[text()='Giới thiệu']"));

        // Xpath vs partial link
        driver.findElement(By.xpath("//a[starts-with(@href,'https://alada.vn/gioi-thieu.html')]"));
        driver.findElement(By.xpath("//a[contains(@href,'alada.vn/gioi-')]"));
        // Xpath k support end-with như css($=)
        //driver.findElements(By.xpath("a[end-with(@href='about-magento-demo-store/')]"));

        //Xpath vs tagName

        int alinkNumber = driver.findElements(By.xpath("//a")).size();
        System.out.println("Tổng số link a là:" + alinkNumber);
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}

