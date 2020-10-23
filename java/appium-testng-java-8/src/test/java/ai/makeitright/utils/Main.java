package ai.makeitright.utils;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Main {
    public static String workspacePath = System.getProperty("ARTIFACTS_PATH");
    public static String serviceName = "";

    @BeforeSuite
    public void tearUp() {}

    @AfterSuite
    public void afterMethod() {}
}