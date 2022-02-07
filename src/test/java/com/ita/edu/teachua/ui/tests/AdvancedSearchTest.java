package com.ita.edu.teachua.ui.tests;

import com.ita.edu.teachua.ui.pages.advanced_search.AdvancedSearchPage;
import com.ita.edu.teachua.ui.pages.advanced_search.CentersItemComponent;
import com.ita.edu.teachua.ui.pages.advanced_search.ClubsItemComponent;
import com.ita.edu.teachua.ui.pages.main_page.MainPage;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AdvancedSearchTest extends TestRunner {

    @Description("TUA-510 Verify that 'Доступний онлайн', 'Категорії', 'Вік дитини' parameters are deactivated after selecting 'Центр' radio button")
    @Issue("TUA-510")
    @Test(description = "TUA-510")
    public void verifyAllParametersActiveCenterAdvancedSearch() {
        SoftAssert softAssert = new SoftAssert();
        AdvancedSearchPage advancedSearchPage = new MainPage(driver).clickAdvancedSearchButton().clickOnCenterRadioButton();
        softAssert.assertTrue(advancedSearchPage.getCityLabel().isDisplayed(), "City label is not displayed");
        softAssert.assertTrue(advancedSearchPage.getCitiesDropdown().isDisplayed(), "Cities dropdown is not displayed");
        softAssert.assertTrue(advancedSearchPage.getDistrictLabel().isDisplayed(), "District label is not displayed");
        softAssert.assertTrue(advancedSearchPage.getDistrictDropdown().isDisplayed(), "District dropdown is not displayed");
        softAssert.assertTrue(advancedSearchPage.getMetroStationLabel().isDisplayed(), "Metro station label is not displayed");
        softAssert.assertTrue(advancedSearchPage.getMetroDropdown().isDisplayed(), "Metro station dropdown is not displayed");

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(50));

        softAssert.assertNull(advancedSearchPage.getRemoteLabel(), "Remote label is displayed");
        softAssert.assertNull(advancedSearchPage.getAvailableOnlineCheckBox(), "Available online checkbox is displayed");
        softAssert.assertNull(advancedSearchPage.getSportSectionsCheckBox(), "Sport sections checkbox is displayed");
        softAssert.assertNull(advancedSearchPage.getDanceChoreographyCheckBox(), "Dance checkbox is  displayed");
        softAssert.assertNull(advancedSearchPage.getEarlyDevelopStudiesCheckBox(), "Early development studies checkbox is displayed");
        softAssert.assertNull(advancedSearchPage.getProgrammingStemCheckBox(), "Programming, STEM checkbox is displayed");
        softAssert.assertNull(advancedSearchPage.getBasicsCheckBox(), "Art studio, design checkbox is displayed");
        softAssert.assertNull(advancedSearchPage.getVocalMusicCheckBox(), "Vocal studio, music checkbox is displayed");
        softAssert.assertNull(advancedSearchPage.getActorsTheaterCheckBox(), "Actors, theater checkbox is displayed");
        softAssert.assertNull(advancedSearchPage.getPersonalDevelopmentCheckBox(), "Personal development checkbox is displayed");
        softAssert.assertNull(advancedSearchPage.getJournalismEditVideoCheckBox(), "Journalism, editing video checkbox is displayed");
        softAssert.assertNull(advancedSearchPage.getDevelopCenterCheckBox(), "Develop center checkbox is displayed");
        softAssert.assertNull(advancedSearchPage.getOtherCheckBox(), "Other checkbox is displayed");
        softAssert.assertNull(advancedSearchPage.getAgeLabel(), "Age label is displayed");

        softAssert.assertAll();
    }

    @Description("TUA-224 Advanced search button opens 'Розширений пошук' section")
    @Issue("TUA-224")
    @Test(description = "TUA-224")
    public void openAdvancedSearchFieldTest() {
        SoftAssert softAssert = new SoftAssert();
        MainPage mainPage = new MainPage(driver);
        boolean isPresent = mainPage
                .clickAdvancedSearchButton()
                .isSearchBlockPresent();
        softAssert.assertTrue(isPresent, "Розширений пошук section did not open");
        isPresent = mainPage
                .clickAdvancedSearchButton()
                .isSearchBlockPresent();
        softAssert.assertFalse(isPresent, "Розширений пошук section did not close");
        softAssert.assertAll();
    }

    @DataProvider
    public Object[][] checkByAgeDataProvider() {
        return new Object[][]{
                {"2", "2"},
                {"18", "18"},
                {"1", "2"},
                {"19", "18"}
        };
    }

    @Description("TUA-210 Verify that input field 'Вік дитини' accepts only positive integers from 2 to 18")
    @Issue("TUA-210")
    @Test(dataProvider = "checkByAgeDataProvider", description = "TUA-210")
    public void checkByValidAgeDataProvider(String input, String expectedResult) {
        String actualResult = new MainPage(driver).clickAdvancedSearchButton()
                .setValueAgeInput(input)
                .pressEnterAgeInput()
                .getAgeInput().getText();
        Assert.assertEquals(actualResult, expectedResult);

    }

    @Description("Verify that all parameters are activated with the selected 'Гурток' radio button")
    @Issue("TUA-509")
    @Test(description = "TUA-509")
    public void verifyAllParametersActiveClubsAdvancedSearch() {
        SoftAssert softAssert = new SoftAssert();
        AdvancedSearchPage advancedSearchPage = new MainPage(driver).clickAdvancedSearchButton();
        softAssert.assertTrue(advancedSearchPage.getClubsRadioButton().getAttribute("class").contains("checked"), "Clubs radio button is not selected");
        softAssert.assertTrue(advancedSearchPage.getCityLabel().isDisplayed(), "City label is not displayed");
        softAssert.assertTrue(advancedSearchPage.getCitiesDropdown().isDisplayed(), "Cities dropdown is not displayed");
        softAssert.assertTrue(advancedSearchPage.getDistrictLabel().isDisplayed(), "District label is not displayed");
        softAssert.assertTrue(advancedSearchPage.getDistrictDropdown().isDisplayed(), "District dropdown is not displayed");
        softAssert.assertTrue(advancedSearchPage.getMetroStationLabel().isDisplayed(), "Metro station label is not displayed");
        softAssert.assertTrue(advancedSearchPage.getMetroDropdown().isDisplayed(), "Metro station dropdown is not displayed");
        softAssert.assertTrue(advancedSearchPage.getRemoteLabel().isDisplayed(), "Remote label is not displayed");
        softAssert.assertTrue(advancedSearchPage.getAvailableOnlineCheckBox().isDisplayed(), "Available online checkbox is not displayed");
        softAssert.assertTrue(advancedSearchPage.getCategoriesLabel().isDisplayed(), "Categories label is not displayed");
        softAssert.assertTrue(advancedSearchPage.getSportSectionsCheckBox().isDisplayed(), "Sport sections checkbox is not displayed");
        softAssert.assertTrue(advancedSearchPage.getDanceChoreographyCheckBox().isDisplayed(), "Dance checkbox is not displayed");
        softAssert.assertTrue(advancedSearchPage.getEarlyDevelopStudiesCheckBox().isDisplayed(), "Early development studies checkbox is not displayed");
        softAssert.assertTrue(advancedSearchPage.getProgrammingStemCheckBox().isDisplayed(), "Programming, STEM checkbox is not displayed");
        softAssert.assertTrue(advancedSearchPage.getBasicsCheckBox().isDisplayed(), "Basics checkbox is not displayed");
        softAssert.assertTrue(advancedSearchPage.getBasicsJava444CheckBox().isDisplayed(), "Basics Java444 checkbox is not displayed");
        softAssert.assertTrue(advancedSearchPage.getVocalMusicCheckBox().isDisplayed(), "Vocal studio, music checkbox is not displayed");
        softAssert.assertTrue(advancedSearchPage.getActorsTheaterCheckBox().isDisplayed(), "Actors, theater checkbox is not displayed");
        softAssert.assertTrue(advancedSearchPage.getPersonalDevelopmentCheckBox().isDisplayed(), "Personal development checkbox is not displayed");
        softAssert.assertTrue(advancedSearchPage.getJournalismEditVideoCheckBox().isDisplayed(), "Journalism, editing video checkbox is not displayed");
        softAssert.assertTrue(advancedSearchPage.getDevelopCenterCheckBox().isDisplayed(), "Develop center checkbox is not displayed");
        softAssert.assertTrue(advancedSearchPage.getOtherCheckBox().isDisplayed(), "Other checkbox is not displayed");
        softAssert.assertTrue(advancedSearchPage.getAgeLabel().isDisplayed(), "Age label is not displayed");
        softAssert.assertAll();
    }

    @Description("TUA-513-Verify that the centers in the results of advanced search can be displayed as a list")
    @Severity(SeverityLevel.CRITICAL)
    @Issue("TUA-513")
    @Test(description = "TUA-513")
    public void checkIfCentersAreDisplayedAsAList() {
        SoftAssert softAssert = new SoftAssert();
        MainPage mainPage = new MainPage(driver);
        String urlMainPage = mainPage.getMainPageUrL();
        softAssert.assertEquals("https://speak-ukrainian.org.ua/dev/", urlMainPage, "URLs did NOT match");

        AdvancedSearchPage advancedSearchPage = mainPage.clickAdvancedSearchButton();
        String title = advancedSearchPage.getTitleOfAdvancedSearchField();
        softAssert.assertEquals(title, "Розширений пошук", "Title did NOT match");

        boolean checkThatWorkshopRadioButtonIsChosenByDefault = advancedSearchPage.getWorkshopRadioButton().isDisplayed();
        softAssert.assertTrue(checkThatWorkshopRadioButtonIsChosenByDefault, "Workshop radiobutton is NOT selected");

        boolean CenterRadioButtonSelected = advancedSearchPage
                .clickOnCenterRadioButton()
                .getCenterRadioButton().isDisplayed();
        softAssert.assertTrue(CenterRadioButtonSelected, "Center radiobutton is NOT selected");

        advancedSearchPage.clickOnListIcon();
        for (CentersItemComponent club : advancedSearchPage.getCards()) {
            softAssert.assertTrue(club.isList(), "Clubs are NOT displayed as list");
        }
        softAssert.assertAll();
    }

    @Issue("TUA-103")
    @Description("Verify that sorting by name for advanced search works correctly (In ascending order)")
    @Test(description = "TUA-103")
    public void checkSortingClubsByNameInAscendingOrder() {
        MainPage mainPage = new MainPage(driver);
        AdvancedSearchPage advSearch = mainPage.clickAdvancedSearchButton();
        boolean actual = isAlphabeticallySorted(getTitlesFromAllPages(advSearch), true);
        Assert.assertTrue(actual);
    }

    @Issue("TUA-103")
    @Description("Verify that sorting by name for advanced search works correctly (In descending order)")
    @Test(description = "TUA-103")
    public void checkSortingClubsByNameInDescendingOrder() {
        MainPage mainPage = new MainPage(driver);
        AdvancedSearchPage advSearch = mainPage
                .clickAdvancedSearchButton()
                .clickOnArrowUpButton();
        boolean actual = isAlphabeticallySorted(getTitlesFromAllPages(advSearch), false);
        Assert.assertTrue(actual);
    }

    public List<String> getTitlesFromAllPages(AdvancedSearchPage advancedSearchPage) {
        List<ClubsItemComponent> cards;
        List<String> stringCards = new ArrayList<>();
        int n = advancedSearchPage.getNumberOfPagesWithClubs();
        for (int i = 0; i < n; ++i) {
            cards = advancedSearchPage.getClubCards();
            for (ClubsItemComponent card : cards) {
                stringCards.add(card.getCardTitle().getText());
            }
            advancedSearchPage.clickOnNextPageButton();
        }
        return stringCards;
    }

    public boolean isAlphabeticallySorted(List<String> titles, boolean asc) {
        for (int j = 0; j < titles.size() - 1; j++) {
            char[] firstTitle = titles.get(j).toLowerCase().replaceAll("[^а-яА-Яa-zA-Z0-9]", "").toCharArray();
            char[] secondTitle = titles.get(j + 1).toLowerCase().replaceAll("[^а-яА-Яa-zA-Z0-9]", "").toCharArray();
            int wordLength = Math.min(firstTitle.length, secondTitle.length);
            for (int k = 0; k < wordLength; k++) {
                if (asc) {
                    if (firstTitle[k] < secondTitle[k]) {
                        break;
                    } else if (firstTitle[k] > secondTitle[k]) {
                        return false;
                    }
                }
                if (!asc) {
                    if (firstTitle[k] > secondTitle[k]) {
                        break;
                    } else if (firstTitle[k] < secondTitle[k]) {
                        return false;
                    }
                }
            }
        }
        return titles.size() != 0;
    }

    @Issue("TUA-103")
    @Description("Verify that sorting by rating for advanced search works correctly (In ascending order)")
    @Test(description = "TUA-103")
    public void checkSortingClubsByRatingInAscendingOrder() {
        MainPage mainPage = new MainPage(driver);
        AdvancedSearchPage advSearch = mainPage
                .clickAdvancedSearchButton()
                .clickOnSortByRatingButton();
        boolean actual = isSortedByRating(getRatingsFromAllPages(advSearch), true);
        Assert.assertTrue(actual);
    }

    @Issue("TUA-103")
    @Description("Verify that sorting by rating for advanced search works correctly (In descending order)")
    @Test(description = "TUA-103")
    public void checkSortingClubsByRatingInDescendingOrder() {
        MainPage mainPage = new MainPage(driver);
        AdvancedSearchPage advSearch = mainPage
                .clickAdvancedSearchButton()
                .clickOnSortByRatingButton()
                .clickOnArrowUpButton();
        boolean actual = isSortedByRating(getRatingsFromAllPages(advSearch), false);
        Assert.assertTrue(actual);
    }

    public List<Integer> getRatingsFromAllPages(AdvancedSearchPage advancedSearchPage) {
        List<ClubsItemComponent> cards;
        List<Integer> ratings = new ArrayList<>();
        int n = advancedSearchPage.getNumberOfPagesWithClubs();
        for (int i = 0; i < n; ++i) {
            cards = advancedSearchPage.getClubCards();
            for (ClubsItemComponent card : cards) {
                ratings.add(card.getRating());
            }
            advancedSearchPage.clickOnNextPageButton();
        }
        return ratings;
    }

    public boolean isSortedByRating(List<Integer> ratings, boolean asc) {
        for (int j = 0; j < ratings.size() - 1; j++) {
            if (asc) {
                if (ratings.get(j) > ratings.get(j + 1)) {
                    break;
                } else if (ratings.get(j) < ratings.get(j + 1)) {
                    return false;
                }
            }
            if (!asc) {
                if (ratings.get(j) < ratings.get(j + 1)) {
                    break;
                } else if (ratings.get(j) > ratings.get(j + 1)) {
                    return false;
                }
            }
        }
        return ratings.size() != 0;
    }
}