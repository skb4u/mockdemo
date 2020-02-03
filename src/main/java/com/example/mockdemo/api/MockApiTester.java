package com.example.mockdemo.api;

/*
 *
 *
 *   @author Saravana kumar Alavandar
 *
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class MockApiTester {
     
     @Autowired
     RestTemplate restTemplate;
     
     
     public void testMock() {
         try {
           //  Object response = restTemplate.postForEntity(getURI(), null, Object.class);
             Object response = restTemplate.getForObject(getURI(), Object.class);
             System.out.println("Response here" + response.toString());
         } catch(Exception ex) {
         
         }
         
     }
     
     
     public URI getURI() {
         return UriComponentsBuilder.fromUriString("http://localhost:8089/test").build().toUri();
     }
}
