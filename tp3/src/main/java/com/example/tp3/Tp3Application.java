package com.example.tp3;

import com.example.tp3.service.ClientService;
import com.example.tp3.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Tp3Application  implements CommandLineRunner {

    @Autowired
    private EmployeService es;

    @Autowired
    ClientService cs;

    public static void main(String[] args) {
        SpringApplication.run(Tp3Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
