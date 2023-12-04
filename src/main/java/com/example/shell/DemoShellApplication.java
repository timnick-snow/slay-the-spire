package com.example.shell;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.shell.command.annotation.CommandScan;

@SpringBootApplication
@CommandScan
public class DemoShellApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DemoShellApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

}
