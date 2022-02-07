package com.ita.edu.teachua.cucumber.steps_definitions;

import com.ita.edu.teachua.ui.pages.header_page.OwnerDropdownComponent;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class InvalidDataInFieldPhone {
    private  BaseDefinition baseDef;
    private PageContext pageContext;
    private final SoftAssert softAssert;
    private OwnerDropdownComponent ownerDropdownComponent;

    public InvalidDataInFieldPhone(BaseDefinition baseDef)  {
        this.baseDef = baseDef;
        pageContext = new PageContext(baseDef.getDriver());
        softAssert = new SoftAssert();
    }

    @Then("Click on owner profile popup")
    public void clickOnOwnerProfilePopup() {
        ownerDropdownComponent=pageContext.getAllPages().getHeaderPage().clickOnOwnerDropdown();
    }

    @And("Click on profile")
    public void clickOnProfile() {
        ownerDropdownComponent.clickOnProfile();
    }

    @Then("Click on Edit profile")
    public void clickOnEditProfile() {
        pageContext.getAllPages().getProfilePage().clickEditProfile();
    }


    @And("Fill invalid data in field {fieldPhone} check if the {message} is shown")
    public void fillInvalidDataInFieldFieldPhoneCheckIfTheMessageIsShown(String[] actual,String[] expected) {
        for(int i=0;i<actual.length;i++)
            softAssert.assertEquals(pageContext.getAllProfilePageComponents().getProfileEditPopUpComponent().fillPhone(actual[i]).getMessage(),expected[i]);
        softAssert.assertEquals(pageContext.getAllProfilePageComponents().getProfileEditPopUpComponent().fillPhone("").getMessage(),expected[expected.length-1]);
        softAssert.assertAll();
    }

    @Given("Log in as an Керівник email = <email>, password = <password>")
    public void logInAsAnКерівникEmailEmailPasswordPassword() {
        pageContext.getAllPages().getHeaderPage().authorize(BaseDefinition.getTestValueProvider().getAdminEmail(), BaseDefinition.getTestValueProvider().getAdminPassword());
    }
}
