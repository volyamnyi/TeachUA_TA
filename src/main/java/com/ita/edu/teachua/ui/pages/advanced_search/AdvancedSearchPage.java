package com.ita.edu.teachua.ui.pages.advanced_search;


import com.ita.edu.teachua.ui.elements.custom_elements.*;
import com.ita.edu.teachua.ui.locators.advanced_search_page_locators.AdvancedSearchPageLocators;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

public class AdvancedSearchPage extends BasePage {

    private final Integer AMOUNT_OF_CLUBS_ON_ONE_PAGE = 6;

    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.CLUB_RADIOBUTTON_XPATH)
    private RadioButton clubsRadioButton;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.CITY_LABEL_XPATH)
    private Label cityLabel;
    @FindBy(how = How.CLASS_NAME, using = AdvancedSearchPageLocators.CITIES_DROPDOWN_CLASS_NAME)
    private Dropdown citiesDropdown;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.DISTRICT_LABEL_XPATH)
    private Label districtLabel;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.DISTRICT_DROPDOWN_XPATH)
    private Dropdown districtDropdown;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.NEAREST_STATION_LABEL_XPATH)
    private Label metroStationLabel;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.NEAREST_STATION_DROPDOWN_XPATH)
    private Dropdown metroDropdown;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.REMOTE_LABEL_XPATH)
    private Label remoteLabel;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.AVAILABLE_ONLINE_CHECKBOX_XPATH)
    private CheckBox availableOnlineCheckBox;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.CATEGORIES_LABEL_XPATH)
    private Label categoriesLabel;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.SPORT_SECTIONS_CHECKBOX_XPATH)
    private CheckBox sportSectionsCheckBox;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.DANCE_CHOREOGRAPHY_CHECKBOX_XPATH)
    private CheckBox danceChoreographyCheckBox;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.EARLY_DEVELOPMENT_STUDIES_CHECKBOX_XPATH)
    private CheckBox earlyDevelopStudiesCheckBox;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.PROGRAMING_STEM_CHECKBOX_XPATH)
    private CheckBox programmingStemCheckBox;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.BASICS_XPATH)
    private CheckBox basicsCheckBox;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.BASICS_JAVA444_XPATH)
    private CheckBox basicsJava444CheckBox;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.VOCAL_MUSIC_CHECKBOX_XPATH)
    private CheckBox vocalMusicCheckBox;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.ACTORS_THEATER_CHECKBOX_XPATH)
    private CheckBox actorsTheaterCheckBox;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.PERSONAL_DEVELOPMENT_CHECKBOX_XPATH)
    private CheckBox personalDevelopmentCheckBox;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.JOURNALISM_EDITING_VIDEO_CHECKBOX_XPATH)
    private CheckBox journalismEditVideoCheckBox;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.DEVELOPMENT_CENTER_CHECKBOX_XPATH)
    private CheckBox developCenterCheckBox;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.OTHER_CHECKBOX_XPATH)
    private CheckBox otherCheckBox;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.AGE_LABEL_XPATH)
    private Label ageLabel;
    @FindBy(how = How.CSS, using = AdvancedSearchPageLocators.AGE_INPUT_CSS_SELECTOR)
    private Input ageInput;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.WORKSHOP_RADIO_BUTTON_XPATH)
    private RadioButton workShopRadioButton;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.CENTER_RADIO_BUTTON_XPATH)
    private RadioButton centerRadioButton;
    @FindBy(how = How.CSS, using = AdvancedSearchPageLocators.LIST_ICON_IN_MENU_BAR_CSS_SELECTOR)
    private Button listIcon;
    @FindBy(how = How.CSS, using = AdvancedSearchPageLocators.ADVANCED_SEARCH_BLOCK_CSS_SELECTOR)
    private Div advancedSearchBlock;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.CENTER_RADIO_BUTTON_CHECKED_XPATH)
    private RadioButton centerRadioButtonChecked;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.ADVANCED_SEARCH_FIELD_TITLE_XPATH)
    private Label advancedSearchFieldTitle;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.CENTER_ITEM_XPATH)
    private Label centerItem; //or not label
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.CENTER_ADDRESS_XPATH)
    private Label centerAddress;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.NEXT_PAGE_BUTTON_XPATH)
    private Button nextPageButton;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.LAST_PAGE_BUTTON_XPATH)
    private Button lastPageButton;
    @FindAll(@FindBy(how = How.CSS, using = AdvancedSearchPageLocators.CENTER_BLOCKS_CSS_SELECTOR))
    private List<Button> centerBlocks;
    @FindAll(@FindBy (how = How.XPATH, using = AdvancedSearchPageLocators.CLUB_CARD_XPATH))
    private List<WebElement> clubCards;
    @FindAll(@FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.ADVANCED_SEARCH_FIELD_TITLE_XPATH))
    private List<Button> searchFields;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.ARROW_UPP_BUTTON_XPATH)
    private Button arrowUpButton;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.SORT_BY_RATING_BUTTON_XPATH)
    private Button sortByRatingButton;
    @FindAll(@FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.CLUB_CARD_XPATH))
    private List<WebElement> clubsCards;

    public AdvancedSearchPage(WebDriver driver) {
        super(driver);
    }

    @Step("Type *{input}* in age field")
    public AdvancedSearchPage setValueAgeInput(String input) {
        ageInput.clear();
        ageInput.sendKeys(input);
        return this;
    }

    public CheckBox getVocalMusicCheckBox() {
        try {
            vocalMusicCheckBox.isDisplayed();
        } catch (NoSuchElementException e) {
            return null;
        }
        return vocalMusicCheckBox;
    }

    public RadioButton getClubsRadioButton() {
        return clubsRadioButton;
    }

    public Label getCityLabel() {
        return cityLabel;
    }

    public Dropdown getDistrictDropdown() {
        return districtDropdown;
    }

    public Dropdown getMetroDropdown() {
        return metroDropdown;
    }

    public CheckBox getAvailableOnlineCheckBox() {
        try {
            availableOnlineCheckBox.isDisplayed();
        } catch (NoSuchElementException e) {
            return null;
        }
        return availableOnlineCheckBox;
    }

    public CheckBox getSportSectionsCheckBox() {
        try {
            sportSectionsCheckBox.isDisplayed();
        } catch (NoSuchElementException e) {
            return null;
        }
        return sportSectionsCheckBox;
    }

    public CheckBox getDanceChoreographyCheckBox() {
        try {
            danceChoreographyCheckBox.isDisplayed();
        } catch (NoSuchElementException e) {
            return null;
        }
        return danceChoreographyCheckBox;
    }

    public CheckBox getEarlyDevelopStudiesCheckBox() {
        try {
            earlyDevelopStudiesCheckBox.isDisplayed();
        } catch (NoSuchElementException e) {
            return null;
        }
        return earlyDevelopStudiesCheckBox;
    }

    public CheckBox getProgrammingStemCheckBox() {
        try {
            programmingStemCheckBox.isDisplayed();
        } catch (NoSuchElementException e) {
            return null;
        }
        return programmingStemCheckBox;
    }

    public CheckBox getBasicsCheckBox() {
        try {
            basicsCheckBox.isDisplayed();
        } catch (NoSuchElementException e) {
            return null;
        }
        return basicsCheckBox;
    }

    public CheckBox getBasicsJava444CheckBox() {
        try {
            basicsJava444CheckBox.isDisplayed();
        } catch (NoSuchElementException e) {
            return null;
        }
        return basicsJava444CheckBox;
    }

    public CheckBox getActorsTheaterCheckBox() {
        try {
            actorsTheaterCheckBox.isDisplayed();
        } catch (NoSuchElementException e) {
            return null;
        }
        return actorsTheaterCheckBox;
    }

    public CheckBox getPersonalDevelopmentCheckBox() {
        try {
            personalDevelopmentCheckBox.isDisplayed();
        } catch (NoSuchElementException e) {
            return null;
        }
        return personalDevelopmentCheckBox;
    }

    public CheckBox getJournalismEditVideoCheckBox() {
        try {
            journalismEditVideoCheckBox.isDisplayed();
        } catch (NoSuchElementException e) {
            return null;
        }
        return journalismEditVideoCheckBox;
    }

    public CheckBox getDevelopCenterCheckBox() {
        try {
            developCenterCheckBox.isDisplayed();
        } catch (NoSuchElementException e) {
            return null;
        }
        return developCenterCheckBox;
    }

    public CheckBox getOtherCheckBox() {
        try {
            otherCheckBox.isDisplayed();
        } catch (NoSuchElementException e) {
            return null;
        }
        return otherCheckBox;
    }

    @Step("Get text of 'Вік дитини' field")
    public Input getAgeInput() {
        return ageInput;
    }

    @Step("press 'Enter' key after filling in 'Вік дитини' field")
    public AdvancedSearchPage pressEnterAgeInput() {
        ageInput.pressEnter();
        return this;
    }

    public Dropdown getCitiesDropdown() {
        return citiesDropdown;
    }

    public Label getDistrictLabel() {
        return districtLabel;
    }

    public Label getMetroStationLabel() {
        return metroStationLabel;
    }

    public Label getRemoteLabel() {
        try {
            remoteLabel.isDisplayed();
        } catch (NoSuchElementException e) {
            return null;
        }
        return remoteLabel;
    }

    public Label getCategoriesLabel() {
        try {
            categoriesLabel.isDisplayed();
        } catch (NoSuchElementException e) {
            return null;
        }
        return categoriesLabel;
    }

    public Label getAgeLabel() {
        try {
            ageLabel.isDisplayed();
        } catch (NoSuchElementException e) {
            return null;
        }
        return ageLabel;
    }

    @Step("Get 'Гурток' radiobutton")
    public RadioButton getWorkshopRadioButton() {
        return workShopRadioButton;
    }

    @Step("Click on  'Центр' radiobutton")
    public AdvancedSearchPage clickOnCenterRadioButton() {
        centerRadioButton.click();
        return this;
    }

    @Step("Get 'Центр' radiobutton")
    public RadioButton getCenterRadioButton() {
        return centerRadioButton;
    }

    @Step("Click on list icon")
    public AdvancedSearchPage clickOnListIcon() {
        listIcon.click();
        return this;
    }

    @Step("Get centers cards")
    public List<CentersItemComponent> getCards() {
        List<CentersItemComponent> centerBlocks = new ArrayList<>();
        for (WebElement j : this.centerBlocks) {
            centerBlocks.add(new CentersItemComponent(driver, j));
        }
        return centerBlocks;
    }

    @Step("Get all clubs cards")
    public List<ClubsItemComponent> getClubCards() {
        this.sleep(3000);
        List<ClubsItemComponent> cards = new ArrayList<>();
        List<WebElement> clubs = clubsCards;
        for (WebElement j : clubs) {
            cards.add(new ClubsItemComponent(driver, j));
        }
        return cards;
    }

    @Step("Get text of title 'Розширений пошук'")
    public String getTitleOfAdvancedSearchField() {
        return advancedSearchFieldTitle.getText();
    }

    public boolean isSearchBlockPresent() {
        try {
            advancedSearchBlock.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step("Go to the next page with clubs")
    public AdvancedSearchPage clickOnNextPageButton() {
        this.sleep(1000);
        //this.waitUntilVisibilityOfElementLocated(By.xpath(AdvancedSearchPageLocators.NEXT_PAGE_BUTTON_XPATH), 5);
        nextPageButton.click();
        return this;
    }

    @Step("Get number of pages with clubs")
    public int getNumberOfPagesWithClubs() {
        this.sleep(1000);
        //this.waitForAmountOfElements(By.xpath(AdvancedSearchPageLocators.CLUB_CARD_XPATH), AMOUNT_OF_CLUBS_ON_ONE_PAGE, 5);
        //this.waitUntilVisibilityOfElementLocated(By.xpath(AdvancedSearchPageLocators.LAST_PAGE_BUTTON_XPATH), 5);
        return Integer.parseInt(lastPageButton.getInnerText());
    }

    @Step("Click on arrow up to sort clubs in descending order")
    public AdvancedSearchPage clickOnArrowUpButton() {
        this.sleep(1000);
        arrowUpButton.click();
        return this;
    }

    @Step("Click on 'за рейтингом' to sort clubs by rating in descending order")
    public AdvancedSearchPage clickOnSortByRatingButton() {
        this.sleep(1000);
        sortByRatingButton.click();
        return this;
    }

    public AdvancedSearchPage getAdvancedSearchPage(){
        return this;
    }}