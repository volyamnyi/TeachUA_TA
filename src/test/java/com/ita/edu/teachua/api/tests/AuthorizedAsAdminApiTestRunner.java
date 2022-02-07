package com.ita.edu.teachua.api.tests;

import com.ita.edu.teachua.api.clients.sigin.Authorization;
import com.ita.edu.teachua.utils.Retry;
import com.ita.edu.teachua.utils.TestValueProvider;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class AuthorizedAsAdminApiTestRunner {
    protected static TestValueProvider testValueProvider;
    protected Authorization authorization;
    protected WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(ITestContext context){
        for(ITestNGMethod method : context.getAllTestMethods()){
            method.setRetryAnalyzerClass(Retry.class);
        }
    }

    @BeforeClass
    public void beforeClass() throws IOException {
        testValueProvider = new TestValueProvider();
        authorization = new Authorization(testValueProvider.getAdminEmail(), testValueProvider.getAdminPassword());
//        WebDriverManager.chromedriver().setup();
    }

//    @BeforeMethod
//    public void beforeMethod(ITestContext context) {
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get(testValueProvider.getBaseUrl());
//        context.setAttribute("driver", driver);
//    }
//
//    @AfterMethod
//    public void afterMethod() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
