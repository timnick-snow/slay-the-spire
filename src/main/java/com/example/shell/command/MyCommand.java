package com.example.shell.command;

import org.springframework.context.annotation.Bean;
import org.springframework.shell.Availability;
import org.springframework.shell.AvailabilityProvider;
import org.springframework.shell.command.annotation.Command;

/**
 * @author snow
 * @since 2023/12/7
 */
@Command(command = "foo", alias = "f")
public class MyCommand {
    @Command(command = "", alias = "")
//    @Command
    public String emptySub() {
        return "empty sub";
    }

    @Command(command = "bar", alias = "b")
    public String bar() {
        return "foo bar";
    }


    @Command(command = "hello")
    public String hello() {
        return "hello";
    }

    @Bean
    public AvailabilityProvider demoAvail() {
        return () -> Availability.unavailable("nothing to say");
    }
}
