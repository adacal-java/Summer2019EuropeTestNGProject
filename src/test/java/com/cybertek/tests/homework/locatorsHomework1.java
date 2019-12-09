package com.cybertek.tests.homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class locatorsHomework1 {
    /*Test case 1
Go to ebay
enter search term
click on search button
print number of results*/
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("https://www.ebay.co.uk/");

       WebElement searchBox= driver.findElement(By.xpath("//input[@name='_nkw']"));


       searchBox.sendKeys("slippers");
       Thread.sleep(3000);
        WebElement alert= driver.findElement(By.id("gdpr-banner-accept"));
        alert.click();

       driver.findElement(By.id("gh-btn")).click();
       WebElement result=driver.findElement(By.tagName("h1"));
       String [] arr=result.getText().split(" results");
        System.out.println(arr[0]);

driver.quit();



    }
}
