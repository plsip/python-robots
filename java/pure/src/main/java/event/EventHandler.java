package event;

import java.util.Properties;

public class EventHandler {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, world! Once again!");
        loadProperties();
        String secrets = System.getProperty("secret.parameters");
        System.out.println(secrets);
        System.setProperty("output", String.format("{\"secrets\": %s}", secrets));
    }

    private static void loadProperties() throws Exception {
        Properties properties = new Properties();
        properties.load(EventHandler.class.getResourceAsStream("/myProperties.properties"));
        System.setProperty("secret.parameters", properties.get("secret.parameters").toString());
    }
}
