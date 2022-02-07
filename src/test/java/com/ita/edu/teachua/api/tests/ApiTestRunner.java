package com.ita.edu.teachua.api.tests;

import com.ita.edu.teachua.utils.Retry;
import com.ita.edu.teachua.utils.TestValueProvider;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class ApiTestRunner {
    protected static TestValueProvider testValueProvider;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(ITestContext context){
        for(ITestNGMethod method : context.getAllTestMethods()){
            method.setRetryAnalyzerClass(Retry.class);
        }
    }

    @BeforeClass
    public void beforeClass() throws IOException {
        testValueProvider = new TestValueProvider();
    }
}
