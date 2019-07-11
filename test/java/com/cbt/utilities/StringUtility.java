package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

public class StringUtility {
    public static void verifyEquals (String expected, String actual){

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();

        actual = driver.getTitle();
        expected = "Google";

        if (actual.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Expected = " + expected);
            System.out.println("Actual = " + actual);
        }

    }
}
