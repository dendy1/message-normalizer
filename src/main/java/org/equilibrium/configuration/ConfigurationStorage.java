package org.equilibrium.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rethinkdb.RethinkDB;
import com.rethinkdb.net.Connection;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.equilibrium.data.NormalizedTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;

@ApplicationScoped
public class ConfigurationStorage {

    private static final Logger logger = LoggerFactory.getLogger(ConfigurationStorage.class);
    public static final RethinkDB r = RethinkDB.r;

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

    public NormalizedTopic getInternalTopic(String userTopic) {
        logger.info(userTopic);

        HashMap<String, String> result = r.db(database).table(routesTable).get(userTopic).run(getConnection());

        logger.info("{}", result);

        if (result == null)
            return null;

        ObjectMapper om = new  ObjectMapper();
        try {
            NormalizedTopic topic = om.convertValue(result, NormalizedTopic.class);
            return topic;
        } catch (Exception ex) {
            return null;
        }

    }
}
