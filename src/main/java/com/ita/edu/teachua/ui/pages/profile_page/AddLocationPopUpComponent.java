package com.ita.edu.teachua.ui.pages.profile_page;


import com.ita.edu.teachua.ui.elements.custom_elements.*;
import com.ita.edu.teachua.ui.locators.profile_locators.AddLocationPopUpComponentLocators;
import com.ita.edu.teachua.ui.locators.profile_locators.ProfileDynamicLabelsLocators;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddLocationPopUpComponent extends BasePage {
    @FindBy(how = How.XPATH, using = AddLocationPopUpComponentLocators.ADD_BUTTON_XPATH)
    private Button addButton;
    @FindBy(how = How.XPATH, using = AddLocationPopUpComponentLocators.ADD_BUTTON_XPATH)
    private Button addButtonToClubPopUp;
    @FindBy(how = How.XPATH, using = AddLocationPopUpComponentLocators.ADD_LOCATION_BLOCK_HEADER_XPATH)
    private Div addLocationPopUpBlock;
    @FindBy(how = How.ID, using = AddLocationPopUpComponentLocators.LOCATION_NAME_FIELD_ID)
    private Input locationNameField;
    @FindBy(how = How.ID, using = AddLocationPopUpComponentLocators.CITY_DROPDOWN_ID)
    private Dropdown cityDropdown;
    @FindBy(how = How.ID, using = AddLocationPopUpComponentLocators.DISTRICT_DROPDOWN_ID)
    private Dropdown districtDropdown;
    @FindBy(how = How.ID, using = AddLocationPopUpComponentLocators.LOCALITY_DROPDOWN_ID)
    private Dropdown localityDropdown;
    @FindBy(how = How.ID, using = AddLocationPopUpComponentLocators.ADDRESS_FIELD_ID)
    private Input addressField;
    @FindBy(how = How.ID, using = AddLocationPopUpComponentLocators.COORDINATES_FIELD_ID)
    private Input coordinatesField;
    @FindBy(how = How.ID, using = AddLocationPopUpComponentLocators.PHONE_FIELD_ID)
    private Input phoneField;
    @FindBy(how = How.CSS, using = AddLocationPopUpComponentLocators.ADD_BUTTON_DISABLED_CSS_SELECTOR)
    private Button addButtonDisabled;
    //@FindBy(how = How.XPATH, using = String.format("//input[contains(@id,'%s')]/ancestor::div[@class='ant-form-item-control-input']//span[@aria-label='check-circle']", ""))
    private Label fieldAcceptLabel;

    public AddLocationPopUpComponent(WebDriver driver) {
        super(driver);
    }

    @Step("Checking that 'Додати' button is disabled")
    public boolean checkAddButton() {
        return addButtonDisabled.isEnabled();
    }

    @Step("Checking that 'Додати локацію' pop-up is opened")
    public boolean addLocationPopUpBlockIsDisplayed() {
        waitUntilVisibilityOfElementLocated(By.xpath(AddLocationPopUpComponentLocators.ADD_LOCATION_BLOCK_HEADER_XPATH), 30);
        return addLocationPopUpBlock.isDisplayed();
    }

    @Step("Enter data into the 'Назва' field of 'Додати локацію' pop-up ")
    public AddLocationPopUpComponent sendKeysLocationNameField(String locationName) {
        waitUntilVisibilityOfElementLocated(By.id(AddLocationPopUpComponentLocators.LOCATION_NAME_FIELD_ID),30);
        locationNameField.set(locationName);
        return this;
    }

    @Step("Click on 'Місто' dropdown")
    public CityDropdownComponent clickOnCityDropdown() {
        cityDropdown.click();
        //sleep(1500);
        return new CityDropdownComponent(driver);
    }

    @Step("Click on 'Район міста' dropdown")
    public DistrictDropdownComponent clickOnDistrictDropdown() {
        districtDropdown.click();
        return new DistrictDropdownComponent(driver);
    }

    @Step("Click on 'Метро/Місцевість' dropdown")
    public LocalityDropdownComponent clickOnLocalityDropdown() {
        localityDropdown.click();
        return new LocalityDropdownComponent(driver);
    }

    @Step("Enter data {address} into the 'Адреса' field")
    public AddLocationPopUpComponent sendKeysAddressField(String address) {
        addressField.set(address);
        return this;
    }

    @Step("Enter data {coordinates} into the 'Географічні координати' field ")
    public AddLocationPopUpComponent sendKeysCoordinatesField(String coordinates) {
        coordinatesField.set(coordinates);
        return this;
    }

    @Step("Enter data {phoneNumber} into the 'Номер телефону' field")
    public AddLocationPopUpComponent sendKeysPhoneField(String phoneNumber) {
        phoneField.set(phoneNumber);
        return this;
    }

    @Step("Click the 'Додати' button")
    public AddCenterPopUpComponent clickOnAddButtonToCenterPopUp() {
        addButton.click();
        return new AddCenterPopUpComponent(driver);
    }

    @Step("Click the 'Додати' button")
    public AddClubPopUpComponent clickOnAddButtonToClubPopUp() {
        addButtonToClubPopUp.click();
        return new AddClubPopUpComponent(driver);
    }

    @Step("Check if data for the field with Id {id} is accepted")
    public boolean isDataAccepted(String id) {
        try {
            fieldAcceptLabel = new LabelElement(new ProfileDynamicLabelsLocators().addLocationPopUpDynamicIdByXPath(driver, id));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public AddLocationPopUpComponent getAddLocationPopUpComponent(){
        return this;
    }
}
