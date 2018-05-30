package day03;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSTest {
    WebDriver driver;
    @BeforeMethod
    public  void  openChrome(){
        System.setProperty("webdriver.chrome.driver","E:\\idea\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    //其实就是设置HTML前端见面某个参数的值。为了校验前端的某些值。
    //比如：校验前端说只能整数。但是为实现Case，输入小数
    public  void  jsTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        //driver强制转化JS
        JavascriptExecutor  js = (JavascriptExecutor) driver;
        //绿色的是在浏览器里面设置的
        js.executeScript("document.getElementById(\"kw\").setAttribute(\"value\",\"webdriver\");");
        Thread.sleep(5000);
    }

    @AfterMethod
    public  void  closeBrow(){
        driver.quit();
    }


}
