package edu.ubbcluj.tdtproject.pages;

import edu.ubbcluj.tdtproject.WaitElement;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

public class BasePage extends PageObject {
    protected WebElement getElement(String xpath) {
        return WaitElement.wait(getDriver(), xpath);
    }

    protected WebElement getAnyElement(String xpath1, String xpath2) {
        try {
            return WaitElement.wait(getDriver(), xpath1);
        } catch (TimeoutException e) {
            return WaitElement.wait(getDriver(), xpath2);
        }
    }

    protected void acceptCookies() {
        WebElement acceptCookiesButton = getElement("/html/body/div[1]/div[2]/div[4]/div/button");
        acceptCookiesButton.click();
    }
}
