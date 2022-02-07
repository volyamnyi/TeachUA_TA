package com.ita.edu.teachua.ui.pages.clubs_page;

import com.ita.edu.teachua.ui.elements.custom_elements.Button;
import com.ita.edu.teachua.ui.elements.custom_elements.Label;
import com.ita.edu.teachua.ui.locators.clubs_page_locators.ClubsPageLocators;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ClubsPage extends BasePage {

    @FindBy(how = How.XPATH, using = ClubsPageLocators.NEXT_PAGE_BUTTON_XPATH)
    private Button nextPageButton;
    @FindBy(how = How.XPATH, using = ClubsPageLocators.LAST_PAGE_BUTTON_XPATH)
    private Button lastPageButton;
    @FindAll(@FindBy(how = How.CSS, using = ClubsPageLocators.CARD_TITLE_CSS_SELECTOR))
    private List<WebElement> cartTitles;
    @FindBy(how = How.CSS, using = ClubsPageLocators.INVALID_CLUBS_BASIC_SEARCH_CSS_SELECTOR)
    private Label invalidSearchPageTitle;

    public ClubsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Check if {title} of invalid search results is present on the page")
    public String getTitleOfInvalidSearchPage() {
        return invalidSearchPageTitle.getText();
    }

    @Step("Check if club {title} is present on the page")
    public boolean isClubPresent(String title) {
        int attempts = 10;
        for (int i = 0; i < attempts; i++) {
            if (driver.getCurrentUrl().equals("https://speak-ukrainian.org.ua/dev/clubs")) {
                break;
            }
            sleep(100);
        }
        List<WebElement> titles = cartTitles; // TODO change to cards list
        boolean isPresent = false;
        String res = "";
        for (WebElement t : titles) {
            try {
                res = t.getText();
            } catch (StaleElementReferenceException e) {
                sleep(100);
                return isClubPresent(title);
            }
            if (res.equals(title)) {
                isPresent = true;
            }
        }
        return isPresent;
    }

    public ClubsPage clickOnNextPageButton() {
        nextPageButton.click();
        return this;
    }

    public int getNumberOfPagesWithClubs() {
        return Integer.parseInt(lastPageButton.getText());
    }

    public ClubsPage getClubsPage(){
        return this;
    }
}
