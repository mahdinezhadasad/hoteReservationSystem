package service;


import Model.Customer;
import Model.IRoom;
import java.util.*;
public class CustomerService {
    private static CustomerService customerService = null;
    public Collection<Customer> customers = new HashSet<>();


    private CustomerService(){


    }
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
        Customer newCustomer = new Customer( firstName, lastName,email);
        customers.add(newCustomer);
    }
    //method to retrieve customers from Customer Collection
   // public Customer getCustomer(String customerEmail) {
       // Optional<Customer> customer = customers.stream().filter(c -> customerEmail.equals(c.getMail())).findFirst();
       // return customer.orElse(null);

        
    //}

    public Customer getCustomer ( String customerEmail ) {
        try {
            List<Customer> list = new ArrayList<
                    >(customers);
            for ( int i = 0; i < list.size(); i++ ) {
                if ( list.get(i).getMail() == customerEmail ) {
                    return list.get( i );
                }
            }
        } catch ( ArrayIndexOutOfBoundsException exception ) {
            System.out.println ( "This email does not match any customer in our database, please try again" );
        }
        return null;
    }
}
