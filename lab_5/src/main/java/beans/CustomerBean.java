package beans;

import entities.Customer;
import jakarta.faces.bean.ManagedBean;
import jakarta.inject.Inject;
import repo.CustomerRepo;

import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class CustomerBean {
    @Inject
    private CustomerRepo repository;
    private String id;
    private String lastName;
    private String stateCode;
    private double creditLimit;
    private Customer customer;
    private List<Customer> customerList = new ArrayList<>();
    private boolean isAdded;

    public List<Customer> getAllCustomers() {
        customerList = repository.getAllCustomers();
        return customerList;
    }

    public String addCustomer() {
        repository.addCustomer(lastName, stateCode, creditLimit);
        isAdded = true;
        return "index";
    }

    public void deleteCustomer() {
        this.customer = repository.getCustomerById(Integer.parseInt(id));
        repository.deleteCustomer(Integer.parseInt(id));
    }

    public void getCustomerById() {
        customer = repository.getCustomerById(Integer.parseInt(id));
        if (customer != null) {
            id = String.valueOf(customer.getId());
            lastName = customer.getLastName();
            creditLimit = customer.getCreditLimit();
            stateCode = String.valueOf(customer.getStateCode());
        }
    }

    public String editCustomer() {
        Customer customer1 = repository.getCustomerById(Integer.parseInt(id));
        if (customer1 != null) {
            customer = new Customer(Integer.parseInt(id), lastName, stateCode, creditLimit);
            repository.editCustomer(customer);
        }
        return "index";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean isAdded() {
        return isAdded;
    }

    public void setAdded(boolean added) {
        isAdded = added;
    }
}
