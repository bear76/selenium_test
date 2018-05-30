package testday02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class windowSelect {
    WebDriver driver;
    @BeforeMethod
    public  void  openChrome(){
        System.setProperty("webdriver.chrome.driver","E:\\idea\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public  void  windowText() throws InterruptedException {
        driver.get("file:///E:/idea/selenium_html/index.html");
        driver.findElement(By.linkText("Open new window")).click();
        Thread.sleep(3000);
        //当前drivr所在的页面的 句柄值
        String  handel = driver.getWindowHandle();
        //for循环判断  获取的到handles是否等于handle
        for(String handels  : driver.getWindowHandles()){
            if (handels.equals(handel)){
                continue;
            }else {
                driver.switchTo().window(handels);
            }
        }
       // driver.getWindowHandles();
        //driver.switchTo().window(handel);
        driver.findElement(By.linkText("baidu")).click();
        Thread.sleep(3000);

    }



    @AfterMethod
    public  void  close(){
        driver.quit();
    }
}
