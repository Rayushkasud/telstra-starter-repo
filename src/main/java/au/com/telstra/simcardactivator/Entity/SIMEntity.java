package au.com.telstra.simcardactivator.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jdk.jfr.Enabled;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class SIMEntity {

    @Id
    @GeneratedValue()
    private Long id;


    @Column(nullable = false)
    private String iccid;
    @Column(nullable = false)
    private String customerEmail;

    @Column(nullable = false)
    private boolean active;
    protected SIMEntity(){}

    public SIMEntity(String iccid, String customerEmail, boolean active) {
        this.iccid = iccid;
        this.customerEmail=customerEmail;
        this.active = active;
    }
    public Long getId() {
        return id;
    }

    public String getIccid() {
        return iccid;
    }
    public void setIccid(String iccid) {
        this.iccid = iccid;
    }


    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "SIMEntity{" +
                "iccid='" + iccid + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                '}';
    }
}
