package com.base;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Test.Utilities.screenshotUtil;

public class TestListener implements ITestListener {

    public void onTestSuccess(ITestResult result) {
        System.out.println("PASS: " + result.getName());
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("FAIL: " + result.getName());

        Object testClass = result.getInstance();
        BaseTest base = (BaseTest) testClass;

        screenshotUtil.takeScreenshot(base.getDriver(), result.getName());
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("SKIP: " + result.getName());
    }
}