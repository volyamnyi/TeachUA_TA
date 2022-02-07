package com.ita.edu.teachua.utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestNgListeners implements ITestListener {

    private final Logger log = LoggerFactory.getLogger("Listener");

    @Override
    public void onTestFailure(ITestResult result) {
        log.warn("Test FAILED: {}", result.getName());
        long tid = Thread.currentThread().getId();
        attachLogFile(tid);
        if (result.getInstance().getClass().getName().toLowerCase().contains("api")) {
            //If this is an API test
            attachRequestLogFile(result.getName());
        }
        ITestContext context = result.getTestContext();
        WebDriver driver = (WebDriver) context.getAttribute("driver");
        if (driver != null) {
            //If this is a UI test
            attachScreenshot(driver);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.info("Test SKIPPED: {}", result.getName());
        //attachLogFile(result.getInstance().getClass().getSimpleName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    @Override
    public void onTestStart(ITestResult result) {
        log.info("{}.{} test case started",
                result.getInstance().getClass().getSimpleName(), result.getName());
        System.out.println(result.getInstance().getClass().getName().toLowerCase());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("Test PASSED: {}", result.getName());
    }

    //-- Attachments -------------------------------------------------------------------------------

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] attachScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Logs for thread {tid}", type = "text/plain", fileExtension = ".log")
    public byte[] attachLogFile(long tid) {
        try {
            Path path = Paths.get(System.getProperty("user.dir") + "\\target\\" +
                    String.format("thread_output_%04d%s", tid, GroupedLoggingAppender.ext));
            return Files.readAllBytes(path);
        } catch (IOException ignored) {
            log.warn("Logs for thread " + tid + " are unavailable");
        }
        return null;
    }

    @Attachment(value = "Request logs for {testName}", type = "text/plain", fileExtension = ".log")
    public byte[] attachRequestLogFile(String testName) {
        try {
            Path path = Paths.get(System.getProperty("user.dir") + "\\target\\"
                    + testName + "_requests.log");
            return Files.readAllBytes(path);
        } catch (IOException ignored) {
            log.warn("Request logs for " + testName + " are unavailable");
        }
        return null;
    }

}

