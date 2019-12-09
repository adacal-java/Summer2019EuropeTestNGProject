package com.cybertek.tests.homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class hw_testcases2_7 {


    @Test
    public void testCase6() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.cssSelector("a[href='/upload']")).click();

        //TO UPLOAD FILE..............DONT CLICK.....SEND KEYS(...path....)
        driver.findElement(By.id("file-upload")).sendKeys("C:/Users/Ada/Desktop/up.txt");
        driver.findElement(By.id("file-submit")).click();
        String expectedUploadMessage="File Uploaded!";
        String actualUploadMessage=driver.findElement(By.tagName("h3")).getText();

        Assert.assertEquals(expectedUploadMessage, actualUploadMessage, "Verify that subject is 'File Uploaded!'");

        WebElement uploadedFile=driver.findElement(By.id("uploaded-files"));
        Assert.assertTrue(uploadedFile.isDisplayed(),"Verify that uploaded file name is displayed");
    }
}

