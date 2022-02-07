package com.ita.edu.teachua.cucumber.steps_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class AddLocationWithValidDataFillingAllFields {
    private  BaseDefinition baseDef;
    private PageContext pageContext;
    private final SoftAssert softAssert;

    public AddLocationWithValidDataFillingAllFields(BaseDefinition baseDef)  {
        this.baseDef = baseDef;
        pageContext = new PageContext(baseDef.getDriver());
        softAssert = new SoftAssert();
    }

    @And("Go to the 'Додати центр'")
    public void goToTheДодатиЦентр() {
        pageContext.getAllPages()
                .getHeaderPage()
                .clickOnOwnerDropdown()
                .clickOnAddCenterButton();
    }

    @When("Click on '+Додати локацію' button")
    public void clickOnДодатиЛокаціюButton() {
        pageContext.getAllProfilePageComponents()
                .getAddCenterPopUpComponent()
                .clickOnAddLocationButton();
    }

    @And("Fill 'Назва' field with correct value {validLocationName}")
    public void FillНазваFieldWithCorrectValue(String validLocationName) {
        pageContext.getAllProfilePageComponents()
                .getAddLocationPopUpComponent()
                .sendKeysLocationNameField(validLocationName);
    }

    @And("Select Київ from the city dropdown list")
    public void SelectМістоFromTheDropdownList() {
        pageContext.getAllProfilePageComponents()
                .getAddLocationPopUpComponent()
                .clickOnCityDropdown()
                .clickOnKyivButton();
    }

    @And("Select Академмістечко from the dropdown list")
    public void selectАкадеммістечкоFromTheDropdownList() {
        pageContext.getAllProfilePageComponents()
                .getAddLocationPopUpComponent()
                .clickOnLocalityDropdown()
                .clickOnAkademmistechkoButton();
    }

    @And("Select Деснянський from the dropdown list")
    public void SelectДеснянськийFromTheDropdownList() {
        pageContext.getAllProfilePageComponents()
                .getAddLocationPopUpComponent()
                .clickOnDistrictDropdown()
                .clickOnDesnianskyiButton();
    }

    @And("Fill in 'Номер телефону' field with {validPhoneNumber}")
    public void FillInНомерТелефонуField(String validPhoneNumber) {
        pageContext.getAllProfilePageComponents()
                .getAddLocationPopUpComponent()
                .sendKeysPhoneField(validPhoneNumber);
    }

    @And("Fill in 'Координати' field with {validCoordinates}")
    public void FillInНомерКоординатиField(String validCoordinates) {
        pageContext.getAllProfilePageComponents()
                .getAddLocationPopUpComponent()
                .sendKeysCoordinatesField(validCoordinates);
    }

    @And("Fill in 'Адреса' field with {validAddress}")
    public void FillInАдресаField(String validAddress) {
        pageContext.getAllProfilePageComponents()
                .getAddLocationPopUpComponent()
                .sendKeysAddressField(validAddress);
    }

    @And("Click on 'Додати' button")
    public void ClickOnДодатиButton() {
        pageContext.getAllProfilePageComponents()
                .getAddLocationPopUpComponent()
                .clickOnAddButtonToCenterPopUp();
    }

    @Then("Location {validLocationName} is in the list of locations")
    public void LocationIsInTheListOfLocations(String validLocationName) {
        boolean actual = pageContext.getAllProfilePageComponents()
                .getAddCenterPopUpComponent()
                .isLocationCheckboxDisplayed(validLocationName);
        Assert.assertTrue(actual);
    }
}
