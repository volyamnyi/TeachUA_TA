package com.ita.edu.teachua.ui.pages.header_page;

import com.ita.edu.teachua.ui.pages.profile_page.MyClubsOrCentersDropdownComponent;
import org.openqa.selenium.WebDriver;

public class AllHeaderComponents {
    private WebDriver driver;
    private RegisterPopUpComponent registerPopUpComponent;
    private AdministrationDropdownComponent administrationDropdownComponent;
    private RestoringBeginPopUpComponent restoringBeginPopUpComponent;
    private OwnerDropdownComponent ownerDropdownComponent;
    private RestoringPasswordFinishPopUpComponent restoringPasswordFinishPopUpComponent;
    private ChallengeDropdownComponent challengeDropdownComponent;
    private LoginPopUpComponent loginPopUpComponent;
    private GuestDropdownComponent guestDropdownComponent;

    public AllHeaderComponents(WebDriver driver) {
        this.driver = driver;
    }

    public RegisterPopUpComponent getRegisterPopUpComponent() {
        return registerPopUpComponent == null ? new RegisterPopUpComponent(driver) : registerPopUpComponent;
    }

    public AdministrationDropdownComponent getAdministrationDropdownComponent() {
        return administrationDropdownComponent == null ? new AdministrationDropdownComponent(driver) : administrationDropdownComponent;
    }

    public RestoringBeginPopUpComponent getRestoringBeginPopUpComponent() {
        return restoringBeginPopUpComponent == null ? new RestoringBeginPopUpComponent(driver) : restoringBeginPopUpComponent;
    }

    public OwnerDropdownComponent getOwnerDropdownComponent() {
        return ownerDropdownComponent == null ? new OwnerDropdownComponent(driver) : ownerDropdownComponent;
    }

    public RestoringPasswordFinishPopUpComponent getRestoringPasswordFinishPopUpComponent() {
        return restoringPasswordFinishPopUpComponent == null ? new RestoringPasswordFinishPopUpComponent(driver) : restoringPasswordFinishPopUpComponent;
    }

    public ChallengeDropdownComponent getChallengeDropdownComponent() {
        return challengeDropdownComponent == null ? new ChallengeDropdownComponent(driver) : challengeDropdownComponent;
    }

    public LoginPopUpComponent getLoginPopUpComponent() {
        return loginPopUpComponent == null ? new LoginPopUpComponent(driver) : loginPopUpComponent;
    }

    public GuestDropdownComponent getGuestDropdownComponent() {
        return guestDropdownComponent == null ? new GuestDropdownComponent(driver) : guestDropdownComponent;
    }
}
