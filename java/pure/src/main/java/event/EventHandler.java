package event;

public class EventHandler {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, world! Once again!");
        String secrets = System.getProperty("secretParameters");
        System.setProperty("output", String.format("{\"secrets\": %s}", secrets));
    }
}
