package mailtestpro;

import org.testng.annotations.Test;

public class timechuo {
    @Test
    public void  timeTest(){

       String timea= String.valueOf(System.currentTimeMillis());
       System.out.println(timea);
    }
}
