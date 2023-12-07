package stepDefinitions;

import au.com.telstra.simcardactivator.Entity.ActuationResponse;
import au.com.telstra.simcardactivator.Entity.SIMEntity;
import au.com.telstra.simcardactivator.SimCardActivator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import netscape.javascript.JSObject;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = SimCardActivator.class, loader = SpringBootContextLoader.class)

public class SimCardActivatorStepDefinitions {
    @Autowired
    private TestRestTemplate restTemplate;

    SIMEntity simCard;

    @Given("a functional sim card")
    public void functionalSimCard(){
        simCard = new SIMEntity("1255789453849037777", "ray@gmail.com", false);
    }

    @Given("a non functional sim card")
    public void nonFunctionalSimCard(){
        simCard = new SIMEntity("8944500102198304826", "abc@gmail.com", false);
    }

    @When("Functional sim card is active")
    public void postFunctionalSimData()  {
        this.restTemplate.postForObject("http://localhost:8444/actuator", simCard, ActuationResponse.class);
    }

    @Then("the sim card is activated.")
    public void checkActive(){
        ActuationResponse response = restTemplate.getForObject("http://localhost:8083/search?id={id}", ActuationResponse.class,1);
        assertEquals(response.isSuccess(), true);
    }

    @Then("Then the sim card is not activated.")
    public void checkNotActive(){
        ActuationResponse response = restTemplate.getForObject("http://localhost:8083/search?id=2",  ActuationResponse.class);
        assertEquals(response.isSuccess(), false);
    }

}