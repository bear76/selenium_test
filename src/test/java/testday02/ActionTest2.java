package testday02;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;


public class ActionTest2 {
    WebDriver driver;
    @BeforeMethod
    public  void  openChrome(){
        System.setProperty("webdriver.chrome.driver","E:\\idea\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void clickTest(){
        driver.get("https://www.baidu.com");
        WebElement buttonbd = driver.findElement(By.id("su"));
        //实例化Actions
        Actions actions = new Actions(driver);
        //右键双击  buttion
         actions.contextClick(buttonbd).perform();
    }

    @Test
    public  void  doubleclick(){
        driver.get("https://www.baidu.com");
        WebElement buttion =   driver.findElement(By.id("su"));
        Actions actions = new Actions(driver);
        //双击。preform(执行)
        actions.doubleClick(buttion).perform();
    }

    @Test
    public  void   move() throws InterruptedException {
        driver.get("file:///E:/idea/webdriver_demo/selenium_html/index.html");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"action\"]/input"));

        //把鼠标移动到按钮上
         Actions actions = new Actions(driver);
         actions.moveToElement(element).perform();
         Thread.sleep(3000);
         //鼠标移动到按钮上会显示  ：hello worle：
        String hello= driver.findElement(By.xpath(".//*[text()='Hello World!']")).getText();
        Assert.assertEquals(hello,"Hello World");
    }

    @Test
   // 把元素拖拽到500，500的xy轴
    public  void  testDrop() throws InterruptedException {
        driver.get("file:///E:/idea/webdriver_demo/selenium_html/dragAndDrop.html");
        WebElement element = driver.findElement(By.id("drag"));
        Actions actions = new Actions(driver);
        //把元素拖拽到500，500的xy轴
        actions.dragAndDropBy(element,500,500).perform();
        Thread.sleep(4000);
    }

    @Test
    //把一个元素拖拽到另外一个元素上面
    public  void  dropTest() throws InterruptedException {
        driver.get("file:///E:/idea/webdriver_demo/selenium_html/dragAndDrop.html");
        //获取2个元素的点位
         WebElement ele1 =     driver.findElement(By.id("drag"));
          WebElement ele2 = driver.findElement(By.xpath("/html/body/h1"));
          Thread.sleep(2000);
          //实例化Actions
          Actions actions = new Actions(driver);
          //点击元素ele1
          actions.clickAndHold(ele1)
                  //把元素ele1移动到ele2上面去
                  .moveToElement(ele2)
                  //然后松开ele1
                  .release(ele1)
                  //执行
                   .perform();
          Thread.sleep(3000);
    }

    @Test
    //选择下拉框显示的值，选择几个值，模拟键盘的ctrl键，也可以选择其它键
    public  void  moreSelectTest() throws InterruptedException {
        driver.get("file:///E:/idea/webdriver_demo/selenium_html/index.html");
      WebElement element =  driver.findElement(By.id("selectWithMultipleEqualsMultiple"));
      //获取整个List的值
      List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"selectWithMultipleEqualsMultiple\"]/option"));
     //实例化Actions
        Thread.sleep(3000);
      Actions actions =new Actions(driver);
      //点击ctrl键
      actions.keyDown(Keys.CONTROL)
              //默认第一个已经选择了，所以直接选择第三个。List默认的第一个值是0.
              .click(list.get(2))
              //释放按下的ctrl键
              .keyUp(Keys.CONTROL)
              //执行
              .perform();
        Thread.sleep(2000);
    }

    @Test
    //这是保存百度见面，ctrl+s .  enter
    public  void  savaHtml() throws AWTException, InterruptedException {
        driver.get("https://www.baidu.com");
        //Robot选择的是Java .awt  这个。实例化Robot
        Robot robot = new Robot();
        //点击ctrl .KeyEvent(JAVA.awt)
        Thread.sleep(2000);
          robot.keyPress(KeyEvent.VK_CONTROL);
          //s键
          robot.keyPress(KeyEvent.VK_S);
          Thread.sleep(2000);
          //enter
          robot.keyPress(KeyEvent.VK_ENTER);
    }

    @Test
    //上传图片。用sendkeys
    public  void  uploadImgeTest() throws InterruptedException {
        driver.get("file:///E:/idea/webdriver_demo/selenium_html/index.html");
        //用sendkeys方法上传图片，图片是电脑的路径
        driver.findElement(By.id("load")) .sendKeys("D:\\Users\\Geoffery\\Pictures\\abc.jpg");
        Thread.sleep(5000);
    }

    @Test
    //下拉框的处理
    public  void selectTest() throws InterruptedException {
        driver.get("file:///E:/idea/webdriver_demo/selenium_html/index.html");
        WebElement element = driver.findElement(By.name("select"));
        Select select = new Select(element);
        //通过下标来选择.默认第一个值是从0下标开始
        select.selectByIndex(1);
        Thread.sleep(5000);
        //通过value值来选择
        select.selectByValue("meizu");
        Thread.sleep(5000);
        //通过标签之间的text值来选择
        select.selectByVisibleText("huawei");
        Thread.sleep(3000);
    }


    @AfterMethod
    public  void  close(){
        driver.quit();
    }
}
