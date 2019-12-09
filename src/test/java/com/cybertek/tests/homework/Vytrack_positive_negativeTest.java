package com.cybertek.tests.homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Vytrack_positive_negativeTest {

    WebDriver driver = WebDriverFactory.getDriver("chrome");

    @BeforeClass
    public void goWebPage() {

        driver.get("https://qa1.vytrack.com/user/login");
    }

    @Test
    public void validLogin(){

        WebElement username= driver.findElement(By.id("prependedInput"));
        username.sendKeys("user30");

        WebElement password= driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");

        WebElement submitButton=driver.findElement(By.name("_submit"));
        submitButton.click();

        String actualURL=driver.getTitle();
        String expectedURL="Dashboard";
        Assert.assertTrue(actualURL.equals(expectedURL), "Verify that the user login successfully");
    }


    @Test
    public void InvalidLogin() {
        WebElement username1 = driver.findElement(By.id("prependedInput"));
        username1.sendKeys("ususus");

        WebElement password1 = driver.findElement(By.id("prependedInput2"));
        password1.sendKeys("768787");

        WebElement submitButton1 = driver.findElement(By.name("_submit"));
        submitButton1.click();


        String actualMessage = driver.findElement(By.xpath("//div[@class='alert alert-error']/div[1]")).getText();
        String expectedMessage = "Invalid user name or password.";

        Assert.assertTrue(actualMessage.equals(expectedMessage),"Verify that the system shows error message “Invalid user name or password.");
    }


    @AfterClass
    public void closeBrowser(){
           driver.quit();

    }



}
