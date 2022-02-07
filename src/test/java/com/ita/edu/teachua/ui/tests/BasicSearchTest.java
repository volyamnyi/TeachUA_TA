package com.ita.edu.teachua.ui.tests;

import com.ita.edu.teachua.ui.pages.main_page.MainPage;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BasicSearchTest extends TestRunner {

    @DataProvider
    public Object[][] clubsNameSearchTestDataProvider() {
        return new Object[][]{
                {"American Gymnastics Club"},
                {"IT освіта: курси \"ГРАНД\""},
                {"Онлайн-школа точних наук YOUSTUD"},
                {"Театральна Студія \"Зоряні Діти''"},
                {"Студія танцю \"Несамовиті\""},
                {"LESKIV-SCHOOL"},
                {"Школа танців Dream Team"}
        };
    }

    @Description("TUA-226 Verify that user can perform basic search by inserting name of a club")
    @Issue("TUA-226")
    @Test(invocationCount = 1, dataProvider = "clubsNameSearchTestDataProvider",description = "TUA-226")
    public void checkSearchWithNameOfClubsClipBoard(String data) {
        boolean isPresent = new MainPage(driver)
                .pasteClipBoardStringInSearchField(data)
                .isClubPresent(data);
        Assert.assertTrue(isPresent);
    }

    @Description("TUA-226 Verify that user can perform basic search by typing name of a club")
    @Issue("TUA-226")
    @Test(invocationCount = 1, dataProvider = "clubsNameSearchTestDataProvider",description = "TUA-226")
    public void checkSearchWithNameOfClubsTyping(String data) {
        boolean isPresent = new MainPage(driver)
                .inputStringInSearchField(data)
                .isClubPresent(data);
        Assert.assertTrue(isPresent);
    }

    @DataProvider
    public Object[][] checkInvalidSymbolsAndQuantityDataProvider() {
        return new Object[][]{
                {"///", "За критеріями пошуку гуртків не знайдено"},
                {"150rtyuiopasdfghjklzxcvbnm;qwertyuiop[asdfghjkl 50cvbnm,.qwertyuiopasdfghjklzxcvbnm,.qwertertyu 100йцукенuiopasdfghjklzxcvbqwertyuiop[asdfghjklzxcv", "За критеріями пошуку гуртків не знайдено"},
                {"152rtyuiopasdfghjklzxcvbnm;qwertyuiop[asdfghjkl 50cvbnm,.qwertyuiopasdfghjklzxcvbnm,.qwertertyu 100йцукенuiopasdfghjklzxcvbqwertyuiop[asdfghjklzxcv+1", "За критеріями пошуку гуртків не знайдено"}
        };
    }

    @Description("Verify search field behavior for invalid number of symbols entered")
    @Issue("TUA-428")
    @Test(dataProvider = "checkInvalidSymbolsAndQuantityDataProvider", description = "TUA-428")
    public void checkInvalidSymbolsAndQuantityTyping(String input, String expectedResult) {
        String actualResult = new MainPage(driver).inputStringInSearchField(input)
                .getTitleOfInvalidSearchPage();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Description("Verify search field behavior for invalid number of symbols pasted")
    @Issue("TUA-428")
    @Test(dataProvider = "checkInvalidSymbolsAndQuantityDataProvider",description = "TUA-428")
    public void checkInvalidSymbolsAndQuantityPaste(String input, String expectedResult) {
        String actualResult = new MainPage(driver).pasteClipBoardStringInSearchField(input)
                .getTitleOfInvalidSearchPage();
        Assert.assertEquals(actualResult, expectedResult);
    }

}
