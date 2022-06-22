package com.example.demo.config;

import com.example.demo.models.Phone;
import com.example.demo.repo.PhoneRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PhoneConfig {
    @Bean
    CommandLineRunner commandLineRunner(PhoneRepository repository) {
        return args -> {
            Phone ip1 = new Phone(
                    "Iphone 13",
                    "Pink",
                    3500
            );

            Phone ip2 = new Phone(
                    "Iphone Pro Max 13",
                    "Black",
                    5500
            );

            Phone xm = new Phone(
                    "RedMi",
                    "Blue",
                    2500
            );

            repository.saveAll(List.of(ip1, ip2, xm));
        };
    }
}
