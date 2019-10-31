package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDemo {
    public static void main(String[] args) throws InterruptedException {
        //
        WebDriverManager.chromedriver().setup();

        //import class CMD+ENTER or ALT+enter or CONTROL +SPACE
        //selenium object
        WebDriver driver = new ChromeDriver();

        //navigate to website
        driver.get("https://www.google.com");

        Thread.sleep(5000);

        //another way of opening website
        driver.navigate().to("https://www.facebook.com");

        //go back to previous webpage
        driver.navigate().back();

        //stops your code base on milisecond -3000- 3second wait
        Thread.sleep(3000);

        //
        driver.navigate().forward();

        //refresh the page
        driver.navigate().refresh();

    }
}
