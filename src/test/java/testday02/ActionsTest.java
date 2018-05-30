package testday02;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ActionsTest {
    WebDriver driver;
    @BeforeMethod
    public  void  openChrome(){
        System.setProperty("webdriver.chrome.driver","E:\\idea\\chromedriver\\chromedriver.exe");
          driver = new ChromeDriver();
    }
   @Test
    public    void clickTest(){
        driver.get("https://www.baidu.com");
        //定位新闻链接
        WebElement newslink = driver.findElement(By.name("tj_trnews"));
        //点击新闻链接
        newslink.click();
        //获取当前地址
        String url = driver.getCurrentUrl();
        //校验当前页面是不是新闻页面
        Assert.assertEquals(url,"http://news.baidu.com/");
    }
     @Test
     public void  inputKey() throws InterruptedException {
        driver.get("https://www.baidu.com");
        //定位百度搜索框
       WebElement input= driver.findElement(By.id("kw"));
       //搜索框输入 selenium
       input.sendKeys("selenium");
       //定位百度按钮
       WebElement  button = driver.findElement(By.id("su"));
       //点击
       button.click();
      // WebElement text = driver.findElement(By.xpath("//*[@id=\"4001\"]/div[1]/h3/a[1]"));
        //获取当前title
         Thread.sleep(3000);
         String title =  driver.getTitle();
         //校验是否和实际值相等
        Assert.assertEquals(title,"selenium_百度搜索");
     }

     @Test
     public  void  clearTest() throws InterruptedException {
         driver.get("https://www.baidu.com");
         //定位百度搜索框
         WebElement input= driver.findElement(By.id("kw"));
         //搜索框输入 selenium
         input.sendKeys("selenium");
         Thread.sleep(3000);
         //清空文本框
         input.clear();
         Thread.sleep(3000);
     }

     @Test
     public  void  getText(){
         driver.get("https://www.baidu.com");
         //定位百度新闻搜索框
         String text1 = driver.findElement(By.name("tj_trnews")).getText();
         Assert.assertEquals(text1,"新闻");
     }

     @Test
     //通过标签名来获取
     public  void  tagname(){
        driver.get("https://www.baidu.com");
        String tagName = driver.findElement(By.id("kw")).getTagName();
       Assert.assertEquals(tagName,"input");
     }

     @Test
     public  void  shuxing(){
        driver.get("https://www.baidu.com");
        //value是百度一下名称
      String attribute =   driver.findElement(By.id("su")).getAttribute("value");
      Assert.assertEquals(attribute,"百度一下");
     }

     @Test
     public  void  display(){
        driver.get("https://www.baidu.com");
        Boolean  b = driver.findElement(By.id("su")).isDisplayed();
        Assert.assertTrue(b);
     }
       @Test
       public void  select(){
        driver.get("http://www.51diaocha.com/w/1446930.htm");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"i_27146\"]"));
        element.click();
        Boolean b = element.isSelected();
        Assert.assertTrue(b);
       }

       @Test
       public  void  enable(){
        driver.get("http://www.51diaocha.com/w/1446930.htm");
        Boolean b = driver.findElement(By.xpath("//*[@id=\"ylSubmitBtn\"]")).isEnabled();
        Assert.assertTrue(b);
       }

       @Test
       public  void  jietu(){
        driver.get("https://baidu.com");
        //把driver强制转化一个类型TakesScreenshot，调用getScreenshotAs
           File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
           try {
               //这个文件调用，新建一个文件拷贝，把file拷贝到D盘底下
               FileUtils.copyFile(file,new File("D:\\test1.png"));
           } catch (IOException e) {
               e.printStackTrace();
           }

       }


    @AfterMethod
    public  void  close(){

        driver.quit();
    }



}
