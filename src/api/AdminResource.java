package api;
import Model.*;
import service.*;

import java.util.Collection;
import java.util.List;

public class AdminResource {

    public static final AdminResource adminResource = new AdminResource ( );
    private CustomerService customerService = CustomerService.getInstance();
    private ReservationService reservationService = ReservationService.getInstance();
    public Customer getCustomer(String email){
        return CustomerService.getInstance().getCustomer(email);
    }

    public void addRoom(List<IRoom> rooms){
        for(IRoom room : rooms){

            reservationService.addRoom(room);

        }

    }
    public Collection<IRoom> getAllRoom(){

       return reservationService.rooms;
 }

 public Collection<Customer> getAllCustomer(){
        return customerService.getAllCustomers();

 }

 public void displayAllReservations(){


        reservationService.printAllReservation();


 }


}
