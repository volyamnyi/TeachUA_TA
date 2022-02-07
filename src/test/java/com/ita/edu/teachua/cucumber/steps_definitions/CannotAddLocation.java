package com.ita.edu.teachua.cucumber.steps_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.testng.asserts.SoftAssert;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


public class CannotAddLocation  {
    private  BaseDefinition baseDef;
    private PageContext pageContext;
    private final SoftAssert softAssert;
    public CannotAddLocation(BaseDefinition baseDef) throws IOException {
        this.baseDef = baseDef;
        pageContext = new PageContext(baseDef.getDriver());
        softAssert = new SoftAssert();
    }
    @Given("Log in as Керівник")
    public void logInAsКерівник() {
        pageContext.getAllPages().getHeaderPage().authorize(BaseDefinition.getTestValueProvider().getAdminEmail(), BaseDefinition.getTestValueProvider().getAdminPassword());
    }

    @Then("Go to the Додати центр")
    public void goToTheДодатиЦентр() {
        pageContext.getAllPages().getHeaderPage().clickOnOwnerDropdown().clickOnAddCenterButton();
    }

    @And("Click on Додати локацію button")
    public void clickOnДодатиЛокаціюButton() {
        pageContext.getAllProfilePageComponents().getAddCenterPopUpComponent().clickOnAddLocationButton();
    }

    @Then("Check if Додати локацію pop up is opened")
    public void checkIfДодатиЛокаціюPopUpIsOpened() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        softAssert.assertTrue(pageContext.getAllProfilePageComponents().getAddLocationPopUpComponent().addLocationPopUpBlockIsDisplayed());
    }


    @And("Check if Додати button is disabled.")
    public void checkIfДодатиButtonIsDisabled() {
        softAssert.assertTrue(pageContext.getAllProfilePageComponents().getAddLocationPopUpComponent().checkAddButton());
    }

}
