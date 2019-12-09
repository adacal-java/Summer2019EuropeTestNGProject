package com.cybertek.tests.homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class locatorsHomework2 {
    public static void main(String[] args) throws InterruptedException {
 /*go to amazon
Go to ebay
enter search term
click on search button
verify title contains search term*/
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.co.uk/");
        driver.navigate().to("https://www.ebay.co.uk/");
        driver.manage().window().maximize();

        WebElement searchBox2=driver.findElement(By.xpath("//*[@label='Search for anything']"));
        searchBox2.sendKeys("clutch");
      //  Thread.sleep(3000);
       // WebElement alert= driver.findElement(By.id("gdpr-banner-accept"));
       // alert.click();


        driver.findElement(By.xpath("//input[@type='submit']")).click();

        String expectedItem="clutch";

        String actualItem=driver.getTitle();



        if (actualItem.contains(expectedItem)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("actualItem = " + actualItem);
            System.out.println("expectedItem = " + expectedItem);
        }

     driver.quit();
}
    }
