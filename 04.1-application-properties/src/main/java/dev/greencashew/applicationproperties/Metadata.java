package dev.greencashew.applicationproperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
record Metadata(String applicationName) {

    Metadata(
            @Value("${spring.application.name}") String applicationName
    ) {
        this.applicationName = applicationName;
    }

    void printMetadata() {
        System.out.println("------------ METADATA -------------");
        System.out.println("APPLICATION NAME: " + applicationName);
        System.out.println("---------- END METADATA -----------");
    }
}

