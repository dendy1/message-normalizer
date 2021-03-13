package org.equilibrium.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class ConfigurationStorage {

    private static Routes routes;

    public static String getInternalTopic(String userTopic) {
        if (routes == null) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                routes = objectMapper.readValue(getFileFromResourceAsStream("routes.json"), Routes.class);
            } catch (IOException e) {
                System.err.println("Error parsing routes configurations");
                return null;
            }
        }

        return routes.getRoute(userTopic);
    }

    // get a file from the resources folder
    // works everywhere, IDEA, unit test and JAR file.
    private static InputStream getFileFromResourceAsStream(String fileName) {

        // The class loader that loaded the class
        ClassLoader classLoader = ConfigurationStorage.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }

    }
}
