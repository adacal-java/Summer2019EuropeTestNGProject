package com.cybertek.tests.homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class hw_testcases2_8 {

    @Test
    public void testCase8(){
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Autocomplete")).click();
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        driver.findElement(By.cssSelector("input[value='Submit'] ")).click();
        String actualMessage=driver.findElement(By.id("result")).getText();
        String expectedMessage="You selected: United States of America";

        Assert.assertEquals(actualMessage, expectedMessage, "Verify that following message is displayed: 'You selected: United States of America'");
    }
}
