package com.cbt.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.sql.SQLOutput;

public class EbaySearchTest {

    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();   // 1.
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com");     // 2.

        WebElement search = driver.findElementByCssSelector("#gh-ac");
        search.sendKeys("wooden spoon", Keys.ENTER);        // 3.
        WebElement result = driver.findElement(By.className("srp-controls__count-heading"));

        String results = result.getText();
        results = results.replaceAll("[^0-9]", "");
        int res1 = Integer.parseInt(results);       // 4.
        System.out.println("Result of search : " + res1);

        WebElement all = driver.findElement(By.xpath("//*[.='All']"));
        all.click();        // 5.

        WebElement allResult = driver.findElement(By.cssSelector(".srp-controls__count-heading"));
        String ar = allResult.getText();
        ar = ar.replaceAll("[^0-9]", "");
        int res2 = Integer.parseInt(ar);
        System.out.println("Result of All search : " + res2);

        if (res1 < res2) {          //6.
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        driver.navigate().back();       // 7.
        Thread.sleep(3000);

        WebElement searchBack = driver.findElementByCssSelector("#gh-ac");
        searchBack.click();
        System.out.println("***" + driver.findElementByCssSelector("#gh-ac").getText());
        System.out.println(searchBack.getAttribute("value"));

        if(searchBack.getAttribute("value").equals("wooden spoon")){    // 8.
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        driver.navigate().back();       // 9.

        WebElement searchAtHomePage = driver.findElementByCssSelector("#gh-ac");
        searchAtHomePage.click();
        String g = searchAtHomePage.getText();

        if(g.equals("")){    // 8.
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
    }
}
