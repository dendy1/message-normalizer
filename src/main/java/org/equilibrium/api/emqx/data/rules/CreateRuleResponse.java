package org.equilibrium.api.emqx.data.rules;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class CreateRuleResponse {

    private Integer code;
    private RuleData data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public RuleData getData() {
        return data;
    }

    public void setData(RuleData data) {
        this.data = data;
    }

    public static class RuleData {

        private String id;

        @JsonProperty("rawsql")
        private String rawSQL;

        @JsonProperty("for")
        private List<String> topicList;

        private Boolean enabled;

        private String description;

        private List<Action> actions;

        private List<RuleMetric> metrics;

        @JsonProperty("on_action_failed")
        private String onActionFailed;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getRawSQL() {
            return rawSQL;
        }

        public void setRawSQL(String rawSQL) {
            this.rawSQL = rawSQL;
        }

        public List<String> getTopicList() {
            return topicList;
        }

        public void setTopicList(List<String> topicList) {
            this.topicList = topicList;
        }

        public Boolean getEnabled() {
            return enabled;
        }

        public void setEnabled(Boolean enabled) {
            this.enabled = enabled;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<Action> getActions() {
            return actions;
        }

        public void setActions(List<Action> actions) {
            this.actions = actions;
        }

        public List<RuleMetric> getMetrics() {
            return metrics;
        }

        public void setMetrics(List<RuleMetric> metrics) {
            this.metrics = metrics;
        }

        public String getOnActionFailed() {
            return onActionFailed;
        }

        public void setOnActionFailed(String onActionFailed) {
            this.onActionFailed = onActionFailed;
        }

        public static class Action {
            private String id;
            private Map<String, String> params;
            private List<ActionMetric> metrics;
            private List<Action> fallbacks;
            private String name;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public Map<String, String> getParams() {
                return params;
            }

            public void setParams(Map<String, String> params) {
                this.params = params;
            }

            public List<ActionMetric> getMetrics() {
                return metrics;
            }

            public void setMetrics(List<ActionMetric> metrics) {
                this.metrics = metrics;
            }

            public List<Action> getFallbacks() {
                return fallbacks;
            }

            public void setFallbacks(List<Action> fallbacks) {
                this.fallbacks = fallbacks;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public static class ActionMetric {
                private Integer success;
                private Integer failed;
                private String node;

                public Integer getSuccess() {
                    return success;
                }

                public void setSuccess(Integer success) {
                    this.success = success;
                }

                public Integer getFailed() {
                    return failed;
                }

                public void setFailed(Integer failed) {
                    this.failed = failed;
                }

                public String getNode() {
                    return node;
                }

                public void setNode(String node) {
                    this.node = node;
                }
            }
        }

        public static class RuleMetric {
            private String node;

            @JsonProperty("speed_max")
            private Integer speedMax;

            @JsonProperty("speed_last5m")
            private Float speedLast5m;

            private Float speed;

            private Integer matched;

            public String getNode() {
                return node;
            }

            public void setNode(String node) {
                this.node = node;
            }

            public Integer getSpeedMax() {
                return speedMax;
            }

            public void setSpeedMax(Integer speedMax) {
                this.speedMax = speedMax;
            }

            public Float getSpeedLast5m() {
                return speedLast5m;
            }

            public void setSpeedLast5m(Float speedLast5m) {
                this.speedLast5m = speedLast5m;
            }

            public Float getSpeed() {
                return speed;
            }

            public void setSpeed(Float speed) {
                this.speed = speed;
            }

            public Integer getMatched() {
                return matched;
            }

            public void setMatched(Integer matched) {
                this.matched = matched;
            }
        }
    }

}
