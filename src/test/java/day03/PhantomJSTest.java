package day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

public class PhantomJSTest {
  @Test
    public  void  pjsTest() throws InterruptedException {
     //找到phantomjs的路径
      System.setProperty("phantomjs.binary.path","E:\\idea\\Selenium_test1801\\driversbrowser\\phantomjs.exe");
      //实例化一个phantom
      WebDriver driver =new PhantomJSDriver();
      driver.get("https://www.baidu.com");
      //在百度见面中输入：phantomjs
      driver.findElement(By.id("kw")).sendKeys("phantomJS");
      Thread.sleep(3000);
      //获取当前的标题。然后打印出来
        String a = driver.getTitle();
      System.out.println(a);
      driver.quit();
  }

}
