package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SelectClassTest {

    @Test
    public void test1() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");

        //1.locate the dropdown element with unique locator
        WebElement  dropdownElement=driver.findElement(By.id("state"));

        //create Select object by passing the element as a constructor
        //Select class , i create constructor to reach methods by "stateList."
        Select stateList=new Select(dropdownElement);
          //Select stateList=new Select(driver.findElement(By.id("state"));

        //getOptions---->>>>returns all the available options from the dropdownList
       List<WebElement> options = stateList.getOptions();

        for (WebElement option:options){
            System.out.println(option.getText());
        }


        }


      @Test
      public void test2() throws InterruptedException {
          WebDriver driver = WebDriverFactory.getDriver("chrome");
          driver.get("http://practice.cybertekschool.com/dropdown");

          //1.locate the dropdown element with unique locator
          WebElement dropdownElement = driver.findElement(By.id("state"));

          //create Select object by passing the element as a constructor
          Select stateList = new Select(dropdownElement);

          //VERIFY that first option is "select state"
          String expectedOption="Select a State";
          String actualOption=stateList.getFirstSelectedOption().getText();
          System.out.println(actualOption);
          Assert.assertEquals(actualOption,expectedOption,"Verify first selection is selected a state");

//how to select options from the dropdown
          //1.using visible text
          //;;;;;;;;;;selecteing based on the visible text
          Thread.sleep(2000);
          stateList.selectByVisibleText("Texas");  //selecteing texas from the list

          actualOption=stateList.getFirstSelectedOption().getText();
          Assert.assertEquals(actualOption,"Texas");

          //USING index number
          Thread.sleep(2000);
          stateList.selectByIndex(51);  //size()-1
          actualOption=stateList.getFirstSelectedOption().getText();
          Assert.assertEquals(actualOption, "Wyoming");

          //3.Using VAlues
          Thread.sleep(2000);
          stateList.selectByValue("VA");
          System.out.println(stateList.getFirstSelectedOption().getText());




      }

}
