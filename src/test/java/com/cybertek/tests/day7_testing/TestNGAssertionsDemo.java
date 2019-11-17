package com.cybertek.tests.day7_testing;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {


    @Test
    public void test1(){
        System.out.println("First Assertion");
        Assert.assertEquals(1,1);

        System.out.println("Second Assertion");
        Assert.assertEquals("title", "titLe");

        System.out.println("after second assertion");
    }


    @Test
    public void test2(){
         //veriify that title startswith c
        String actualTitle="Cybertek";
        String expectedTitleBeginning="C";
        System.out.println("first assertion");
        Assert.assertTrue(actualTitle.startsWith(expectedTitleBeginning), "Verify title starts with C");
      //task
        //verify emaol contaiins @sign
        Assert.assertTrue("vssdvc@gmail.com".contains("@"), "verify @ in mail");
    }

    @Test
    public void test3(){
        Assert.assertNotEquals("one","two");
    }
   @Test
    public void test4(){
        Assert.assertFalse(1<0);
   }

}
