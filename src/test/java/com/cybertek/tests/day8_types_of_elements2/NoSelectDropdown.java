package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class NoSelectDropdown {


    @Test

    public void test1(){
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement dropdownElement=driver.findElement(By.id("dropdownMenuLink"));

          //open the dropdown
        dropdownElement.click();

        List<WebElement> listofLinks = driver.findElements(By.className("dropdown-item"));

        //size of the list
        System.out.println("Number of list"+ listofLinks.size());

         //text of first element in the list
        System.out.println(listofLinks.get(0).getText());


        //print text of each link
        for (WebElement listofLink : listofLinks) {
            System.out.println(listofLink.getText());
        }

        // LOCATE THE ELEMENT AND CLICK IT
     //   driver.findElement(By.linkText("Yahoo")).click();

       //index of the list and click
        listofLinks.get(3).click();


    }
}
