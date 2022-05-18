package edu.ubbcluj.tdtproject.features.booking;

import edu.ubbcluj.tdtproject.steps.serenity.EndUserSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class CRUDBookingsStory {

    @Steps
    public EndUserSteps user;

    @Test
    public void openAllBookings() {
        user.opensLoginPage("lhdemo", "LH@Evozon!2022");
        user.logsInAsAdmin();

        user.opensAllBookingsPage();
        user.shouldBeOnAllBookingsPage();
    }

    @Test
    public void deleteFirstBooking() {
        user.opensLoginPage("lhdemo", "LH@Evozon!2022");
        user.logsInAsAdmin();

        user.opensAllBookingsPage();
        user.selectsBooking(0);
        user.startsDeletingSelectedBookings();
        user.setsDeletionReason("Test");
        user.confirmsDeletingBookings();
        user.shouldHaveBookingInfoChanged(0);
    }
}
