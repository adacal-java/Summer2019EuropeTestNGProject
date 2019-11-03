package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyURLnotchanged {

    /**open chrome
     go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.
     click on Retrieve password
     verify that url did not change
     */

    public static void main(String[] args) {

        //open chrome
        WebDriver driver= WebDriverFactory.getDriver("chrome");

        //go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //save URL to string variable
        String expectedUrl=driver.getCurrentUrl();

        //click on Retrive password
        //WebElement....class represents elementts on the webpage
        //findElement..method used to find element
        WebElement retrievePasswordButton=driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        //save url after clicking
        String actualUrl=driver.getCurrentUrl();

        if (expectedUrl.equals(actualUrl)){
            System.out.println("Pass");
        }else{
            System.out.println("fail");
        }
          //close the browser
        driver.quit();

    }
}
