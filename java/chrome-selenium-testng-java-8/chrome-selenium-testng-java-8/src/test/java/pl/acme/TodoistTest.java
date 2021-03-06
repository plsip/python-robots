package pl.acme;

import org.testng.Assert;
import org.testng.annotations.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TodoistTest {
    @Test
    public void verifyPageTitle() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--single-process");
        options.addArguments("--use-gl=swiftshader");
        options.addArguments("--no-zygote");

        WebDriver browser = new ChromeDriver(options);
        browser.get(System.getProperty("inputParameters.testTargetURL", "http://mir-todoist-test-app.s3-website-us-east-1.amazonaws.com/"));

        String title = browser.getTitle();
        System.out.println(title);

        Assert.assertTrue(title.contentEquals("Inbox: Todoist"));

        System.setProperty("output", "{\"title\":\"Inbox: Todoist\"}");

        browser.close();
    }
}
