package testday02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WaitTest {
    WebDriver driver;
    @BeforeMethod
    public  void  openChrome(){
        System.setProperty("webdriver.chrome.driver","E:\\idea\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @Test
    public  void waitTest(){
        driver.get("file:///E:/idea/webdriver_demo/selenium_html/index.html");
        driver.findElement(By.xpath("//*[@id=\"wait\"]/input")).click();

        //1：全局等待方式。10秒内找到执行下面的代码
       // driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        //2：只能等待
        WebDriverWait wait = new WebDriverWait(driver ,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"display\"]/div")));

        String text = driver.findElement(By.xpath("//*[@id=\"display\"]/div")).getText();
        Assert.assertEquals(text,"wait for display");
    }



    @AfterMethod
    public  void  close(){

        driver.quit();
    }


}
