package edu.ubbcluj.tdtproject.pages.bookings;

import edu.ubbcluj.tdtproject.WaitElement;
import edu.ubbcluj.tdtproject.pages.BasePage;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookingPage extends BasePage {

    private WebElement getBookDeskButton() {
        return getAnyElement("//*[@id=\"__next\"]/div[2]/div[3]/div[1]/div/div/div[2]/div[4]/button[2]",
                "//*[@id=\"__next\"]/div[2]/div[3]/div[1]/div/div/div[2]/div[5]/button[2]");
    }

    private WebElement getAddBookingButton() {
        return getAnyElement("//*[@id=\"__next\"]/div[2]/div[3]/div[1]/div/div/div[2]/button[1]",
                "//*[@id=\"__next\"]/div[2]/div[3]/div[2]/div/div[2]/div/div/div/button[1]");
    }

    private WebElement getBookForAnotherUserButton() {
        return getAnyElement("//*[@id=\"__next\"]/div[2]/div[3]/div[1]/div/div/div[2]/button[2]",
                "//*[@id=\"__next\"]/div[2]/div[3]/div[2]/div/div[2]/div/div/div/button[2]");
    }

    private WebElement getLocationSelector() {
        return getElement("//*[@id=\"__next\"]/div[2]/div[3]/div[1]/div/div/div[2]/div[3]/div/div[1]/div/div/div");
    }

    private WebElement getLastBookingsArrow() {
        return getElement("//*[@id=\"__next\"]/div[2]/div[3]/div[1]/div/div/div[2]/div[3]/div[1]/div[2]");
    }

    public void openAddBooking() {
        getAddBookingButton().click();
    }

    public void openBookForAnotherUser() {
        getBookForAnotherUserButton().click();
    }

    public void enterTargetUserEmail(String email) {
        WebElement emailInput = getElement("//*[@id=\"users\"]");
        emailInput.sendKeys(email);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        emailInput.sendKeys(Keys.ARROW_DOWN);
        emailInput.sendKeys(Keys.ENTER);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement selectButton = getElement("/html/body/div[5]/div[3]/div/div[3]/div/button");
        selectButton.click();
    }

    public void selectEquipment(String equipment) {
        WebElement equipmentField = getElement("//*[@id=\"react-select-2-input\"]");
        equipmentField.sendKeys(equipment);
        equipmentField.sendKeys(Keys.ENTER);
    }

    public void selectLocation(int locationIndex) {
        getLocationSelector().click();
        getElement("//*[@id=\"menu-\"]/div[3]/ul/li[" + (locationIndex + 1) + "]").click();
    }

    public void selectDate() {
        getElement("//*[@id=\"__next\"]/div[2]/div[3]/div[1]/div/div/div[2]/div[2]/div/div/div/div[2]/div/div[3]/div[4]/div[4]/div").click();
    }

    public void selectDesk(int deskIndex) {
        getElement("//*[@id=\"__next\"]/div[2]/div[3]/div[2]/div/div/div[3]/div/div/div/div[2]/div[" + (deskIndex + 1) + "]/div/div/div[3]").click();
    }

    public void bookDesk() {
        getBookDeskButton().click();
    }

    public void displayLastBookings() {
        getLastBookingsArrow().click();
    }

    public WebElement getDateFromDatePickerCell(int row, int column) {
        return getDriver().findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[3]/div[1]/div/div/div[2]/div[2]/div/div/div/div[2]/div/div[3]/div[" + row + "]/div[" + column + "]"));
    }

    public boolean isMainBookingPage() {
        return getAddBookingButton().isDisplayed();
    }

    public boolean isLastBookingsDisplayed() {
        return getLastBookingsArrow().getAttribute("class").contains("Mui-expanded");
    }
}
