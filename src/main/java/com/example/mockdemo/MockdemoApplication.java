package com.example.mockdemo;

import com.example.mockdemo.api.MockApiTester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = {"com.penske.foundation.services.mock.httpserver", "com.example.mockdemo"})
public class MockdemoApplication implements CommandLineRunner {
    
    @Autowired
    private MockApiTester tester;
    
    public static void main(String[] args) {
        SpringApplication.run(MockdemoApplication.class, args);
        
        
    }
    
    @Override
    public void run(String... args) throws Exception {
        
        for (int pos = 0; pos < 5; pos++) {
            tester.testMock();
            //Thread.sleep(1000);
        }
        
        
    }
    
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
