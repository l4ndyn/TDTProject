package edu.ubbcluj.tdtproject.steps.serenity;

import edu.ubbcluj.tdtproject.pages.bookings.AllBookingsPage;
import edu.ubbcluj.tdtproject.pages.bookings.BookingInfo;
import edu.ubbcluj.tdtproject.pages.bookings.BookingPage;
import edu.ubbcluj.tdtproject.pages.LoginPage;
import edu.ubbcluj.tdtproject.pages.bookings.BuildingsPage;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class EndUserSteps {
    private LoginPage loginPage;
    private BookingPage bookingPage;
    private AllBookingsPage allBookingsPage;
    private BuildingsPage buildingsPage;

    @Step
    public void opensLoginPage(String username, String password) {
        loginPage.openPage(username, password);
    }

    @Step
    public void logsIn(String email, String password) {
        loginPage.login(email, password);
    }

    @Step
    public void logsInAsUser() {
        logsIn("rimof23866@hbehs.com", "aBc123456");
    }

    @Step
    public void logsInAsAdmin() {
        logsIn("nzkvscxx@scpulse.com", "aBc123456");
    }

    @Step
    public void shouldBeOnBookingPage() {
        assertTrue("User should be on the main bookings page!", bookingPage.isMainBookingPage());
    }

    @Step
    public void opensAddNewBooking() {
        bookingPage.openAddBooking();
    }

    @Step
    public void opensBookForAnotherUser() {
        bookingPage.openBookForAnotherUser();
    }

    @Step
    public void entersTargetUserEmail(String email) {
        bookingPage.enterTargetUserEmail(email);
    }

    @Step
    public void selectsEquipment(String equipment) {
        bookingPage.selectEquipment(equipment);
    }

    @Step
    public void selectsLocation(int locationIndex) {
        bookingPage.selectLocation(locationIndex);
    }

    @Step
    public void selectsDate() {
        bookingPage.selectDate();
    }

    @Step
    public void selectsDesk(int deskIndex) {
        bookingPage.selectDesk(deskIndex);
    }

    @Step
    public void booksDesk() {
        bookingPage.bookDesk();
    }

    @Step
    public void opensAllBookingsPage() {
        allBookingsPage.open();
    }

    @Step
    public void shouldBeOnAllBookingsPage() {
        assertTrue("User should be on all bookings page!", allBookingsPage.isAllBookingsPage());
    }

    BookingInfo currentBookingInfo;

    @Step
    public void selectsBooking(int bookingIndex) {
        allBookingsPage.selectBooking(bookingIndex);
        currentBookingInfo = allBookingsPage.getBookingInfo(bookingIndex);
    }

    @Step
    public void startsDeletingSelectedBookings() {
        allBookingsPage.startDeleteSelectedBookings();
    }

    @Step
    public void setsDeletionReason(String reason) {
        allBookingsPage.setDeletionReason(reason);
    }

    @Step
    public void confirmsDeletingBookings() {
        allBookingsPage.confirmDelete();
    }

    @Step
    public void displaysLastBookings() {
        bookingPage.displayLastBookings();
    }

    @Step
    public void opensBuildingsPage() {
        buildingsPage.open();
    }

    @Step
    public void shouldHaveDisplayedLastBookings() {
        assertTrue("User should see the last bookings!", bookingPage.isLastBookingsDisplayed());
    }

    @Step
    public void shouldHaveBookingInfoChanged(int bookingIndex) {
        assertNotEquals(currentBookingInfo, allBookingsPage.getBookingInfo(bookingIndex));
    }

    @Step
    public void shouldHaveValidDateInBookingCell(int row, int column) {
        WebElement cell = bookingPage.getDateFromDatePickerCell(row, column);
        try {
            Date date = new SimpleDateFormat("E MMM dd yyyy").parse(cell.getAttribute("aria-label"));

            if (date.before(new Date())) {
                assertTrue("Booking date cell in the past should not be available! The affected date: " + date, cell.getAttribute("class").contains("disabled"));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Step
    public void shouldBeOnBuildingsPage() {
        assertTrue("The user should be on the buildings page!", buildingsPage.isBuildingsPage());
    }

    @Step
    public void shouldNotBeOnBuildingsPage() {
        assertFalse("The user should be on the buildings page!", buildingsPage.isBuildingsPage());
    }
}
