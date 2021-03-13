package org.equilibrium.configuration;

import java.util.Map;

public class Routes {

    private Map<String, String> routes;

    public String getRoute(String key) {
        return routes.get(key);
    }

    public Map<String, String> getRoutes() {
        return routes;
    }

    public void setRoutes(Map<String, String> routes) {
        this.routes = routes;
    }
}
