package au.com.telstra.simcardactivator.controller;

import au.com.telstra.simcardactivator.Actuator;
import au.com.telstra.simcardactivator.Entity.ActuationResponse;
import au.com.telstra.simcardactivator.Entity.SIMEntity;
import au.com.telstra.simcardactivator.Repository.SimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.Optional;

@RestController
public class SIMController {

    @Autowired
    SimRepository repository;
    @Autowired
    private Actuator actuatation;


    @PostMapping(path="/activate", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void activate(@RequestBody SIMEntity jsonpayroll)throws Exception{

        if(jsonpayroll==null){
            throw new ServerException("No data");
        }
        actuatation.actuate(jsonpayroll);
        ActuationResponse res = actuatation.actuate(jsonpayroll);
        System.out.println(res.isSuccess());
        if(res.isSuccess()==true){
            jsonpayroll.setActive(true);
        }
        repository.save(jsonpayroll);
//        System.out.println(res.toString());

    }

    @GetMapping("/search")
    public Optional<SIMEntity> search(@RequestParam("id") Long id){
        Optional<SIMEntity> result = repository.findById(id);
        System.out.println(result);
        return result;

    }
}
