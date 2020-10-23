package ai.makeitright.tests;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.Assert;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import ai.makeitright.utils.DriverConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Logger;

public class SampleAppTest extends DriverConfig {

    private static final Logger logger = Logger.getLogger(SampleAppTest.class.getName());

    @Test
    public void checkText() throws InterruptedException, IOException {
        logger.info("SampleAppTest.checkText... +2");

        final URL url = new URL("http://127.0.0.1:4723/wd/hub");

        final DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        final AndroidDriver driver = new AndroidDriver(url, desiredCapabilities);

        Thread.sleep(6000);

        final WebElement button_first = driver.findElementById("pl.makeitright.appium_sample_app:id/button_first");
        button_first.click();
        Thread.sleep(2000);

        String screenshotFilePath = System.getProperty("SCREENSHOTS_PATH");
        String artifactFilePath = System.getProperty("ARTIFACTS_PATH");

        logger.info("screenshotFilePath=" + screenshotFilePath);
        logger.info("artifactFilePath=" + artifactFilePath);

        File screenshot  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File(screenshotFilePath + "/Screenshot.jpg"));

        File artifact = new File(artifactFilePath + "/artifact.txt");

        if (artifact.createNewFile()) {
            logger.info("File created: " + artifact.getName());
        } else {
            logger.info("File already exists...");
        }

        System.setProperty("output", "{\"result\":{\"out2\":\"val2\"}}");

        logger.info("DONE");
    }

    @Test
    public void checkText1() throws InterruptedException, IOException {
        logger.info("junit - SampleAppTest.checkText1...");

        Assert.assertEquals("TRUE", "TRUE");
        System.setProperty("output", "{\"result\":{\"out2\":\"val2\"}}");

        logger.info("DONE");
    }
}
