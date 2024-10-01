package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_05_XpathTech {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(150));
        driver.get("https://automationfc.github.io/basic-form/");
    }
    @Test
    public void TC_01_Text() {

        //text()='...'
        driver.findElement(By.xpath("//h1[text()='Selenium WebDriver API']"));

        //contains(text(),'...')
        driver.findElement(By.xpath("//h1[contains(text(),'WebDriver API')]"));

        //contains(.,'...')
        driver.findElement(By.xpath("//h5[contains(.,'- living in Viet Nam')]"));

        //contains(string(),'...')
        driver.findElement(By.xpath("//span[contains(string(),'(Ignore Me)')]"));

        //concat()
        driver.findElement(By.xpath("//span[text()=concat('Hello \"John\", What',\"'s happened?\")]"));

        //nested
        Assert.assertEquals(driver.findElement(By.xpath("//h5[@id='nested']")).getText(),"Hello World! (Ignore Me) @04:45 PM");

        //and - or
        driver.findElement(By.xpath("//input[@id='email' and @type='email']"));
        driver.findElement(By.xpath("//input[@id='email' or @type='mail']"));

        //not
        //driver.findElement(By.xpath("//div[not(@style='display:none;')]/div[@class='raDiv']"));
        //driver.findElement(By.xpath("//a[contains(text(),'15')]")).click();
        //driver.findElement(By.xpath("//div[not(@style='display:none;')]/div[@class='raDiv']"));
        //inside parent
        driver.findElement(By.xpath("//link"));

        //outside parent
        driver.findElement(By.xpath("(//div/img)[2]"));

    }

    @Test
    public void TC_02_Index() {

        //position()
        driver.findElement(By.xpath("//select[@id='job2']/option[position()=1]"));

        //index
        driver.findElement(By.xpath("//select[@id='job2']/option[1]"));

        //last()
        driver.findElement(By.xpath("//select[@id='job2']/option[last()]"));

        //last()-1
        driver.findElement(By.xpath("//select[@id='job2']/option[last()-1]"));

        //count()
        //driver.findElement(By.xpath("//select[@id='job2'][/option(//option[@value='security'])]"));

        //count()-1
        //driver.findElement(By.xpath("//select[@id='job2'][/option(//option[@value='security'])-1]"));

    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}

