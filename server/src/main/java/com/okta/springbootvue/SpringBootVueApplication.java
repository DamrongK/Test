package com.okta.springbootvue;

import com.okta.springbootvue.entity.test.*;
import com.okta.springbootvue.repository.test.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import java.util.stream.Stream;
import java.time.LocalDateTime;

@SpringBootApplication  
public class SpringBootVueApplication {  
  
    public static void main(String[] args) {  
      SpringApplication.run(SpringBootVueApplication.class, args);  
    }  

    @Bean  
    ApplicationRunner init(StudentRepository studentRepository) {  
        return args -> {  
            
        };  
    }  
 
}