package edu.ubbcluj.tdtproject.steps.serenity;

import edu.ubbcluj.tdtproject.pages.bookings.AllBookingsPage;
import edu.ubbcluj.tdtproject.pages.bookings.BookingInfo;
import edu.ubbcluj.tdtproject.pages.bookings.BookingPage;
import edu.ubbcluj.tdtproject.pages.LoginPage;
import net.thucydides.core.annotations.Step;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class EndUserSteps {
    private LoginPage loginPage;
    private BookingPage bookingPage;
    private AllBookingsPage allBookingsPage;

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
    public void shouldHaveBookingInfoChanged(int bookingIndex) {
        assertNotEquals(currentBookingInfo, allBookingsPage.getBookingInfo(bookingIndex));
    }
}
