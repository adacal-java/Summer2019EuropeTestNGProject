package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedDemo {
    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement usernameInput=driver.findElement(By.id("username"));
        //isDisplayed;;;;>return true if it is visible on the page>
        // >>>>if the element in in the html code
        //it will return false, if displayed it will return true
        System.out.println(usernameInput.isDisplayed());
        Assert.assertFalse(usernameInput.isDisplayed(), "Verify that username input is not displayed");

        WebElement startButton =driver.findElement(By.cssSelector(".btn.btn-primary"));// "#start>button"
        startButton.click();
        Thread.sleep(6000);
        System.out.println(usernameInput.isDisplayed());
        Assert.assertTrue(usernameInput.isDisplayed(), "Verify that username input is displayed");

    }
}

