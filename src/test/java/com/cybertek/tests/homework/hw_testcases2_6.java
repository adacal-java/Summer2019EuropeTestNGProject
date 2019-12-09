package com.cybertek.tests.homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class hw_testcases2_6 {

             @Test
            public void test6 () {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.tempmailaddress.com/");
        String mailaddress= driver.findElement(By.id("email")).getText();
        driver.navigate().to("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        driver.findElement(By.name("full_name")).sendKeys("svshvsjhvjhsv");
        driver.findElement(By.name("email")).sendKeys(mailaddress);
        driver.findElement(By.cssSelector(".radius")).click();
        String signupMessage= driver.findElement(By.name("signup_message")).getText();
        String actualSignupMessage="Thank you for signing up. Click the button below to return to the home page." ;
        Assert.assertEquals(signupMessage,actualSignupMessage,"Verify the message is displayed");

        driver.get("https://www.tempmailaddress.com/");
                                      ////*[@id="schranka"]/tr[1]/td[1]/text()    bu otomtaik copyxpath
               //  Assert.assertTrue(driver.findElement(By.cssSelector("tbody#schranka td:nth-of-type(1)")).isDisplayed());
        //assert calisiyor
                 driver.findElement(By.id("schranka")).click();
      String receivedEmailFrom=driver.findElement(By.id("odesilatel")).getText();
      String expectedEMailFrom="do-not-reply@practice.cybertekschool.com";
      Assert.assertEquals(receivedEmailFrom, expectedEMailFrom,"Verify the message from cybertek");


      String expectedSubject="Thanks for subscribing to practice.cybertekschool.com!";
      String actualSubject= driver.findElement(By.id("predmet")).getText();
      Assert.assertTrue(actualSubject.equals(expectedSubject), "Verify that subject is: 'Thanks for subscribing to practice.cybertekschool.com!'");

    }
}
