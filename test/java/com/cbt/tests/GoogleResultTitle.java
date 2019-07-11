package com.cbt.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class GoogleResultTitle {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();    // 1.
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");  // 2.


       List<String> searchStrs = Arrays.asList("Java", "JUnit","REST Assured");

       for (String searchStr: searchStrs) {
           WebElement search = driver.findElementByName("q");
           search.sendKeys(searchStr, Keys.ENTER);             // 3.

          // search.sendKeys(searchStr, Keys.ENTER);
           WebElement link = driver.findElement(By.cssSelector(".iUh30"));
           String actual = link.getText();     // 4.
           System.out.println("Actual link is : " + actual);

           link.click();       // 5.
           String expected = driver.getCurrentUrl();
           System.out.println("Expected link is : " + expected);

           if(actual.equals(expected)){        // 6.
               System.out.println("PASSED");
           }else{
               System.out.println("FAILED");
           }
           driver.navigate().back();
           Thread.sleep(3000);
           driver.findElementByName("q").clear();     // 7.
        }
    }
}
