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

public class LoginTest {
    WebDriver driver;
    @BeforeMethod
    public  void  openChrome(){
        System.setProperty("webdriver.chrome.driver","E:\\idea\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mail.163.com/");
    }

    @Test
    public  void  loginSecuss(){
        WebDriverWait wait =new WebDriverWait(driver ,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("x-URS-iframe")));
        //控制权driver给ifram
        driver.switchTo().frame("x-URS-iframe");
        driver.findElement(By.name("email")).sendKeys("15002185092");
        driver.findElement(By.name("password")).sendKeys("xiongye76");
        driver.findElement(By.id("dologin")).click();

        //WebDriverWait wait  =new WebDriverWait(driver , 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("退出")));
        //退出在A标签里面，所以用的By.linktext
       String  logout =  driver.findElement(By.linkText("退出")).getText();
        Assert.assertEquals(logout , "退出");
    }


    @Test
    public  void  loginError(){
        WebDriverWait wait =new WebDriverWait(driver ,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("x-URS-iframe")));
        //控制权driver给ifram
        driver.switchTo().frame("x-URS-iframe");
        driver.findElement(By.name("email")).sendKeys("15002185092");
        driver.findElement(By.name("password")).sendKeys("xiongye761");
        driver.findElement(By.id("dologin")).click();


        //WebDriverWait wait  =new WebDriverWait(driver , 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"nerror\"]/div[2]")));
        //这里注意，如果ID是一串动态的数字，建议用上面的id/div[2]
        String  error =  driver.findElement(By.xpath("//*[@id=\"nerror\"]/div[2]")).getText();
        Assert.assertEquals(error , "帐号或密码错误");
    }



    @AfterMethod
    public  void  close(){
        driver.quit();
    }



}
