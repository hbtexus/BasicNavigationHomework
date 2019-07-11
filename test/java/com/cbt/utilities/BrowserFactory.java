package com.cbt.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.sql.Driver;

public class BrowserFactory {
    public static WebDriver getDriver(String browser) {
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/hb/Documents/Selenium Dependencies/Drivers/chromedriver");
            return new ChromeDriver();
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "/Users/hb/Documents/Selenium Dependencies/Drivers/geckodriver");
            return new FirefoxDriver();
        }else if (browser.equals("safari")) {
            return new SafariDriver();
        } else {
            return null;
        }
    }
}
