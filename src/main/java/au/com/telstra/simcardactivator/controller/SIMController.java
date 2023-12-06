package au.com.telstra.simcardactivator.controller;

import au.com.telstra.simcardactivator.Actuator;
import au.com.telstra.simcardactivator.Entity.ActuationResponse;
import au.com.telstra.simcardactivator.Entity.SIMEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.ServerException;

@RestController
public class SIMController {

//    @Autowired
//    SimRepository repository;
    @Autowired
    private Actuator actuatation;


    @PostMapping(path="/activate", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void activate(@RequestBody SIMEntity jsonpayroll)throws Exception{

        if(jsonpayroll==null){
            throw new ServerException("No data");
        }
        ActuationResponse res = actuatation.actuate(jsonpayroll);
        System.out.println(res.toString());

    }
}
