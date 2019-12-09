package com.cybertek.tests.homework;


import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class vytrack_positivetest {
    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("https://qa1.vytrack.com/user/login");

        WebElement username= driver.findElement(By.id("prependedInput"));
        username.sendKeys("user30");

        WebElement password= driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");

        WebElement submitButton=driver.findElement(By.name("_submit"));
        submitButton.click();
        String actualTitle=driver.getTitle();
        String expectedTitle="Dashboard";  //getResult(String expected, String actual)

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expectedTitle = " + expectedTitle);
            System.out.println("actualTitle = " + actualTitle);
        }

        driver.close();


        //div[@class='alert alert-error']/div[1]

        //WebElement fleet=driver.findElement(By.partialLinkText("fleet"));
       // fleet.click();

    }

}
