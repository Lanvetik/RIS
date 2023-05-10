package entities;
import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="last_name")
    private String lastName;
    @Column(name = "state_code")
    private String stateCode;
    @Column(name="credit_limit")
    private double creditLimit;

    public Customer() {
    }

    public Customer(int id, String lastName, String stateCode, double creditLimit) {
        this.id = id;
        this.lastName = lastName;
        this.stateCode = stateCode;
        this.creditLimit = creditLimit;
    }

    public Customer(String lastName, String stateCode, double creditLimit) {
        this.lastName = lastName;
        this.stateCode = stateCode;
        this.creditLimit = creditLimit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }
}
