package wrapper;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.Map;
import java.util.Objects;

public class Wrapper implements RequestHandler<Map<String, String>, String> {
    @Override
    public String handleRequest(Map<String, String> event, Context context) {
        LambdaLogger logger = context.getLogger();
        String response = new String("200 OK");
        // log execution details
        // process event
        ClassLoader classLoader = getClass().getClassLoader();
        File clientPackageFile = new File(Objects.requireNonNull(classLoader.getResource("clientPackage.jar")).getFile());
        logger.log("EVENT TYPE: " + event.getClass().toString());
        logger.log("Loading client package");
        JarClassLoader jcl = null;
        try {
            jcl = new JarClassLoader(clientPackageFile.toURI().toURL());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        String clientPackageEntryPoint = null;
        try {
            clientPackageEntryPoint = jcl.getMainClassName();
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.log("Running client's package");
        try {
            jcl.invokeClass(clientPackageEntryPoint, new String[]{});
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        logger.log("Run client's package");
        return response;
    }
}
