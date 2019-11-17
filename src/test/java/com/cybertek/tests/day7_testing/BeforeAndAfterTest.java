package com.cybertek.tests.day7_testing;

import org.testng.annotations.*;

public class BeforeAndAfterTest {
    @Test
    public void test1(){
        System.out.println("this is my test one");
        //-----beginning of the each test
        //webdriver code
        //open browser
        //maximize window(some settings before test)

        //------after each
        //close browser

    }
    @Ignore
    @Test
    public void test2(){

        System.out.println("This my test two");
    }

    @Test
    public void test3(){
        System.out.println("this is my test three");
    }


    @BeforeMethod
    public void setUpMethod(){
        System.out.println("BEFORE METHOD ");
        System.out.println("OPENING THE BROWSER");

    }


    @AfterMethod
    public void tearDown(){
        System.out.println("CLOSE BROWSER");
    }

    @BeforeClass
        public void beforeEverything(){
        System.out.println("BEFORE CLASS CODE");
        }

        @AfterClass
    public void afterClass(){
            System.out.println("AFTER CLASS CODE");
            System.out.println("REPORTING");
        }

    }



