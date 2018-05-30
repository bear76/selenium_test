package com.test.day01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FindElements {
    WebDriver driver;
 //定位搜索文本框（百度见面）
    @BeforeMethod
    public void  openChrome(){
        System.setProperty("webdriver.chrome.driver","E:\\idea\\chromedriver\\chromedriver.exe");
         driver = new ChromeDriver();
    }

    @Test
    public  void  byIdTest(){
        driver.get("https://www.baidu.com");
        //1:通过id来定位
       WebElement keywbk = driver.findElement(By.id("kw"));
    }

    @Test
    public  void  byNameTest(){
        driver.get("https://www.baidu.com");
        //2:通过name来定位
        WebElement keywbk = driver.findElement(By.name("wd"));
    }
     @Test
     public  void byClass(){
        driver.get("https://www.baidu.com");
        //3:class
        WebElement keywebk = driver.findElement(By.className("s_ipt"));
     }

      @Test
      public void  ByLinkText(){
        driver.get("https://www.baidu.com");
        //4:ByLinkText  一定要在a标签里面。
        WebElement keywbk = driver.findElement(By.linkText("新闻"));
      }
      @Test
      public  void BypartialLink(){
        driver.get("https://www.baidu.com");
        //5:partialLinkText ,部分文本a标签
        WebElement keywbk = driver.findElement(By.partialLinkText("新"));
         /* Assert.assertEquals();
          Assert.assertNotEquals();
          Assert.assertNotNull();
          Assert.assertNull();
          */
      }

      @Test
      public  void  ByXpath(){
        driver.get("https://www.baidu.com");
        //6:通过Xpath路径，很重要：右击复制Xpath
        WebElement keywbk = driver.findElement(By.xpath("//*[@id=\"su\"]"));
      }

    @Test
    public  void  ByCss(){
        driver.get("https://www.baidu.com");
        //7:通过XCss路径，很重要：右击复制Xpath
        WebElement keywbk = driver.findElement(By.cssSelector("#lg > map > area"));
    }

     @Test
     public  void  bypaths(){
        driver.get("https://www.baidu.com");
        //获取全部列表
         List<WebElement>  list =  driver.findElements(By.xpath("//*[@id=\"u1\"]/a"));
        //获取这一行的列表集合。
         for (int i = 0 ; i<list.size() ; i++) {
             String text = list.get(i).getText();
             System.out.println(text);
         }
     }

    @AfterMethod
    public  void  closeBrowser(){
        driver.quit();
    }


}
