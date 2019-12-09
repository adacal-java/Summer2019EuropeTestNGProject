package com.cybertek.tests.homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class locatorsHomework3 {
   /* Go to wikipedia.org (Links to an external site.)
    enter search term `selenium webdriver`
    click on search button
    click on search result `Selenium (software)`
    verify url ends with `Selenium_(software)'

    */
   public static void main(String[] args) {
       WebDriver driver= WebDriverFactory.getDriver("chrome");
       driver.get("https://www.wikipedia.org/");
       driver.findElement(By.xpath("//*[@id='searchInput']")).sendKeys("selenium webdriver");
       driver.findElement(By.xpath("//button [@*='submit']")).click();

       driver.findElement(By.xpath("//*[@title='Selenium (software)']")).click();
       String currentUrl=  driver.getCurrentUrl();

       if (currentUrl.endsWith("Selenium_(software)")){
           System.out.println("pass");
       }else {
           System.out.println("fail");
           System.out.println("currentUrl = " + currentUrl);

       }
   }



}
