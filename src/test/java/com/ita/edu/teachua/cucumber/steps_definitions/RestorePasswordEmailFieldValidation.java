package com.ita.edu.teachua.cucumber.steps_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class RestorePasswordEmailFieldValidation {
    private BaseDefinition baseDef;
    private PageContext pageContext;

    public RestorePasswordEmailFieldValidation(BaseDefinition baseDef) {
        this.baseDef = baseDef;
        pageContext = new PageContext(baseDef.getDriver());
    }

    @Given("Click on Guest DropDown icon")
    public void clickOnGuestDropDownIcon() {
        pageContext.getAllPages().getHeaderPage().clickOnGuestDropdown();
    }

    @And("Select Увійти option")
    public void clickOnLoginButton() {
        pageContext.getAllHeaderComponents().getGuestDropdownComponent().clickOnLoginButton();
    }

    @And("Click on Забули пароль? button")
    public void clickOnForgotPasswordButton() {
        pageContext.getAllHeaderComponents().getLoginPopUpComponent().clickOnForgotPasswordButton();
    }

    @And("Click on the Відновити button")
    public void clickOnRestoreButton() {
        pageContext.getAllHeaderComponents().getRestoringBeginPopUpComponent().clickOnRestoreButton();
    }

    @When("Enter {email} in the Email field")
    public void enterEmailInTheEmailField(String email) {
        pageContext.getAllHeaderComponents().getRestoringBeginPopUpComponent().inputEmail(email);
    }

    @Then("Frame of the field becomes {color} color")
    public void frameOfTheFieldBecomesColorColor(String expectedFrameColor) {
        String actualFrameColor = pageContext.getAllHeaderComponents().getRestoringBeginPopUpComponent().getInputBorderColor();
        Assert.assertEquals(actualFrameColor, expectedFrameColor);
    }

}