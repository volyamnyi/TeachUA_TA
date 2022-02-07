package com.ita.edu.teachua.ui.pages.profile_page;

import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import org.openqa.selenium.WebDriver;

public class AllProfileComponents {
    private WebDriver driver;
    private MyClubsOrCentersDropdownComponent myClubsOrCentersDropdownComponent;
    private CentersItemComponent centersItemComponent;
    private AddDropdownComponent addDropdownComponent;
    private AddClubPopUpComponent addClubPopUpComponent;
    private DistrictDropdownComponent districtDropdownComponent;
    private CityDropdownComponent cityDropdownComponent;
    private AddLocationPopUpComponent addLocationPopUpComponent;
    private AddCenterPopUpComponent addCenterPopUpComponent;
    private LocalityDropdownComponent localityDropdownComponent;
    private ProfileEditPopUpComponent profileEditPopUpComponent;


    public AllProfileComponents(WebDriver driver) {
        this.driver=driver;
    }

    public MyClubsOrCentersDropdownComponent getMyClubsOrCentersDropdownComponent() {
        return myClubsOrCentersDropdownComponent == null ? new MyClubsOrCentersDropdownComponent(driver) : myClubsOrCentersDropdownComponent;
    }

    public CentersItemComponent getCentersItemComponent() {
        return centersItemComponent == null ? new CentersItemComponent(driver) : centersItemComponent;
    }

    public AddDropdownComponent getAddDropdownComponent() {
        return addDropdownComponent == null ? new AddDropdownComponent (driver) : addDropdownComponent;
    }

    public AddClubPopUpComponent getAddClubPopUpComponent() {
        return addClubPopUpComponent == null ? new AddClubPopUpComponent (driver) : addClubPopUpComponent;
    }

    public DistrictDropdownComponent getDistrictDropdownComponent() {
        return districtDropdownComponent == null ? new DistrictDropdownComponent (driver) : districtDropdownComponent;
    }

    public CityDropdownComponent getCityDropdownComponent() {
        return cityDropdownComponent == null ? new CityDropdownComponent (driver) : cityDropdownComponent;
    }

    public AddLocationPopUpComponent getAddLocationPopUpComponent() {
        return addLocationPopUpComponent == null ? new AddLocationPopUpComponent (driver) : addLocationPopUpComponent;
    }

    public AddCenterPopUpComponent getAddCenterPopUpComponent() {
        return addCenterPopUpComponent == null ? new AddCenterPopUpComponent (driver) : addCenterPopUpComponent;
    }

    public LocalityDropdownComponent getLocalityDropdownComponent() {
        return localityDropdownComponent == null ? new LocalityDropdownComponent (driver) : localityDropdownComponent;
    }

    public ProfileEditPopUpComponent getProfileEditPopUpComponent() {
        return profileEditPopUpComponent == null ? new ProfileEditPopUpComponent (driver) : profileEditPopUpComponent;
    }

}
