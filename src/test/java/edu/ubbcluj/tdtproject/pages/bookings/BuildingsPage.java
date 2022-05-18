package edu.ubbcluj.tdtproject.pages.bookings;

import edu.ubbcluj.tdtproject.pages.BasePage;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;

@DefaultUrl("https://lighthouse-demo.evozon.com/buildings")
public class BuildingsPage extends BasePage {

    private WebElement getAddBuildingButton() {
        return getElement("//*[@id=\"__next\"]/div[2]/div[3]/div[1]/div/div[1]/div/div[2]/button");
    }

    public boolean isBuildingsPage() {
        try {
            return getAddBuildingButton().isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
