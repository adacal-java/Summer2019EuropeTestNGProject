package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NameLocatorTest {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullNameInput=driver.findElement(By.name("full_name"));
        fullNameInput.sendKeys("Mike Smith");

        //task
        //fill out email and click sign up button
        WebElement email=driver.findElement(By.name("email"));
        email.sendKeys("ada@gmail.com");

        WebElement signUpButton=driver.findElement(By.name("wooden_spoon"));
        signUpButton.click();

       //verify that you got message
        WebElement message=driver.findElement(By.name("signup_message"));
        String actualMessage=message.getText();
        String expectedMessage="Thank you for signing up. Click the button below to return to the home page.";

        if (expectedMessage.equals(actualMessage)){
            System.out.println("Pass");
        }else{
            System.out.println("fail");
            System.out.println("expectedMessage = " + expectedMessage);
            System.out.println("actualMessage = " + actualMessage);
        }

        driver.quit();
    }
}
