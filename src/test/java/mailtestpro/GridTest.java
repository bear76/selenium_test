package mailtestpro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GridTest {
    @Test
    public  void  testChrome() throws MalformedURLException, InterruptedException {
        //创建一个 DesiredCapabilities
        DesiredCapabilities  dc = DesiredCapabilities.chrome();
        //实例化driver 。这里的端口号可手动变化
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.2:6666/wd/hub"),dc);
        driver.get("http://www.baidu.com");
        Thread.sleep(10000);
        driver.quit();
    }

    @DataProvider(name ="data4")
    public  Object [][] test1() {
            return new Object[][]{
                    {"firefox","http://192.168.1.2:5555"},
                    {"chrome","http://192.168.1.2:6666"}};
            }


         @Test(dataProvider = "data4")
         public void  testGrid2(String browser,String  url ) throws InterruptedException, MalformedURLException {
            DesiredCapabilities dc = null;
            if (browser.contentEquals("firefox")){
                dc = DesiredCapabilities.firefox();
            }else  if (browser.equals("chrome")) {
                dc=DesiredCapabilities.chrome();
            }else {
                System.out.println("error");
            }
             WebDriver driver = new RemoteWebDriver(new URL(url+"/wd/hub"),dc);
             driver.get("http://www.baidu.com");
             Thread.sleep(10000);
             driver.quit();
         }

}