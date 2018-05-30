package com.test.day01;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CloseBrowser {

    WebDriver driver;
    @Test
    public  void  closeChrome() throws InterruptedException {
        //1：设置chromedriver的路径
        System.setProperty("webdriver.chrome.driver","E:\\idea\\chromedriver\\chromedriver.exe");
        //:2：实例化 ChromeDriver实例化
        driver= new ChromeDriver();
        //这里是打开百度地址
         driver.get("https://www.baidu.com");
        //3:关闭浏览器
        Thread.sleep(5000); //等待5s
        //driver.close(); //关闭当前窗口
        // driver.quit();  //完全退出关闭浏览器
    }

     @Test
    public  void   getFirefox () throws InterruptedException {
        driver = new FirefoxDriver();
        driver.get("https://www.baidu.com");
        Thread.sleep(3000);
        //浏览器后退的操作
        driver.navigate().back();
        Thread.sleep(3000);
        driver.quit();
     }

     @Test
    public  void  getIe() throws InterruptedException {
        System.setProperty("webdriver.ie.driver","E:\\idea\\IEDriverServer\\IEDriverServer.exe");
       driver = new InternetExplorerDriver();
         driver.get("https://www.baidu.com");
         Thread.sleep(3000);
         driver.navigate().back();
         Thread.sleep(3000);
         //前进
         driver.navigate().forward();
         Thread.sleep(3000);
         driver.quit();

     }

    @Test
    public  void  getChrome() throws InterruptedException {
        System.setProperty("webdriver.ie.driver","E:\\idea\\IEDriverServer\\IEDriverServer.exe");
         driver = new InternetExplorerDriver();
        driver.get("https://www.google.com.hk");
        Thread.sleep(3000);
        //刷新
        driver.navigate().refresh();
        Thread.sleep(3000);
        //前进
        driver.navigate().forward();
        Thread.sleep(3000);
        driver.quit();

    }

    @Test
    public  void   minMaxBrowser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","E:\\idea\\chromedriver\\chromedriver.exe");
        //:2：实例化 ChromeDriver实例化
          driver= new ChromeDriver();
        //实例化窗口大小，设置窗口大小
        Dimension dimension = new Dimension(500,500);
        driver.manage().window().setSize(dimension);

        Thread.sleep(3000);
        //窗口最大化
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public  void   getUrl() throws InterruptedException {
         driver = new FirefoxDriver();
        //设置浏览器的款和高
        Dimension dimension = new Dimension(300,300);
        driver.manage().window().setSize(dimension);
        Thread.sleep(3000);
        //设置最大化
        driver.manage().window().maximize();
        //获取当前页面的URL
         driver.get("https://www.baidu.com");
      String url =    driver.getCurrentUrl();
      System.out.println("获取当前的URL:" + url);
      //校验是不是百度地址
        Assert.assertEquals(url , "https://www.baidu.com/");
    }

    @AfterMethod
    public  void  closeBrowser(){
        driver.quit();
    }



}
