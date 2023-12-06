package au.com.telstra.simcardactivator;

import au.com.telstra.simcardactivator.Entity.ActuationResponse;
import au.com.telstra.simcardactivator.Entity.SIMEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Component
public class Actuator {

    private final String apiEndpoint; RestTemplate restTemplate;


    public Actuator (RestTemplateBuilder builder){
        this.restTemplate = builder.build();
        this.apiEndpoint = "http://localhost:8444/actuate";    }



    public ActuationResponse actuate(SIMEntity sim){
        ActuationResponse response =  restTemplate.postForObject(apiEndpoint, sim, ActuationResponse.class);
        return response;
    }

}
