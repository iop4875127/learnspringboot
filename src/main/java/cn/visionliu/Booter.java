package cn.visionliu;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class Booter {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Booter.class, args);
    }
}