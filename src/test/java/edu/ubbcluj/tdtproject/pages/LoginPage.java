package edu.ubbcluj.tdtproject.pages;

import edu.ubbcluj.tdtproject.WaitElement;
import net.thucydides.core.pages.PageObject;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class LoginPage extends BasePage {

    public void openPage(String username, String password) {
        getDriver().manage().window().maximize();
        getDriver().get("https://lighthouse-demo.evozon.com/login");

        String url = null;
        try {
            url = "http://" + URLEncoder.encode(username, StandardCharsets.UTF_8.toString()) + ":"
                    +  URLEncoder.encode(password, StandardCharsets.UTF_8.toString()) + "@lighthouse-demo.evozon.com/login";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        getDriver().get(url);
    }

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id='__next']//button")
    private WebElement signInButton;

    private void waitForLoginPageToLoad(){
        WaitElement.wait(getDriver(), usernameField);
        WaitElement.wait(getDriver(), passwordField);
        WaitElement.wait(getDriver(), signInButton);
    }

    public void login(String email, String password) {
        waitForLoginPageToLoad();
        usernameField.clear();
        passwordField.clear();

        usernameField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();

        if(getDriver().findElements(By.xpath("//*[@id=\"__next\"]//h1[contains(text(),'Too many failed attempts.')]")).size() > 0)
        {
            try {
                Thread.sleep(32000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            usernameField.clear();
            passwordField.clear();

            usernameField.sendKeys(email);
            passwordField.sendKeys(password);
            signInButton.click();
        }

        acceptCookies();
    }
}
