package br.com.fiap.springpjmotos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringPjMotosApplication {

    public static void main(String[] args) {
        SpringApplication.run( SpringPjMotosApplication.class, args );
    }

    @GetMapping(value = "/")
    public String index() {
        return "Hello World!";
    }

}
