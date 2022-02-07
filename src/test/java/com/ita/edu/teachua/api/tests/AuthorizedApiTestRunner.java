package com.ita.edu.teachua.api.tests;

import com.ita.edu.teachua.api.clients.sigin.Authorization;
import com.ita.edu.teachua.utils.Retry;
import com.ita.edu.teachua.utils.TestValueProvider;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class AuthorizedApiTestRunner {
    protected static TestValueProvider testValueProvider;
    protected Authorization authorization;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(ITestContext context){
        for(ITestNGMethod method : context.getAllTestMethods()){
            method.setRetryAnalyzerClass(Retry.class);
        }
    }

    @BeforeClass
    public void beforeClass() throws IOException {
        testValueProvider = new TestValueProvider();
        authorization = new Authorization(testValueProvider.getTestTeachUaMetaEmail(), testValueProvider.getTestTeachUaMetaPassword());
    }
}
