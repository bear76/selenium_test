package mailtestpro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest {
    WebDriver driver;
    @BeforeMethod
    public  void  openChrome(){
        System.setProperty("webdriver.chrome.driver","E:\\idea\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @Test
    public  void  registTest() throws InterruptedException {
        driver.get("https://mail.163.com/");

        WebDriverWait  wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("x-URS-iframe")));
        //把控制权转交给iframe 里面
          driver.switchTo().frame("x-URS-iframe");

        WebDriverWait  abc = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("changepage")));
        //点击注册按钮
        driver.findElement(By.id("changepage")).click();
        //获取当前driver 所在的handle
         String handle1 = driver.getWindowHandle();
         // driver 切换到新的window页面
         for (String handles : driver.getWindowHandles()){
             if ( handles.equals(handle1)){
                 continue;
             }
             driver.switchTo().window(handles);
         }
          //得到一个时间戳，目前是13位，除以100就是11位手机号
          String time1= String.valueOf(System.currentTimeMillis()/100);
         driver.findElement(By.id("nameIpt")).sendKeys("xy"+time1);
         driver.findElement(By.id("mainPwdIpt")).sendKeys("123456abc");
         driver.findElement(By.id("mainCfmPwdIpt")).sendKeys("123456abc");
         driver.findElement(By.id("mainMobileIpt")).sendKeys(time1);
         driver.findElement(By.id("vcodeIpt")).sendKeys("123abc");
         driver.findElement(By.id("mainAcodeIpt")).sendKeys("123fdfv");
         driver.findElement(By.id("mainRegA")).click();

         //显示时间:直到等到了 "  手机验证码不正确，请重新填写"
        WebDriverWait  abd = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"m_mainAcode\"]/span")));
        //定位提示错误的提示
         String error = driver.findElement(By.xpath("//*[@id=\"m_mainAcode\"]/span")).getText();
         //校验提示的错误是不是这个。
        Assert.assertEquals(error , "  手机验证码不正确，请重新填写");

        Thread.sleep(3000);
    }



   @AfterMethod
    public  void  close(){
        driver.quit();
    }
}
