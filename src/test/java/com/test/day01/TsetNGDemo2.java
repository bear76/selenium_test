package com.test.day01;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TsetNGDemo2 {
    //校验a==a
    @Test
    public void assertEqualTest() {
        String a = "abc";
        String b = "abc111";
  /*      if (a.equals(b)) {
            System.out.println("正确");
        } else {
            System.out.println("错误");
        }
    }*/
       // Assert.assertEquals(a,b, message:"a不等于b");
        Assert.assertEquals(a,b);
    }

      @Test
       public void assertNotEquals(){
        int a=1;
        int b=2;
          Assert.assertNotEquals(a,b);
      }

    @Test
    public void assertNullTest(){
        String a = null;

        Assert.assertNull( a  );
    }

    @Test
    public void assertNotNullTest(){
        String a = "xiong";

        Assert.assertNotNull( a  );
    }

}

