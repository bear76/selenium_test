package testday02;

import org.apache.bcel.generic.Select;
import org.apache.bcel.generic.Visitor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class selecTest {
    WebDriver driver;
    @BeforeMethod
    public  void  openChrome(){
        System.setProperty("webdriver.chrome.driver","E:\\idea\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

     @Test
     public  void   selectIndex() throws InterruptedException {
        driver.get("file:///E:/idea/selenium_html/index.html");
        WebElement  selecttor =  driver.findElement(By.id("moreSelect"));

         //Select select = new  Select(selecttor);


         Thread.sleep(3000);

     }

    @AfterMethod
    public  void  close(){
        driver.quit();
    }

}
