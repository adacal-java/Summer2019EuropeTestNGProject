package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathTest {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");

        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("selenium");

        WebElement goButton=driver.findElement(By.xpath("//input[@value='Go']"));
        goButton.click();

        WebElement text=driver.findElement(By.xpath("//span[contains(text(),'results')]"));
        String total=text.getText();
        System.out.println(total);



    }

}
