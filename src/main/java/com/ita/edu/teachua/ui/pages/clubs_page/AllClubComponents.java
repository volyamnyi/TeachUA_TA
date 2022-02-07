package com.ita.edu.teachua.ui.pages.clubs_page;

import com.ita.edu.teachua.ui.pages.header_page.RegisterPopUpComponent;
import org.openqa.selenium.WebDriver;

public class AllClubComponents {
    private WebDriver driver;

    private ClubCardComponent clubCardComponent;
    private ClubPagePopUpComponent clubPagePopUpComponent;
    private ClubsPage clubsPage;
    private ShowOnMapPopUpComponent showOnMapPopUpComponent;

    public AllClubComponents(WebDriver driver) {
        this.driver = driver;
    }

    public ClubCardComponent getClubCardComponent() {
        return clubCardComponent == null ? new ClubCardComponent(driver) : clubCardComponent;
    }

    public ClubPagePopUpComponent getClubPagePopUpComponent() {
        return clubPagePopUpComponent == null ? new ClubPagePopUpComponent(driver) : clubPagePopUpComponent;
    }

    public ShowOnMapPopUpComponent getShowOnMapPopUpComponent() {
        return showOnMapPopUpComponent == null ? new ShowOnMapPopUpComponent(driver) : showOnMapPopUpComponent;
    }
}
