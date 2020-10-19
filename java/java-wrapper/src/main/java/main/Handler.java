package main;

import java.net.URL;

public class Handler {
    public static void main(String[] args) throws Exception {
        runClientsPackage();
    }

    private static void runClientsPackage() throws Exception {
        ClassLoader classLoader = Handler.class.getClassLoader();
        String clientPackageName = "clientPackage.jar";
        System.out.println("Client package name: " + clientPackageName + "\n");

        System.out.println("Loading client package" + "\n");
        URL clientsPackageURL = classLoader.getResource(clientPackageName);
        System.out.println("Client package URL: " + clientsPackageURL + "\n");
        JarClassLoader jcl = new JarClassLoader(clientsPackageURL);
        String clientPackageEntryPoint = jcl.getMainClassName();

        System.out.println("Running client's package" + "\n");
        jcl.invokeClass(clientPackageEntryPoint, new String[]{});
        System.out.println("Run client's package" + "\n");
    }
}
