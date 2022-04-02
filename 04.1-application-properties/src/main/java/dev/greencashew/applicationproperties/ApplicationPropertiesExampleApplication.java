package dev.greencashew.applicationproperties;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationPropertiesExampleApplication implements CommandLineRunner {

    private final Metadata metadata;

    public ApplicationPropertiesExampleApplication(Metadata metadata) {
        this.metadata = metadata;
    }

    public static void main(String[] args) {
        SpringApplication.run(ApplicationPropertiesExampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        metadata.printMetadata();
    }
}
