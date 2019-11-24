package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupsAndAlerts {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver= WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }

    @Test
    public void htmlPopUp(){                        //CHECK//

        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");

        driver.findElement(By.xpath("//*[text()='Destroy the World']")).click();

        driver.findElement(By.cssSelector(".ui-button-text.ui-c")).click();

    }

    @Test
    public void Alerts() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        //click for JS alert
        driver.findElement(By.xpath("//button[1]")).click();

        //TO DEAL WITH non html alert , we have special class "Alert" to control alert
        Alert alert= driver.switchTo().alert();
        Thread.sleep(2000);

        //clicking ok in the alert
        alert.accept();

        driver.findElement(By.xpath("//button[2]")).click();

        //
        alert.dismiss();

        driver.findElement(By.xpath("//button[3]")).click();

        //send some keys
        alert.sendKeys("Mike Smith");
        Thread.sleep(500);
        alert.accept();

    }
}
