package com.jukkanikki;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDateTime;

@ApplicationScoped
public class Greeter {
    public String greet() {
        return "Howdy at " + LocalDateTime.now();
    }
}
