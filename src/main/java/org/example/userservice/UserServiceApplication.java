package org.example.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@SpringBootApplication
public class UserServiceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(UserServiceApplication.class, args);
        Environment env = context.getEnvironment();
        System.out.println("Активный профиль: " + Arrays.toString(env.getActiveProfiles()));
        System.out.println("Порт сервера: " + env.getProperty("server.port"));
    }

}
