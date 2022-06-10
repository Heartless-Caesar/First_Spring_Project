package com.caesar.FirstSpringboot.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint(id = "features")
public class FeatureEndPoint {

    private final Map<String, Feature> FeaturesMap = new ConcurrentHashMap<>();

    public FeatureEndPoint(){
        FeaturesMap.put("Department", new Feature(true));
        FeaturesMap.put("User", new Feature(false));
        FeaturesMap.put("Authentication", new Feature(false));
    }

    @ReadOperation
    public Map<String, Feature> features() {
        return FeaturesMap;
    }

    @ReadOperation
    public Feature feature(@Selector String obj){
        return FeaturesMap.get(obj);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Feature {
        private boolean isEnabled;
    }
}
