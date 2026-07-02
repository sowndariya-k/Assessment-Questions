package com.Test.Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.*;
import org.apache.commons.io.FileUtils;

public class screenshotUtil {

    public static void takeScreenshot(WebDriver driver, String testName) {

        try {
            String time = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            String path = "src/test/resources/screenshots/";

            File dir = new File(path);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File(path + testName + "_" + time + ".png");

            FileUtils.copyFile(src, dest);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}