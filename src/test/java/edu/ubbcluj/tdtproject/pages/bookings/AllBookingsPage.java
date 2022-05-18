package edu.ubbcluj.tdtproject.pages.bookings;

import edu.ubbcluj.tdtproject.pages.BasePage;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@DefaultUrl("https://lighthouse-demo.evozon.com/all-bookings")
public class AllBookingsPage extends BasePage {
    private WebElement getBookingCheckbox(int bookingIndex) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return getDriver().findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[3]/div[2]/div/div/div/div[4]/div[1]/table/tbody/tr[" + (bookingIndex + 1) + "]/td[1]/span/span[1]/input"));
    }

    public void selectBooking(int bookingIndex) {
        getBookingCheckbox(bookingIndex).click();
    }

    public String getNameForBooking(int bookingIndex) {
        return getElement("//*[@id=\"__next\"]/div[2]/div[3]/div[2]/div/div/div/div[4]/div[1]/table/tbody/tr[1]/td[2]").getText();
    }

    public String getLocationForBooking(int bookingIndex) {
        return getElement("//*[@id=\"__next\"]/div[2]/div[3]/div[2]/div/div/div/div[4]/div[1]/table/tbody/tr[1]/td[3]").getText();
    }

    public String getDeskLabelForBooking(int bookingIndex) {
        return getElement("//*[@id=\"__next\"]/div[2]/div[3]/div[2]/div/div/div/div[4]/div[1]/table/tbody/tr[1]/td[4]").getText();
    }

    public String getDateForBooking(int bookingIndex) {
        return getElement("//*[@id=\"__next\"]/div[2]/div[3]/div[2]/div/div/div/div[4]/div[1]/table/tbody/tr[1]/td[6]").getText();
    }

    public String getTimeForBooking(int bookingIndex) {
        return getElement("//*[@id=\"__next\"]/div[2]/div[3]/div[2]/div/div/div/div[4]/div[1]/table/tbody/tr[1]/td[7]").getText();
    }

    public BookingInfo getBookingInfo(int bookingIndex) {
        return new BookingInfo(getNameForBooking(bookingIndex), getLocationForBooking(bookingIndex),
                getDeskLabelForBooking(bookingIndex), getDateForBooking(bookingIndex),
                getTimeForBooking(bookingIndex));
    }

    public void startDeleteSelectedBookings() {
        WebElement deleteButton = getElement("//*[@id=\"__next\"]/div[2]/div[3]/div[2]/div/div/div/div[4]/div[2]/button");
        deleteButton.click();
    }

    public void setDeletionReason(String reason) {
        WebElement reasonField = getElement("/html/body/div[5]/div[3]/div/div[2]/form/div/div/textarea");
        reasonField.sendKeys(reason);
    }

    public void confirmDelete() {
        WebElement confirmButton = getElement("/html/body/div[5]/div[3]/div/div[3]/div/button");
        confirmButton.click();
    }

    public boolean isAllBookingsPage() {
        WebElement nameColumn = getElement("/html/body/div[1]/div[2]/div[3]/div[2]/div/div/div/div[4]/div[1]/table/thead/tr/th[2]/span");
        return nameColumn.isDisplayed();
    }
}
