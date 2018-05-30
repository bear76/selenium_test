package testday02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iframeTest{
    WebDriver driver;
    @BeforeMethod
    public  void  openChrome(){
        System.setProperty("webdriver.chrome.driver","E:\\idea\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public  void  iframeTest1() throws InterruptedException {
        driver.get("file:///E:/idea/selenium_html/index.html");
        //第一种方式：通过ID和name转交控制权
      //  driver.switchTo().frame("aa");
        //第二种方式：webelement 方式
        WebElement iframe =  driver.findElement(By.tagName("iframe"));
         driver.switchTo().frame(iframe);
        driver.findElement(By.linkText("baidu")).click();
        Thread.sleep(300);
        //这是回到外层的，把控制权转交到原来的见面
        driver.switchTo().defaultContent();
        //点击登录见面这个元素
        driver.findElement(By.linkText("登陆界面")).click();
    }



    @AfterMethod
    public  void  close(){
        driver.quit();
    }


}
