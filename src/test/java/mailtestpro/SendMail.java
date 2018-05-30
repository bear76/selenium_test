package mailtestpro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SendMail {
    WebDriver driver;
    @BeforeMethod
    public  void  openChrome(){
       System.setProperty("webdriver.chrome.driver","E:\\idea\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mail.163.com/");
    }

    @Test
    public  void  sendMailTest(){
        //显示等待iframe元素加载完毕
        WebDriverWait wait =  new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("x-URS-iframe")));
        //把driver控制权转交给iframe
        driver.switchTo().frame("x-URS-iframe");
        //输入用户名和密码，点击登录
        driver.findElement(By.name("email")).sendKeys("15002185092");
        driver.findElement(By.name("password")).sendKeys("xiongye76");
        driver.findElement(By.id("dologin")).click();
        //driver.findElement(By.xpath("//*[@id='dvNavTop']/ul/li[2]/span[2]")).click();
       // WebDriverWait wait =  new WebDriverWait(driver,10);
        //点击发送邮件
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/nav/div[1]/ul/li[2]/span[2]")));
        driver.findElement(By.xpath("/html/body/div[1]/nav/div[1]/ul/li[2]/span[2]")).click();
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("js-component-emailtips nui-ipt-placeholder")));
        //输入邮件，主题，添加附件，输入内容
        driver.findElement(By.className("nui-editableAddr-ipt"))
                .sendKeys("15002185092@163.com");
        driver.findElement(By.xpath("//*[@aria-label=\"邮件主题输入框，请输入邮件主题\"]/input"))
                .sendKeys("主题名称");
        driver.findElement(By.xpath("//*[@title=\"点击添加附件\"]/input"))
                .sendKeys("D:\\Users\\Geoffery\\Pictures\\abc.jpg");
         WebElement frame =  driver.findElement(By.className("APP-editor-iframe"));
         driver.switchTo().frame(frame);
         driver.findElement(By.xpath("/html/body")).sendKeys("请见附件图片");
         //把控制权转交回去并且点击发送按钮
         driver.switchTo().defaultContent();
         driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[1]/section/footer/div[1]/span[2]")).click();
         //校验“发送成功”是否显示。.//*[text()='发送成功']
         wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[text()='发送成功']")));
        boolean bsess=  driver.findElement(By.xpath(".//*[text()='发送成功']")).isDisplayed();
        Assert.assertTrue(bsess);
    }



    @AfterMethod
    public  void  close(){
       // driver.quit();
    }


}
