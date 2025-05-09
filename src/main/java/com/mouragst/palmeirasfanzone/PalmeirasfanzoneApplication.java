package com.mouragst.palmeirasfanzone;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class PalmeirasfanzoneApplication {

	public static void main(String[] args) {
        SpringApplication app = new SpringApplication(PalmeirasfanzoneApplication.class);

        app.addListeners((ApplicationListener<ApplicationEnvironmentPreparedEvent>) event -> {
            ConfigurableEnvironment environment = event.getEnvironment();
            Dotenv dotenv = Dotenv.configure().load();

            dotenv.entries().forEach(entry -> {
                environment.getSystemProperties().put(entry.getKey(), entry.getValue());
            });
        });

        app.run(args);
    }

}
