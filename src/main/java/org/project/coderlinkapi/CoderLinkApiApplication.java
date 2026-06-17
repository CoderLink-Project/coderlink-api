package org.project.coderlinkapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableJpaRepositories("org.project.coderlinkapi.repository")
@EntityScan("org.project.coderlinkapi.model.entity")
public class CoderLinkApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(CoderLinkApiApplication.class, args);
    }
}
