package com.ita.edu.teachua.cucumber.steps_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.asserts.SoftAssert;

public class UserCanChangeRole {
    private final BaseDefinition baseDef;
    private final PageContext pageContext;
    private final SoftAssert softAssert;
    public UserCanChangeRole(BaseDefinition baseDefinition) {
        this.baseDef = baseDefinition;
        pageContext = new PageContext(baseDefinition.getDriver());
        softAssert = new SoftAssert();
    }

    @Given("Log in as User")
    public void logInAsUser(){
        pageContext.getAllPages().getHeaderPage()
                .authorize(BaseDefinition.getTestValueProvider().getTestTeachUaMetaEmail(),
                        BaseDefinition.testValueProvider.getTestTeachUaMetaPassword());
    }

    @Then("Go to the My Profile")
    public void goToMyProfile() {
        pageContext.getAllPages().getHeaderPage()
                .clickOnOwnerDropdown().clickOnProfile();
    }

    @And("Check if user has role ROLE_MANAGER in profile")
    public void checkIfUserHasMANAGERRoleStatus() {
        softAssert.assertEquals(pageContext.getAllPages().getProfilePage()
                .getRoleStatus(), "ROLE_MANAGER");
    }

    @Then("Click on Відвідувач button")
    public void clickOnRoleUserButton() {
        pageContext.getAllProfilePageComponents().getProfileEditPopUpComponent()
                .clickOnRoleUser();
    }
    @And("Click on Зберегти зміни button")
    public void ClickOnSaveChangeButton() {
        pageContext.getAllProfilePageComponents().getProfileEditPopUpComponent()
                .clickOnSaveChangeButton();
    }
    @And("Check if user has role ROLE_USER in profile")
    public void checkIfUserHasUSERRoleStatus() {
        softAssert.assertEquals(pageContext.getAllPages().getProfilePage()
                .getRoleStatus(), "ROLE_USER");
    }

    @Then("Click on Керівник button")
    public void clickOnRoleManagerButton() {
        pageContext.getAllProfilePageComponents().getProfileEditPopUpComponent()
                .clickOnRoleManager();
    }

    @And("Check all asserts")
    public void checkAllAsserts() {
        softAssert.assertAll();
    }
}
