package edu.ubbcluj.tdtproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitElement {
    private static final int waitSeconds = 5;

    public static void wait(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement wait(WebDriver driver, String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }
}
