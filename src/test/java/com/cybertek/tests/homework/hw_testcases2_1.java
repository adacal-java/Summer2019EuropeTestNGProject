package com.cybertek.tests.homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class hw_testcases2_1 {

    WebDriver driver;

    @BeforeMethod
   public void setUpMethod(){

        driver= WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void test1(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.cssSelector("a[href='/registration_form']")).click();
        driver.findElement(By.cssSelector("input[name='birthday']")).sendKeys("wrong_dob");
        String actual=driver.findElement(By.cssSelector("small[data-bv-validator='date']")).getText();
       // String actual = driver.findElement(By.xpath("//small[contains(text(),'The date of birth is not valid')]")).getText();
        String expected="The date of birth is not valid";

        Assert.assertTrue(actual.equals(expected), "Verify the warning message is displayed");

    }




    @Test
    public void test2(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.cssSelector("a[href='/registration_form']")).click();
        List<WebElement> options=driver.findElements(By.xpath("//input[@class='form-check-input']/../.."));
        for (WebElement option : options) {
            System.out.println(option.getText());
        }

    }


    @Test
    public void test3(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.cssSelector("a[href='/registration_form']")).click();
        driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("a");
        String expected="first name must be more than 2 and less than 64 characters long";
        String actual= driver.findElement(By.xpath("//small[@class='help-block'][2]")).getText();
       Assert.assertEquals( actual, expected,"Verify the warning message is displayed");

    }



    @Test
    public void test4(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.cssSelector("a[href='/registration_form']")).click();
        driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("a");
        String expected="The last name must be more than 2 and less than 64 characters long";
        String actual= driver.findElement(By.xpath("//small[@data-bv-result='INVALID']")).getText();
        Assert.assertEquals( actual, expected,"Verify the warning message is displayed");

    }


    @Test
    public void test5(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.cssSelector("a[href='/registration_form']")).click();
        driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("Ayse");
        driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("Kara");
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("akarjhjhjha");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("Karajhghgh");
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("asas@gmail.com");
        driver.findElement(By.name("phone")).sendKeys("545-161-197631");
        driver.findElement(By.xpath("//input[@value='male']")).click();
        driver.findElement(By.name("birthday")).sendKeys("12/09/2022");


        //SELECT  FOR DROPDOWN
        Select select=new Select(driver.findElement(By.name("department")));
        select.selectByValue("DE");

        //driver.findElement(By.name("department")).click();
       // List<WebElement> optionList=driver.findElements(By.tagName("option"));
       // optionList.get(3).click();


        driver.findElement(By.name("job_title")).click();
        List<WebElement> optionList2=driver.findElements(By.tagName("option"));
        optionList2.get(optionList2.size()-1).click();

        driver.findElement(By.id("inlineCheckbox3")).isSelected();

        driver.findElement(By.id("wooden_spoon")).click();

        String expected="You've successfully completed registration!";
        String actual=driver.findElement(By.tagName("p")).getText();
        Assert.assertEquals(actual,expected,"Verify success message is displayed");

    }




    @AfterMethod
    public void driverClose(){
        driver.quit();
    }





}
