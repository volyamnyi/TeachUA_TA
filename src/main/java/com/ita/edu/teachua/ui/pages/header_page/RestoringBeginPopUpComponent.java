package com.ita.edu.teachua.ui.pages.header_page;

import com.ita.edu.teachua.ui.elements.custom_elements.Button;
import com.ita.edu.teachua.ui.elements.custom_elements.Input;
import com.ita.edu.teachua.ui.elements.custom_elements.Label;
import com.ita.edu.teachua.ui.locators.header_locators.RestoringBeginPopUpLocators;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import com.ita.edu.teachua.utils.GmailContentExtractor;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RestoringBeginPopUpComponent extends BasePage {
    @FindBy(how = How.ID, using = RestoringBeginPopUpLocators.EDIT_EMAIL_FIELD_ID)
    private Input editEmail;
    @FindBy(how = How.CSS, using = RestoringBeginPopUpLocators.RESTORE_CSS_SELECTOR)
    private Button restore;
    @FindBy(xpath ="//*[contains(text(),'Користувача з вказаним емейлом не знайдено')]")
    private Label invalidEmailMessage;
    @FindBy(xpath = "//*[@class='ant-form-item-children-icon']")
    private Label  redMark;
    @FindBy(xpath = "//*[contains(text(), 'Відновити')]/ancestor::button")
    private Button restoreButton;

    public RestoringBeginPopUpComponent(WebDriver driver) {
        super(driver);
    }

    @Step("Filling email field")
    public RestoringBeginPopUpComponent inputEmail(String email) {
        editEmail.clear();
        editEmail.sendKeys(email);
        return this;
    }
    @Step("Click on 'Відновити' button")
    public RestoringPasswordFinishPopUpComponent clickOnRestore() {
        restore.click();
        sleep(5000);
        driver.get(GmailContentExtractor.getGmailMessageLink("subject:Відновлення паролю"));
        return new RestoringPasswordFinishPopUpComponent(driver);
    }

    public String getInputBorderColor(){
        sleep(2000);
        return editEmail.getCssValue("border-color");
    }

    public String getInvalidEmailError(){
        sleep(2000);
        return invalidEmailMessage.getText();
    }

      public boolean isRedMarkVisible(){
        return redMark.isDisplayed();
    }

    @Step("Click on 'Відновити' button")
    public RestoringBeginPopUpComponent clickOnRestoreButton(){
        restoreButton.click();
        sleep(500);
        return this;
    }

    public RestoringBeginPopUpComponent getRestoringBeginPopUpComponent(){
        return this;
    }

}