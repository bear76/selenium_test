package com.test.day01;

import com.google.common.annotations.VisibleForTesting;
import org.testng.annotations.*;

public class TsetNGDemo1 {
    @BeforeTest
    public void  beforetestCase1(){
        System.out.println("这就是BeforeTest的注解");
    }
    @BeforeMethod
    public void  beforeMethod(){
        System.out.println("这就是BeforeMethod的注解");
    }

      @Test
    public void testCase1(){
        System.out.println("这就是Test的注解,case1");
        }
    @Test
    public void testCase2(){
        System.out.println("这就是Test的注解，case2");
    }

    @AfterMethod
    public void   afterMethod1(){
        System.out.println("这就是AfterMethod的注解");
    }


    @AfterTest
    public void   afterTest1(){
        System.out.println("这就是AfterTest的注解");
    }


}
