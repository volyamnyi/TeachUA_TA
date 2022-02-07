package com.ita.edu.teachua.ui.pages;

import com.ita.edu.teachua.ui.pages.aboutuspage.AboutUsPage;
import com.ita.edu.teachua.ui.pages.administration_pages.BannerPage;
import com.ita.edu.teachua.ui.pages.advanced_search.AdvancedSearchPage;
import com.ita.edu.teachua.ui.pages.challenge_page.ChallengePage;
import com.ita.edu.teachua.ui.pages.clubs_page.ClubsPage;
import com.ita.edu.teachua.ui.pages.header_page.HeaderPage;
import com.ita.edu.teachua.ui.pages.main_page.MainPage;
import com.ita.edu.teachua.ui.pages.profile_page.ProfileEditPopUpComponent;
import com.ita.edu.teachua.ui.pages.profile_page.ProfilePage;
import com.ita.edu.teachua.ui.pages.services_page.ServicesPage;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.InvocationTargetException;

public class AllPages {
    private WebDriver driver;

    private HeaderPage headerPage;
    private MainPage mainPage;
    private ProfilePage profilePage;
    private ServicesPage servicesPage;
    private ClubsPage clubsPage;
    private ChallengePage challengePage;
    private AdvancedSearchPage advancedSearchPage;
    private BannerPage bannerPage;
    private AboutUsPage aboutUsPage;


    public AllPages(WebDriver driver){
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public HeaderPage getHeaderPage() {
        return headerPage == null ? new HeaderPage(driver) : headerPage;
    }

    public MainPage getMainPage() {
        return mainPage == null ? new MainPage(driver) : mainPage;
    }

    public ProfilePage getProfilePage() {
        return profilePage == null ? new ProfilePage(driver) : profilePage;
    }

    public ServicesPage getServicesPage() {
        return servicesPage == null ? new ServicesPage(driver) : servicesPage;
    }

    public ClubsPage getClubsPage() {
        return clubsPage == null ? new ClubsPage(driver) : clubsPage;
    }

    public ChallengePage getChallengePage() {
        return challengePage == null ? new ChallengePage(driver) : challengePage;
    }

    public AdvancedSearchPage getAdvancedSearchPage() {
        return advancedSearchPage == null ? new AdvancedSearchPage(driver) : advancedSearchPage;
    }

    public BannerPage getBannerPage() {
        return bannerPage == null ? new BannerPage(driver) : bannerPage;
    }

    public AboutUsPage getAboutUsPage() {
        return aboutUsPage == null ? new AboutUsPage(driver) : aboutUsPage;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void setHeaderPage(HeaderPage headerPage) {
        this.headerPage = headerPage;
    }

    public void setMainPage(MainPage mainPage) {
        this.mainPage = mainPage;
    }

    public void setProfilePage(ProfilePage profilePage) {
        this.profilePage = profilePage;
    }

    public void setServicesPage(ServicesPage servicesPage) {
        this.servicesPage = servicesPage;
    }

    public void setClubsPage(ClubsPage clubsPage) {
        this.clubsPage = clubsPage;
    }

    public void setChallengePage(ChallengePage challengePage) {
        this.challengePage = challengePage;
    }

    public void setAdvancedSearchPage(AdvancedSearchPage advancedSearchPage) {
        this.advancedSearchPage = advancedSearchPage;
    }

    public void setBannerPage(BannerPage bannerPage) {
        this.bannerPage = bannerPage;
    }

    public void setAboutUsPage(AboutUsPage aboutUsPage) {
        this.aboutUsPage = aboutUsPage;
    }
}
