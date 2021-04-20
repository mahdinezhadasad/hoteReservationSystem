package service;


import Model.Customer;
import Model.IRoom;
import java.util.*;
public class CustomerService {
    private static CustomerService customerService;
    public Collection<Customer> customers = new HashSet<>();

    //static reference for CustomerService class
    public static CustomerService getInstance() {
        if (customerService == null) {
            customerService = new CustomerService();
        }
        return customerService;
    }

    public Collection<Customer> getAllCustomers() {
        if (!customers.isEmpty()) {
            Iterator<Customer> customerIterator = customers.iterator();
            while (customerIterator.hasNext()) {
                System.out.println(customerIterator.next());
            }

        }
        return customers;
    };

    //method to add Customers
    public void addCustomer(String email, String firstName, String lastName){
        Customer newCustomer = new Customer(email, firstName, lastName);
        customers.add(newCustomer);
    }
    //method to retrieve customers from Customer Collection
    public Customer getCustomer(String customerEmail) {
        Optional<Customer> customer = customers.stream().filter(c -> customerEmail.equals(c.getMail())).findFirst();
        return customer.orElse(null);
    }
}
