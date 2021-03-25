package org.equilibrium.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rethinkdb.RethinkDB;
import com.rethinkdb.net.Connection;
import com.rethinkdb.net.Cursor;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class ConfigurationStorage {

    private static final Logger logger = LoggerFactory.getLogger(ConfigurationStorage.class);
    public static final RethinkDB r = RethinkDB.r;

    private Routes routes;

    @ConfigProperty(name = "configuration-storage.hostname")
    String hostname;

    @ConfigProperty(name = "configuration-storage.port")
    Integer port;

    @ConfigProperty(name = "configuration-storage.users-data-database")
    String database;

    @ConfigProperty(name = "configuration-storage.routes-table")
    String routesTable;

    private Connection connection;
    private Connection getConnection() {
        if (connection == null) {
            connection = r.connection().hostname(hostname).port(port).connect();
        }
        return connection;
    }

    public List<Map<String, String>> getAllInternalTopics() {
        Cursor<Map<String, String>> result = r.db(database).table(routesTable).run(getConnection());

        if (result == null)
            return new ArrayList<>();

        return result.toList();
    }

    public String getInternalTopic(String userTopic) {
        logger.info(userTopic);

        Map<String, String> result = r.db(database).table(routesTable).get(userTopic).run(getConnection());

        logger.info("{}", result);

        if (result == null)
            return null;

        return result.get("route");
    }

    public String getInternalTopicFromFile(String userTopic) {
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
