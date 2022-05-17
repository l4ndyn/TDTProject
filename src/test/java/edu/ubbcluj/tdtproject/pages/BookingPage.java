package edu.ubbcluj.tdtproject.pages;

import edu.ubbcluj.tdtproject.WaitElement;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookingPage extends BasePage {
    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[3]/div[1]/div/div/div[2]/div[4]/button[2]")
    private WebElement bookDeskButton;

    public void openAddBooking() {
        WebElement addBookingButton = getElement("//*[@id=\"__next\"]/div[2]/div[3]/div[1]/div/div/div[2]/button[1]");
        addBookingButton.click();
    }

    public boolean isMainBookingPage() {
        WebElement addBookingButton = getAnyElement("//*[@id=\"__next\"]/div[2]/div[3]/div[1]/div/div/div[2]/button[1]",
                "//*[@id=\"__next\"]/div[2]/div[3]/div[2]/div/div[2]/div/div/div/button[1]");
        return addBookingButton.isDisplayed();
    }
}
