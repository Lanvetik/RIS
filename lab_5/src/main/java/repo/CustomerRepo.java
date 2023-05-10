package repo;

import entities.Customer;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Singleton;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;
@LocalBean
@Singleton
public class CustomerRepo {

    private EntityManagerFactory managerFactory;
    private EntityManager entityManager;
    public CustomerRepo() {
        managerFactory = Persistence.createEntityManagerFactory("customer-unit");
        entityManager = managerFactory.createEntityManager();
    }

    private void close() {
        managerFactory.close();
        entityManager.close();
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customers = entityManager.createQuery("select new Customer(a.id, a.lastName, a.stateCode, a.creditLimit)  from Customer a order by a.id", Customer.class).getResultList();
        System.out.println(customers);
        return customers;
    }

    public Customer getCustomerById(Integer id) {
        Customer customer = entityManager.find(Customer.class, id);
        return customer;
    }

    public void editCustomer(Customer newCustomer) {
        entityManager.getTransaction().begin();
        Customer customer = entityManager.find(Customer.class, newCustomer.getId());
        customer.setLastName(newCustomer.getLastName());
        customer.setLastName(newCustomer.getStateCode());
        customer.setCreditLimit(newCustomer.getCreditLimit());
        entityManager.merge(customer);
        entityManager.getTransaction().commit();
    }

    public void addCustomer(String lastName, String stateCode, double creditLimit) {
        entityManager.getTransaction().begin();
        entityManager.persist(new Customer(lastName, stateCode, creditLimit));
        entityManager.getTransaction().commit();
    }

    public void deleteCustomer(Integer id) {
        entityManager.getTransaction().begin();
        Customer customer = entityManager.find(Customer.class, id);
        if (customer != null) {
            entityManager.remove(customer);
        }
        entityManager.getTransaction().commit();
    }


}
