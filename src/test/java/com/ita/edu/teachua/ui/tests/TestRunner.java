package com.ita.edu.teachua.ui.tests;

import com.ita.edu.teachua.utils.Retry;
import com.ita.edu.teachua.utils.TestNgListeners;
import com.ita.edu.teachua.utils.TestValueProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.io.IOException;
import java.time.Duration;

@Listeners(TestNgListeners.class)
public class TestRunner {

    protected static TestValueProvider testValueProvider;
    protected WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(ITestContext context) throws IOException {
        for (ITestNGMethod method : context.getAllTestMethods()) {
            method.setRetryAnalyzerClass(Retry.class);
        }
        WebDriverManager.chromedriver().setup();
        testValueProvider = new TestValueProvider();
    }

    @SneakyThrows()
    @BeforeMethod
    public void beforeMethod(ITestContext context) {

        ChromeOptions options = new ChromeOptions();
        if (testValueProvider.getHeadlessMode()) {
            options.addArguments("--headless");
            options.addArguments("--window-size=1920,1080", "--no-sandbox", "'--disable-dev-shm-usage");
        }
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(testValueProvider.getBaseUrl());
        context.setAttribute("driver", driver);
    }

    @AfterMethod
    public void afterMethod() {
        if (driver != null) {
            driver.quit();
        }
    }

}