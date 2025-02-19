package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;

public class Topic_05_WebBrower_Commands {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        //tuong tac vo ni cac brower thong qua cac bien driver

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(150));
        // Mở ra 1 URL bất kỳ
        driver.get("https://live.techpanda.org/index.php/customer/account/login/"); // hàm hay sd **
        System.out.println("Driver ID= " + driver.toString());
    }
    @Test
    public void TC_01_Brower() {
        // mở ra 1 URL bất k
        driver.get("https://www.facebook.com/");
        // đóng brower - k qtam co bnh tab windown, closed het
        driver.quit();                                                        // hàm hay sd **

        // dong tab or windown hien tai
        driver.close();

        // tim 1 element vs locator la tham so truyen vao
        driver.findElement(By.cssSelector(""));                  // hàm hay sd **

        // tim nhieu element vs locator la tham so truyen vao
        driver.findElements(By.cssSelector(""));                   // hàm hay sd **

        // ham tuong tac len brower
        driver.navigate();

        // ham lay du lieu ( toan bo ham get tru driver.get("");
        // lay ra url hien tai
        driver.getCurrentUrl();
        // lay ra thi can luu tru o dau do, goi la noi luu tru
        String homePageUrl = driver.getCurrentUrl();
        // lay ra url da tim ra o tren
        //Cach 1: cac ham roi rac nhau, da dc lu tru o homePageUrl
        driver.get(homePageUrl);
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/");

        // Cach 2: sd luon k can luu tru
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/");

        // lay ra title o page htai
        driver.getTitle();

        // lay ra windown id ow page htai
        driver.getWindowHandle();

        // lay ra tat ca id cua ca tab htai
        driver.getWindowHandles();

        // lay ra source cau page htai
        driver.getPageSource();

    }
    @Test
    public void TC_01_Brower_run() {
        // lay ra url cua page htai
        String homePageUrl = driver.getCurrentUrl();
        System.out.println("Page URL: " + driver.getCurrentUrl());

        // lay ra title o page htai
        driver.getTitle();
        System.out.println("Page Title: " + driver.getTitle());

        // lay ra windown id ow page htai
        driver.getWindowHandle();
        System.out.println("Page Window Handle: " + driver.getWindowHandle());

        // lay ra tat ca id cua ca tab htai
        driver.getWindowHandles();
        System.out.println("Page Window Handles: " + driver.getWindowHandles());

        // lay ra source code page htai
        driver.getPageSource();
        System.out.println("Page source code: " + driver.getPageSource());

        //-- Alert - Fram /iFrame - Windown/Tab
        // Alert
        driver.switchTo().alert();                                               // hàm hay sd **
        // tính năng giống driver.switchTo().alert();
        WebDriver.TargetLocator switchTo = driver.switchTo();
        switchTo.alert();

        //Fram /iFrame
        // Switch vào Frame /iFrame
        driver.switchTo().frame("");                                    // hàm hay sd **
        // Switch ra trang cha tro lai ( switch tu farme ra ngoai, chỉ có 1 frame)
        driver.switchTo().defaultContent();
        // Switch ra trang cha lon nhat ( co nhieu frame long nhau)
        driver.switchTo().parentFrame();

        // switch qua các window - tab ( mỗi window co 1 id rieng)
        // newWindow chi co tu selenium version 4
        driver.switchTo().window("");                                     // hàm hay sd **
        driver.switchTo().newWindow(WindowType.TAB).get("https://live.techpanda.org/");
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://live.techpanda.org/");

        //set timeout để tìm element ( áp dụng cho 2 hàm findElement / findElements
        // không tìm thấy sẽ chờ hết từng đó tgian đã chọn mới show lỗi
        driver.manage().timeouts().implicitlyWait(Duration.ofNanos(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));                    // hàm hay sd **
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(30)); //( có cả giờ , ngày,....)

        driver.manage().timeouts().getImplicitWaitTimeout(); // get tgian timeout đã setting ở h trên ( ver 4 mới có)

        // thời gian chờ pade đc load xong
        // hàm driver.get("https://live.techpanda.org/index.php/customer/account/login/"); có dùng rồi nên hàm này thường k đc sd
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        // chờ cho đoạn code js đc thực thi thành công
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));

        //Cookie
        driver.manage().getCookies();
        // brower: fullscreen / maximize / min / size....
        driver.manage().window().maximize();                           // hàm hay sd **
        driver.manage().window().fullscreen();
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().window().getSize();
        driver.manage().window().setPosition(new Point(0, 1)); // set brower hiển thị tại vị trí nào
        driver.manage().window().getPosition();

        // logs : brower / client / ,,,,
        driver.manage().logs().get(LogType.BROWSER);
        driver.manage().logs().getAvailableLogTypes();

        // quay lại / chuyển tiếp . refresh trang
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

        // mở ra 1 url
        driver.navigate().to("https://live.techpanda.org/"); // bị ảnh hưởng bởi load time out
        driver.navigate().to(new URL("https://live.techpanda.org/"));

    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}

