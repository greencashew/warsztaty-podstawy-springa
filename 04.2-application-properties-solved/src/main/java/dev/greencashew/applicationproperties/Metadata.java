package dev.greencashew.applicationproperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Component
record Metadata(String developerSentence,
                String applicationName,
                List<String> authors,
                String unknownSystemProperty,
                String javaHome,
                String activeProfiles) {

    private final static Logger LOGGER = Logger.getLogger(Metadata.class.getName());

    Metadata(
            @Value("Tygodniem programowania można zaoszczędzić 2 godziny projektowania :)") String developerSentence,
            @Value("${spring.application.name}") String applicationName,
            @Value("${application.authors}") List<String> authors,
            @Value("${application.unknown.property:Unknown property}") String unknownSystemProperty,
            @Value("${JAVA_HOME}") String javaHome,
            @Value("${spring.profiles.active:No Active Profiles!}") String activeProfiles
    ) {
        this.developerSentence = developerSentence;
        this.applicationName = applicationName;
        this.authors = authors;
        this.unknownSystemProperty = unknownSystemProperty;
        this.javaHome = javaHome;
        this.activeProfiles = activeProfiles;
    }

    void printMetadata() {
        LOGGER.info("------------ METADATA -------------");
        LOGGER.info("DEVELOPER SENTENCE: " + developerSentence);
        LOGGER.info("APPLICATION NAME: " + applicationName);
        LOGGER.info("AUTHORS: " + String.join(" <=> ", authors));
        LOGGER.info("UNKNOWN PROPERTY: " + unknownSystemProperty);
        LOGGER.info("JAVA_HOME: " + javaHome);
        LOGGER.info("ACTIVE PROFILES: " + activeProfiles);
        LOGGER.info("---------- END METADATA -----------");
    }
}
