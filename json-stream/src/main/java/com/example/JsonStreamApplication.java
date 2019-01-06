package com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class JsonStreamApplication implements CommandLineRunner {

    GsonStreamWriter gsonStreamWriter;

    GsonStreamReader gsonStreamReader;

    public static void main(String[] args) {
        SpringApplication.run(JsonStreamApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("start");
        gsonStreamWriter = new GsonStreamWriter();

        gsonStreamReader = new GsonStreamReader();
        log.info("end");
        System.exit(-1);

    }
}

