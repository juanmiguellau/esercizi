package org.example;

import org.apache.hc.core5.util.Timeout;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DriverUtil {
    WebDriverWait wait;

    public DriverUtil(ChromeDriver driver) {
     wait=new WebDriverWait(driver, Duration.ofSeconds(10));

    }



    public DriverUtil(FirefoxDriver firefoxDriver) {
       wait = new WebDriverWait(firefoxDriver, Duration.ofSeconds(10));
    }

// Creare costruttore della classe DriverUtil
    // Gestire il driver nel costruttore
    // Creare l'oggetto wait nel costruttore usando il driver
    // Modificare il metodo findElement in modo tale che gestisca tutti i locator

    public WebElement findElement(By locator) {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }



}
