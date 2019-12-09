package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iframes {
    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){

        driver = WebDriverFactory.getDriver("chrome");
    }


    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/iframe");

        //how to switch frames
        //1.switch by using name or id attribute of iframe
        driver.switchTo().frame("mce_0_ifr");

        //clear the txt inside the box
        driver.findElement(By.id("tinymce")).clear();

        //locate and send some text
        driver.findElement(By.id("tinymce")).sendKeys("we use id");

        //go back to first frame, useful when we have switched multiple frames. [GOES FIRST]
       driver.switchTo().defaultContent();

       //2.using index, only one child put 0
        driver.switchTo().frame(0);

        driver.findElement(By.id("tinymce")).clear();
        driver.findElement(By.id("tinymce")).sendKeys("we use index here");


        //go back to first frame, only to parent[GOES ONE PARENT UP]
        driver.switchTo().parentFrame();


        //3.using webelement
        WebElement frameElement=driver.findElement(By.tagName("iframe"));

        //passing frame as a webelement
        driver.switchTo().frame(frameElement);

        //locate and send some text
        driver.findElement(By.id("tinymce")).sendKeys("We Located with WebElement");


    }
    @Test
    public void multipleFrames() {
        driver.get("http://practice.cybertekschool.com/nested_frames");

        //html
        //---frame top
        // .....0..... frame-left
        //......1..... frame-middle
        //......2......frame-right
        //--frame-bottom


            //switching to frame top
            driver.switchTo().frame("frame-top");
            //frame top has 3 childen frame , left middle and right
            //switching to middle frame
            driver.switchTo().frame("frame-middle");
            //get the middle text and print it
            System.out.println(driver.findElement(By.id("content")).getText());
            //go back to parent (top frame) to switch right
            driver.switchTo().parentFrame();
            //switching right using index
            driver.switchTo().frame(2);
            //print right from right frame
            System.out.println(driver.findElement(By.tagName("body")).getText());
            //go up to top level html directly
            driver.switchTo().defaultContent();
            //switch to frame bottom
            driver.switchTo().frame(1);
            System.out.println(driver.findElement(By.tagName("body")).getText());
        }


    }