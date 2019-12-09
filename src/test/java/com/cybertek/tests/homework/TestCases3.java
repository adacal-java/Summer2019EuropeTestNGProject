package com.cybertek.tests.homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCases3 {


    WebDriver driver;


    @BeforeMethod
    public void setUpMethod() throws InterruptedException {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://qa1.vytrack.com/");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        Thread.sleep(5000);

        WebElement activities=driver.findElement(By.linkText("Activities"));

        Actions hover=new Actions(driver);
        hover.moveToElement(activities).perform();

        driver.findElement(By.linkText("Calendar Events")).click();

    }


    @AfterMethod
    public void driverClose(){
        driver.quit();
    }


    @Test
    public void testCase1() throws InterruptedException {


        //WebElement activities=driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[5]"));

      //  Actions hover= new Actions(driver);
       // hover.moveToElement(activities).perform();

      //  WebElement calendarEvents=driver.findElement(By.linkText("Calendar Events"));
        //hover.moveToElement(calendarEvents).perform();
       // calendarEvents.click();
       Thread.sleep(5000);


        String actualPageSubtitle=driver.findElement(By.xpath("//*[@class='btn btn-link dropdown-toggle' and @data-toggle='dropdown']")).getText();
       // System.out.println(actualPageSubtitle);
       String expectedPageSubtitle="Options";
       Assert.assertTrue(actualPageSubtitle.equals(expectedPageSubtitle), "verify page subtitle 'Options' is displayed");

    }

    @Test
    public void testCase2() throws InterruptedException {
        Thread.sleep(5000);

        String pageNumber=driver.findElement(By.xpath("//input[@type='number']")).getAttribute("value");

        Assert.assertEquals(pageNumber, "1", "verify page number is 1");

    }

    @Test
    public void testCase3() throws InterruptedException {
        Thread.sleep(5000);

      String actualno= driver.findElement(By.cssSelector("button[class='btn dropdown-toggle ']")).getText();
        System.out.println("actualno = " + actualno);
      String expectedno="25";
      Assert.assertEquals (actualno,expectedno,"verify page number is 25");
    }



     @Test
     public void testCase4(){

}





    @Test
    public void testCase5() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
       // WebElement dropbox=driver.findElement(By.cssSelector("input[type='checkbox']"));
       // Select checkbox=new Select(dropbox);


        WebElement select = driver.findElement(By.xpath("//i[@class='caret']"));

        WebElement clickAll = driver.findElement(By.xpath("//*[@href='#' and contains(text(),'All')]"));

        executor.executeScript("arguments[0].click();", select);
        executor.executeScript("arguments[0].click();", clickAll);


         List<WebElement>boxes=driver.findElements(By.cssSelector("input[data-role='select-row-cell']"));
        System.out.println(boxes.size());

         for (WebElement box : boxes) {
            Assert.assertTrue(box.isSelected());
        }

    }




}
