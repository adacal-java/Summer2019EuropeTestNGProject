package com.cybertek.tests.homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class vytrack_negativetest {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://qa1.vytrack.com/user/login");

        WebElement username1 = driver.findElement(By.id("prependedInput"));
        username1.sendKeys("ususus");

        WebElement password1 = driver.findElement(By.id("prependedInput2"));
        password1.sendKeys("768787");

        WebElement submitButton1 = driver.findElement(By.name("_submit"));
        submitButton1.click();
        String actualMessage = driver.findElement(By.xpath("//div[@class='alert alert-error']/div[1]")).getText();
            String expectedMessage = "Invalid user name or password.";

        if (actualMessage.equals(expectedMessage)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("expectedMessage = " + expectedMessage);
            System.out.println("actualMessage = " + actualMessage);
        }
    }
}