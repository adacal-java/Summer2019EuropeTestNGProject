package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyUrlChanged {
    /**open browser
     go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.
     enter any email
     click on Retrieve password
     verify that url changed to http://practice.cybertekschool.com/email_sent
     */
    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/forgot_password");

        //enter any email
        WebElement emailInput=driver.findElement(By.name("email"));

        //sendKeys..send keyboard action to webelement
        emailInput.sendKeys("email@gmail.com");

        WebElement retrievePasswordButton=driver.findElement(By.id("form_submit"));//ikisi yerine
        retrievePasswordButton.click(); //driver.findElement(By.id("form_submit")).click();

        String expectedUrl="http://practice.cybertekschool.com/email_sent";
        String actualUrl= driver.getCurrentUrl();

        if (expectedUrl.equals(actualUrl)){
            System.out.println("Pass");
        }else{
            System.out.println("fail");
          //  System.out.println("actualUrl = " + actualUrl);
          //  System.out.println("expectedUrl = " + expectedUrl);
        }

        driver.quit();

    }
}
