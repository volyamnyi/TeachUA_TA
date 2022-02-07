package com.ita.edu.teachua.ui.pages.header_page;

import com.ita.edu.teachua.ui.elements.custom_elements.Button;
import com.ita.edu.teachua.ui.elements.custom_elements.Input;
import com.ita.edu.teachua.ui.elements.custom_elements.Label;
import com.ita.edu.teachua.ui.locators.header_locators.RestoringPasswordFinishPopUpLocators;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.Date;

public class RestoringPasswordFinishPopUpComponent extends BasePage {
    @FindBy(how = How.ID, using = RestoringPasswordFinishPopUpLocators.PASSWORD_FIELD_ID)
    private Input enterPassword;
    @FindBy(how = How.ID, using = RestoringPasswordFinishPopUpLocators.PASSWORD_CONFIRM_FIELD_ID)
    private Input reEnterPassword;
    @FindBy(how = How.XPATH, using = RestoringPasswordFinishPopUpLocators.CHANGE_PASSWORD_BUTTON_XPATH)
    private Button changePasswordButton;
    @FindBy(how = How.XPATH, using = RestoringPasswordFinishPopUpLocators.NEW_PASSWORD_INPUT_XPATH)
    private Input newPasswordInput;
    @FindBy(how = How.XPATH, using = RestoringPasswordFinishPopUpLocators.RESTORE_PASSWORD_INPUT_XPATH)
    private Input reenterPasswordInput;
    @FindBy(how = How.XPATH, using = RestoringPasswordFinishPopUpLocators.GREEN_MARK_ICON_XPATH)
    private Label greenMark;
    @FindBy(how = How.XPATH, using = RestoringPasswordFinishPopUpLocators.MESSAGE_CHANGE_PASSWORD_ERROR_XPATH)
    private Label changePasswordMessageError;
    @FindBy(how = How.XPATH, using = RestoringPasswordFinishPopUpLocators.MESSAGE_PASSWORD_ERROR_XPATH)
    private Label messagePasswordError;

    public RestoringPasswordFinishPopUpComponent(WebDriver driver) {
        super(driver);
    }


    @Step("Filling passwords fields by random valid values")
    public void setNewRandomPassword(){
        String newRandomPassword = String.format("Test_%d",new Date().getTime());
        enterPassword.set("");
        enterPassword.sendKeys(newRandomPassword);
        reEnterPassword.set("");
        reEnterPassword.sendKeys(newRandomPassword);
        changePasswordButton.click();
    }

    @Step("Fill in New password input: '{password}'")
    public RestoringPasswordFinishPopUpComponent fillInNewPasswordField(String password) {
        newPasswordInput.set(password);
        return this;
    }

    @Step("Fill in Reenter password input: '{password}'")
    public RestoringPasswordFinishPopUpComponent fillReenterNewPasswordField(String password) {
        reenterPasswordInput.set(password);
        return this;
    }

    @Step("Click on Change password button")
    public RestoringPasswordFinishPopUpComponent clickChangePasswordButton() {
        changePasswordButton.click();
        return this;
    }

    public String getChangePasswordError() {
        return changePasswordMessageError.getAttribute("innerText");
    }

    @Step("Check if green mark is present")
    public boolean isPresentGreenMark() {
        return greenMark.isDisplayed();
    }

    @Step("Get password error message")
    public String getMessagePasswordError() {
        return messagePasswordError.getAttribute("innerText");
    }

    @Step("Get password input field")
    public Input getEnterPassword(){
        return enterPassword;
    }

    public RestoringPasswordFinishPopUpComponent getRestoringPasswordFinishPopUpComponent(){
        return this;
    }
}