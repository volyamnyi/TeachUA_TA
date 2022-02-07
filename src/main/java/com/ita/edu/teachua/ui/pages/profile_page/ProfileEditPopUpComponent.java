package com.ita.edu.teachua.ui.pages.profile_page;


import com.ita.edu.teachua.ui.elements.custom_elements.Button;
import com.ita.edu.teachua.ui.elements.custom_elements.CheckBox;
import com.ita.edu.teachua.ui.elements.custom_elements.Input;
import com.ita.edu.teachua.ui.elements.custom_elements.Label;
import com.ita.edu.teachua.ui.locators.profile_locators.ProfileEditPopUpLocators;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProfileEditPopUpComponent extends BasePage {


    @FindBy(how = How.XPATH, using = ProfileEditPopUpLocators.PHONE_EDIT_XPATH)
    private Input phone;
    @FindBy(how = How.XPATH, using = ProfileEditPopUpLocators.FIRSTNAME_EDIT_XPATH)
    private Input firstName;
    @FindBy(how = How.XPATH, using = ProfileEditPopUpLocators.LASTNAME_EDIT_XPATH)
    private Input lastName;
    @FindBy(how = How.XPATH, using = ProfileEditPopUpLocators.SAVE_BUTTON_XPATH)
    private Button saveButton;
    @FindBy(how = How.XPATH, using = ProfileEditPopUpLocators.PASSWORD_EDIT_CHECKBOX_XPATH)
    private CheckBox changePassword;
    @FindBy(how = How.XPATH, using = ProfileEditPopUpLocators.SAVE_BUTTON_XPATH)
    private Button saveChangeButton;
    @FindBy(how = How.XPATH, using = ProfileEditPopUpLocators.CURRENT_PASSWORD_INPUT_XPATH)
    private Input currentPasswordInput;
    @FindBy(how = How.XPATH, using = ProfileEditPopUpLocators.NEW_PASSWORD_INPUT_XPATH)
    private Input newPasswordInput;
    @FindBy(how = How.XPATH, using = ProfileEditPopUpLocators.CONFIRM_PASSWORD_INPUT_XPATH)
    private Input confirmPasswordInput;
    @FindBy(how = How.XPATH, using = ProfileEditPopUpLocators.MESSAGE_INVALID_INPUT_XPATH)
    private Label messageInvalidInput;
    @FindBy(how = How.XPATH, using = ProfileEditPopUpLocators.CURRENT_PASSWORD_ERROR_MESSAGE_XPATH)
    private Label currentPasswordErrorMessage;
    @FindBy(how = How.XPATH, using = ProfileEditPopUpLocators.NEW_PASSWORD_ERROR_MESSAGE_XPATH)
    private Label newPasswordErrorMessage;
    @FindBy(how = How.XPATH, using = ProfileEditPopUpLocators.CONFIRM_PASSWORD_ERROR_MESSAGE_XPATH)
    private Label confirmPasswordErrorMessage;
    @FindBy(how = How.XPATH, using = ProfileEditPopUpLocators.ROLE_USER_BUTTON_XPATH)
    private Button roleUserButton;
    @FindBy(how = How.XPATH, using = ProfileEditPopUpLocators.ROLE_MANAGER_BUTTON_XPATH)
    private Button roleManagerButton;

    public ProfileEditPopUpComponent(WebDriver driver) {
        super(driver);
    }

    @Step("Fill {phoneNumber} in phone field")
    public ProfileEditPopUpComponent fillPhone(String phoneNumber) {
        phone.set(phoneNumber);
        sleep(2000);
        return this;
    }

    @Step("Fill {firstNameFill} in first name field")
    public ProfileEditPopUpComponent fillFirstName(String firstNameFill) {
        sleep(100);
        firstName.clear();
        firstName.set(firstNameFill);
        return this;
    }

    @Step("Fill {lastNameFill} in last name field")
    public ProfileEditPopUpComponent fillLastName(String lastNameFill) {
        lastName.clear();
        lastName.set(lastNameFill);
        return this;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public ProfileEditPopUpComponent clickSubmit() {
        saveButton.click();
        return this;
    }


    public String getMessage() {
        sleep(1000);
        return messageInvalidInput.getText();
    }

    public ProfileEditPopUpComponent clickOnChangePasswordCheckBox() {
        try {
            changePassword.click();
        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
            sleep(200);
            return clickOnChangePasswordCheckBox();
        }
        return this;
    }
    @Step("Click on role user button 'Відвідувач'")
    public ProfileEditPopUpComponent clickOnRoleUser(){
        roleUserButton.click();
        return this;
    }
    @Step("Click on role manager button 'Керівник'")
    public ProfileEditPopUpComponent clickOnRoleManager(){
        roleManagerButton.click();
        return this;
    }

    @Step("Click on Save change button")
    public ProfileEditPopUpComponent clickOnSaveChangeButton() {
        saveChangeButton.click();
        return this;
    }

    public String getErrorMessageCurrentPasswordInput() {
        return currentPasswordErrorMessage.getAttribute("innerText");
    }

    public String getErrorMessageNewPasswordInput() {
        return newPasswordErrorMessage.getAttribute("innerText");
    }

    public String getErrorMessageConfirmPasswordInput() {
        return confirmPasswordErrorMessage.getAttribute("innerText");
    }

    public String getCurrentPasswordInputBorderColor() {
        sleep(300);
        return currentPasswordInput.getCssValue("border-color");
    }

    public String getNewPasswordInputBorderColor() {
        sleep(300);
        return newPasswordInput.getCssValue("border-color");
    }

    public String getConfirmPasswordInputBorderColor() {
        sleep(300);
        return confirmPasswordInput.getCssValue("border-color");
    }

    @Step("Fill in current password input: '{currentPassword}'")
    public ProfileEditPopUpComponent fillInCurrentPasswordInput(String currentPassword) {
        waitUntilVisibilityOfElementLocated(By.xpath(ProfileEditPopUpLocators.CURRENT_PASSWORD_INPUT_XPATH), 5);
        currentPasswordInput.set(currentPassword);
        return this;
    }

    @Step("Fill in new password input: '{newPassword}'")
    public ProfileEditPopUpComponent fillInNewPasswordInput(String newPassword) {
        waitUntilVisibilityOfElementLocated(By.xpath(ProfileEditPopUpLocators.NEW_PASSWORD_INPUT_XPATH), 5);
        newPasswordInput.set(newPassword);
        return this;
    }

    @Step("Fill in confirm password input: '{confirmPassword}'")
    public ProfileEditPopUpComponent fillInConfirmPasswordInput(String confirmPassword) {
        waitUntilVisibilityOfElementLocated(By.xpath(ProfileEditPopUpLocators.CONFIRM_PASSWORD_INPUT_XPATH), 5);
        confirmPasswordInput.set(confirmPassword);
        return this;
    }

    @Step("Select Change password checkbox")
    public ProfileEditPopUpComponent checkChangePasswordCheckBox() {
        waitUntilVisibilityOfElementLocated(By.xpath(ProfileEditPopUpLocators.PASSWORD_EDIT_CHECKBOX_XPATH), 5);
        changePassword.toggle();
        return this;
    }

    public ProfileEditPopUpComponent getProfileEditPopUpComponent(){
        return this;
    }
}
