package com.example.demo.utils;

import com.example.demo.constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class EnvUtils {

    @Autowired
    Environment environment;

    public boolean isProd() {
        String activeProfile = null;
        String[] profiles = environment.getActiveProfiles();
        if (profiles.length > 0) {
            activeProfile = profiles[0];
        }

        return Objects.equals(activeProfile, Constants.ENV_PROD);
    }

}
