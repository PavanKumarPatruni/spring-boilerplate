package com.example.demo.constants;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class AppVersion {

    public static String version;

    public static boolean updateMandatory;

    @Autowired
    public AppVersion(@Value("${app.version.current}") String version, @Value("${app.version.update-mandatory}") boolean mandatory) {
        AppVersion.version = version;
        AppVersion.updateMandatory = mandatory;
    }

}
