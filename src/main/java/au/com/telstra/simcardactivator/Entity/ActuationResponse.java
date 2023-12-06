package au.com.telstra.simcardactivator.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ActuationResponse {

    private boolean success;
    protected ActuationResponse(){}
    public ActuationResponse(boolean success) {
        this.success = success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
    public boolean isSuccess() {
        return success;
    }

    @Override
    public String toString() {
        return "ActuationResponse{" +
                "success=" + success +
                '}';
    }


}
