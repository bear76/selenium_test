package testday02;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlterTest {

    WebDriver driver;
    @BeforeMethod
    public  void  openChrome(){
        System.setProperty("webdriver.chrome.driver","E:\\idea\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public  void  alterT() throws InterruptedException {
        driver.get("file:///E:/idea/selenium_html/index.html");
        //定位到Alter
        driver.findElement(By.xpath("//*[@id=\"alert\"]/input")).click();
        Thread.sleep(3000);
        //通过控制权转交给Alter
         Alert    alert = driver.switchTo().alert();
         //获取文本框的上值
         String text =  alert.getText();
         //点击确定的处理
        alert.accept();
        Assert.assertEquals(text,"请点击确定");
    }

    @Test
    //第二种警告方式
    public  void confirmTest() throws InterruptedException {
        driver.get("file:///E:/idea/selenium_html/index.html");
        driver.findElement(By.className("confirm")).click();
         Thread.sleep(3000);
          Alert alert = driver.switchTo().alert();
         //点击弹窗框的取消
         alert.dismiss();
         Thread.sleep(3000);
         //再点击确定按钮
         alert.accept();
    }

    //第三警告方式，是可以输入值的
    @Test
    public  void  promptTest() throws InterruptedException {
       // System.setProperty( "webdriver.gecko.driver" , "E:\\idea\\Firefox\\geckodriver.exe");
       // WebDriver webDriver = new FirefoxDriver();
        driver.get("file:///E:/idea/selenium_html/index.html");
        driver.findElement(By.xpath("//*[@id=\"prompt\"]/input")).click();
        Thread.sleep(3000);
       Alert alert =  driver.switchTo().alert();
       alert.sendKeys("这个是prompt");
       Thread.sleep(2000);
       alert.accept();
       Thread.sleep(3000);
       alert.accept();
    }


    @AfterMethod
    public  void  close(){
        driver.quit();
    }


}
