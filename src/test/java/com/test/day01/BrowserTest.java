package com.test.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class BrowserTest {
    @Test
    public void  getTest() throws InterruptedException {
        System.setProperty("webdriver.edge.driver","E:\\idea\\Edge\\MicrosoftWebDriver.exe");
        WebDriver driver =  new EdgeDriver();
        driver.get("https://www.baidu.com"); //打开百度
        Thread.sleep(5000);
        driver.quit();

    }

    @Test
    public  void  backTest() throws InterruptedException {
        System.setProperty("webdriver.edge.driver","E:\\idea\\Edge\\MicrosoftWebDriver.exe");
        WebDriver driver =  new EdgeDriver();
        driver.get("https://www.baidu.com");
        Thread.sleep(5000);
        driver.navigate().back();//后退
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public  void  forwardTest() throws InterruptedException {
        System.setProperty("webdriver.edge.driver","E:\\idea\\Edge\\MicrosoftWebDriver.exe");
        WebDriver driver =  new EdgeDriver();
        driver.get("https://www.baidu.com");
        Thread.sleep(5000);
        driver.navigate().back();//后退
        Thread.sleep(3000);
        driver.navigate().forward();//前进
        Thread.sleep(3000);
        driver.quit();
    }

}

