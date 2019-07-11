package com.cbt.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class VytrackTitleTest {

    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();       // 1.
        driver.manage().window().maximize();

        driver.get("http://qa1.vytrack.com/user/login");       // 2.

        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

        driver.findElement(By.id("prependedInput")).sendKeys("storemanager90");

        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");

        driver.findElement(By.id("_submit")).click();       // 3.

        driver.findElementByClassName("dropdown-toggle").click();       // 4.

        String text = driver.findElementByClassName("dropdown-toggle").getText();
        System.out.println(text);

        driver.findElementByXPath("//a[.='My Configuration']").click();     // 5.

        System.out.println(driver.getTitle());

        Assert.assertTrue(driver.getTitle().startsWith(text));      // 6.
    }
}