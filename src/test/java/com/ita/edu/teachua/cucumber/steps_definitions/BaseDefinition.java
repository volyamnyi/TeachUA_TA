package com.ita.edu.teachua.cucumber.steps_definitions;

import com.ita.edu.teachua.utils.TestValueProvider;

import io.cucumber.java.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.io.IOException;
import java.time.Duration;

public class BaseDefinition {
    protected static WebDriver driver;
    protected static TestValueProvider testValueProvider;

    @BeforeAll
    public static void beforeAll() throws IOException {
        testValueProvider = new TestValueProvider();
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void before(){
        ChromeOptions options = new ChromeOptions();
        if (testValueProvider.getHeadlessMode()) {
            options.addArguments("--headless");
            options.addArguments("--window-size=1920,1080", "--no-sandbox", "'--disable-dev-shm-usage");
        }
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(testValueProvider.getBaseUrl());
    }

    @After
    public void after() throws IOException {
        if (driver != null) {
            driver.quit();
        }
    }

    public static TestValueProvider getTestValueProvider() {
        return testValueProvider;
    }

    public WebDriver getDriver(){
        return driver;
    }

    @ParameterType("([^\"]*)")
    public String adminEmail(String email) {
        return email;
    }
    @ParameterType("([^\"]*)")
    public String adminPassword(String password) {
        return password;
    }
    @ParameterType("([^\"]*)")
    public String validClubName(String validClubName) {
        return validClubName;
    }
    @ParameterType("([^\"]*)")
    public String ageFrom(String ageFrom) {
        return ageFrom;
    }
    @ParameterType("([^\"]*)")
    public String ageTo(String ageTo) {
        return ageTo;
    }
    @ParameterType("([^\"]*)")
    public String validLocationName(String validLocationName) {
        return validLocationName;
    }
    @ParameterType("([^\"]*)")
    public String[] addLocationPopUpIds(String addLocationPopUpIds) {
        return addLocationPopUpIds.split(",");
    }
    @ParameterType("([^\"]*)")
    public String validAddress(String validAddress) {
        return validAddress;
    }
    @ParameterType("([^\"]*)")
    public String[] fieldPhone(String phone) {
        return phone.split(",");
    }
    @ParameterType("([^\"]*)")
    public String[] message(String message) {
        return message.split(",");
    }
    @ParameterType("([^\"]*)")
    public String email(String email) {
        return email;
    }
    @ParameterType("([^\"]*)")
    public String color(String color) {
        return color;
    }
    @ParameterType("([^\"]*)")
    public String coordinates(String coordinates) {
        return coordinates;
    }
    @ParameterType("([^\"]*)")
    public String validPhone(String validPhone) {
        return validPhone;
    }
    @ParameterType("([^\"]*)")
    public String[] addClubPopUpComponentIds(String addClubPopUpComponentIds) {
        return addClubPopUpComponentIds.split(",");
    }
    @ParameterType("([^\"]*)")
    public String validCoordinates(String validCoordinates) {
        return validCoordinates;
    }
    @ParameterType("([^\"]*)")
    public String validPhoneNumber(String validPhoneNumber) {
        return validPhoneNumber;
    }
}
