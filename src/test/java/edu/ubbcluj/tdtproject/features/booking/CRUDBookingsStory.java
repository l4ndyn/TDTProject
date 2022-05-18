package edu.ubbcluj.tdtproject.features.booking;

import edu.ubbcluj.tdtproject.steps.serenity.EndUserSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Random;

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
        user.selectsBooking(0);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        user.startsDeletingSelectedBookings();
        user.setsDeletionReason("Test");
        user.confirmsDeletingBookings();
        user.shouldHaveBookingInfoChanged(0);
    }

    @Test
    public void deleteRandomBookings() {
        user.opensLoginPage("lhdemo", "LH@Evozon!2022");
        user.logsInAsAdmin();
        user.opensAllBookingsPage();

        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            int index = random.nextInt(5);

            if (i == 0) {
                user.selectsBooking(index);
            }
            user.selectsBooking(index);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            user.startsDeletingSelectedBookings();
            user.setsDeletionReason("Test");
            user.confirmsDeletingBookings();
            user.shouldHaveBookingInfoChanged(index);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
