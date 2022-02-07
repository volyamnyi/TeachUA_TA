package com.ita.edu.teachua.ui.pages.profile_page;


import com.ita.edu.teachua.ui.elements.custom_elements.*;
import com.ita.edu.teachua.ui.locators.profile_locators.AddCenterPopUpComponentLocators;
import com.ita.edu.teachua.ui.locators.profile_locators.ProfileDynamicCheckBoxLocators;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import com.ita.edu.teachua.ui.pages.main_page.MainPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddCenterPopUpComponent extends BasePage {
    @FindBy(how = How.CSS, using = AddCenterPopUpComponentLocators.ADD_LOCATION_BUTTON_CSS_SELECTOR)
    private Button addLocation;
    @FindBy(how = How.ID, using = AddCenterPopUpComponentLocators.CENTER_NAME_INPUT_ID)
    private Input centerNameField;
    @FindBy(how = How.CSS, using = AddCenterPopUpComponentLocators.NEXT_STEP_BUTTON_CSS_SELECTOR)
    private Button nextStepButton;
    @FindBy(how = How.CSS, using = AddCenterPopUpComponentLocators.CENTER_NAME_ERROR_BLOCK_CSS_SELECTOR)
    private Div errorBlock;
    @FindBy(how = How.ID, using = AddCenterPopUpComponentLocators.CENTER_NAME_INPUT_ID)
    private Input nameField;
    @FindBy(how = How.ID, using = AddCenterPopUpComponentLocators.PHONE_NUMBER_FIELD_ID)
    private Input phoneNumberField;
    @FindBy(how = How.ID, using = AddCenterPopUpComponentLocators.DESCRIPTION_FIELD_ID)
    private Input description;
    @FindBy(how = How.XPATH, using = AddCenterPopUpComponentLocators.FINISH_BUTTON_XPATH)
    private Button finishButton;
    @FindBy(how = How.XPATH, using = AddCenterPopUpComponentLocators.ADD_CENTER_BLOCK_HEADER_XPATH)
    private Div addCenterPopUpBlock;
    private CheckBox locationCheckBox;
    private CheckBox clubCheckBox;

    public AddCenterPopUpComponent(WebDriver driver) {
        super(driver);
    }

    @Step("Checking that 'Додати центр' pop-up is opened")
    public boolean addCenterPopUpBlockIsDisplayed() {
        waitUntilVisibilityOfElementLocated(By.xpath(AddCenterPopUpComponentLocators.ADD_CENTER_BLOCK_HEADER_XPATH), 5);
        return addCenterPopUpBlock.isDisplayed();
    }

    @Step("Click on '+Додати локацію' button")
    public AddLocationPopUpComponent clickOnAddLocationButton() {
        waitUntilElementToBeClickable(By.cssSelector(AddCenterPopUpComponentLocators.ADD_LOCATION_BUTTON_CSS_SELECTOR),10);
        addLocation.click();
        return new AddLocationPopUpComponent(driver);
    }

    @Step("Input '{name}' to name field")
    public AddCenterPopUpComponent fillNameField(String name) {
        nameField.set(name);
        return this;
    }

    @Step("Input '{phone}' to phone number field")
    public AddCenterPopUpComponent fillPhoneNumberField(String phone) {
        phoneNumberField.set(phone);
        return this;
    }

    @Step("Input '{text}' to 'Опис' field")
    public AddCenterPopUpComponent fillDescriptionField(String text) {
        description.set(text);
        return this;
    }
  
    @Step("Delete possible values from 'Назва центру' field")
    public AddCenterPopUpComponent clearCenterName() {
        if(centerNameField.isDisplayed())centerNameField.clear();
        return this;
    }

    @Step("Click on 'Наступний крок' button")
    public AddCenterPopUpComponent clickOnNextStepButton() {
        waitUntilElementToBeClickable(By.cssSelector(AddCenterPopUpComponentLocators.NEXT_STEP_BUTTON_CSS_SELECTOR),10);
        nextStepButton.click();
        return this;
    }
    @Step("Checking that error message 'Некоректна назва центру’ appears under 'Назва центру' field")
    public boolean errorsIsDisplayed() {
        waitUntilVisibilityOfElementLocated(By.cssSelector(AddCenterPopUpComponentLocators.CENTER_NAME_ERROR_BLOCK_CSS_SELECTOR), 5);
        return errorBlock.isDisplayed();
    }

    @Step("Click on 'Завершити' button")
    public MainPage clickOnFinishButton() {
        finishButton.click();
        return new MainPage(driver);
    }

    @Step("Check if checkbox with name '{name}' is displayed")
    public boolean isLocationCheckboxDisplayed(String name) {
        try {
            locationCheckBox = new CheckBoxElement(new ProfileDynamicCheckBoxLocators().getLocationCheckBoxByNameByXPath(driver, name));
            return locationCheckBox.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step("click on location checkbox with {name} name")
    public AddCenterPopUpComponent clickOnLocationCheckBoxByName(String name) {
        locationCheckBox = new CheckBoxElement(new ProfileDynamicCheckBoxLocators().getLocationCheckBoxByNameByXPath(driver, name));
        locationCheckBox.check();
        return this;
    }
    @Step("click on club checkbox with '{name}' name")
    public AddCenterPopUpComponent clickOnClubCheckBoxByName(String name) {
        clubCheckBox = new CheckBoxElement(new ProfileDynamicCheckBoxLocators().getClubCheckBoxByNameByXPath(driver, name));
        clubCheckBox.check();
        return this;
    }
    public AddCenterPopUpComponent getAddCenterPopUpComponent(){
        return this;
    }
}
