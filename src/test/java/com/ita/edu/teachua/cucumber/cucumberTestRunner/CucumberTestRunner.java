package com.ita.edu.teachua.cucumber.cucumberTestRunner;

import com.ita.edu.teachua.utils.Retry;
import io.cucumber.testng.*;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.*;


@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.ita.edu.teachua.cucumber.steps_definitions"}

)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(ITestContext context){
        for(ITestNGMethod method : context.getAllTestMethods()){
            method.setRetryAnalyzerClass(Retry.class);
        }
    }

    @BeforeClass(alwaysRun=true)
    public void setUpClass(){
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }
    @Test(description = "Example of BDD suite", dataProvider = "scenarios")
    public void scenario(PickleWrapper pickle, FeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runScenario(pickle.getPickle());
    }

    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        testNGCucumberRunner.finish();
    }
}
