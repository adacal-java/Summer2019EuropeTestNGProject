package com.cybertek.tests.homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class hw_testcases2_9_12 {
     WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver=WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void driverClose(){

        driver.quit();
    }



    @Test(dataProvider = "statusCodes")
    public void testcases9(Object code){
      driver.get("https://practice-cybertekschool.herokuapp.com/");
      driver.findElement(By.cssSelector("a[href='/status_codes']")).click();
    }

    @DataProvider(name = "statusCodes")
    public Object[] myDataProvider(){
        Object [][] obj=new Object[4][1];
        obj[0][0]= 200; //driver.findElement(By.xpath("//div/ul/li[1]/a"));
        obj[1][0]=301; //driver.findElement(By.xpath("//div/ul/li[2]/a"));
        obj[2][0]=404; //driver.findElement(By.xpath("//div/ul/li[3]/a"));
        obj[3][0]=500; //driver.findElement(By.xpath("//div/ul/li[4]/a"));

        return obj;
    }

     @Test
    public void testcase9(){

         driver.findElement(By.xpath("//div/ul/li[1]/a")).getText();
         String actualMessage= driver.findElement(By.xpath("//p")).getText();
         String expectedMessage= "This page returned a 200 status code";
         Assert.assertEquals(actualMessage, expectedMessage,"This page returned a 200 status code");

     }
}
