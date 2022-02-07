package com.ita.edu.teachua.ui.pages.main_page;

import com.ita.edu.teachua.ui.elements.custom_elements.Button;
import com.ita.edu.teachua.ui.elements.custom_elements.Input;
import com.ita.edu.teachua.ui.elements.custom_elements.Link;
import com.ita.edu.teachua.ui.locators.main_page_locators.MainPageLocators;
import com.ita.edu.teachua.ui.pages.advanced_search.AdvancedSearchPage;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import com.ita.edu.teachua.ui.pages.clubs_page.ClubsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class MainPage extends BasePage {
    @FindBy(how = How.XPATH, using = MainPageLocators.CLUBS_LINK_XPATH)
    private Link clubsLink;
    @FindBy(how = How.XPATH, using = MainPageLocators.ADVANCED_SEARCH_BUTTON_XPATH)
    private Button advancedSearch;
    @FindBy(how = How.CSS, using = MainPageLocators.SEARCH_INPUT_FIELD_CSS)
    private Input searchInput;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get url being on the main page")
    public String getMainPageUrL() {
        return driver.getCurrentUrl();
    }

    @Step("Click on 'Розширений пошук' icon")
    public AdvancedSearchPage clickAdvancedSearchButton() {
        advancedSearch.click();
        return new AdvancedSearchPage(driver);
    }

    public void clickSearchInput(Input searchInput) {
        searchInput.click();
        this.searchInput = searchInput;
    }

    public ClubsPage clickOnClubs() {
        clubsLink.click();
        return new ClubsPage(driver);
    }

    @Step("Type *{input}* in search field")
    public ClubsPage inputStringInSearchField(String input) {
        searchInput.sendKeys(input);
        return new ClubsPage(driver);
    }

    @Step("Insert from clipboard *{input}* in search field")
    public ClubsPage pasteClipBoardStringInSearchField(String input) {
        StringSelection stringSelection = new StringSelection(input);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        searchInput.sendKeys(Keys.CONTROL + "V");
        //searchInput.sendKeys(Keys.SHIFT, Keys.INSERT);
        return new ClubsPage(driver);
    }

    public MainPage getMainPage(){
        return this;
    }
}