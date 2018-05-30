package day04;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class datadriver {
    @DataProvider(name = "loginuser")
   public Object[][] data1(){
        return new Object[][]{{"user1","pwd1"}, {"user2","pwd2"}};
    }
//调用数据
    @Test(dataProvider = "loginuser")
    public  void  test1(String user ,String pwd){
        System.out.println("user" + user );
        System.out.println("pwd" + pwd);
    }
}
