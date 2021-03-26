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

    public String getInternalTopic(String userTopic) {
        logger.info(userTopic);

        Map<String, String> result = r.db(database).table(routesTable).get(userTopic).run(getConnection());

        logger.info("{}", result);

        if (result == null)
            return null;

        return result.get("route");
    }
}
