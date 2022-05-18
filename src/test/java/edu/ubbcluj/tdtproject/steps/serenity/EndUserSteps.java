package edu.ubbcluj.tdtproject.steps.serenity;

import edu.ubbcluj.tdtproject.pages.BookingPage;
import edu.ubbcluj.tdtproject.pages.LoginPage;
import net.thucydides.core.annotations.Step;

import static org.junit.Assert.assertTrue;

public class EndUserSteps {
    private LoginPage loginPage;
    private BookingPage bookingPage;

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
    public void selectsDesk() {
        bookingPage.selectDesk();
    }

    @Step
    public void booksDesk() {
        bookingPage.bookDesk();
    }
}
