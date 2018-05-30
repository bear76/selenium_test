package com.test.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class OpenBrowserTest {
    //1:默认和手动找路径启动 Firefox浏览器
    @Test
    public  void openFF(){
        //这种方式是默认安装的时候才会启动
        WebDriver  webDriver = new FirefoxDriver();
    }

    @Test
    public  void  openFF2() throws InterruptedException {

      //  webDriver.ge  System.setProperty( "webdriver.gecko.driver" , "E:\\idea\\Firefox\\geckodriver.exe");
        //WebDriver webDriver = new FirefoxDriver();("https://www.taobao.com");
        Thread.sleep(3000);
       // webDriver.close();
    }


    //2:启动chrome 浏览器Browser
    @Test
    public  void  openChrome() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","E:\\idea\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com");
        //获取当前的url  和标题
        String url = driver.getCurrentUrl();
        System.out.println("当前的URL:"+ url);
        Thread.sleep(3000);
        String title = driver.getTitle();
        System.out.println("当前的Title：" + title);
        driver.quit();

    }

    //3:启动IE
    @Test
    public void  openIe(){
       System.setProperty("webdriver.ie.driver","E:\\idea\\iedriver\\IEDriverServer.exe" );
        WebDriver webDriver = new InternetExplorerDriver();
        webDriver.get("https://www.taobao.com");
        webDriver.close();
    }

    @Test
    public  void  openEdge(){
        System.setProperty("webdriver.edge.driver","E:\\idea\\Edge\\MicrosoftWebDriver.exe");
        WebDriver webDriver =  new EdgeDriver();
        webDriver.get("https://www.baidu.com");
        String url =  webDriver.getCurrentUrl();
         System.out.println("当前的URL"  + url);
         webDriver.close();
    }
}
