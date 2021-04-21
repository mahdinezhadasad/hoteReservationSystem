package api;
import Model.*;
import service.*;

import java.util.Collection;
import java.util.List;

import Model.Customer;
import Model.*;
import service.CustomerService;
import service.ReservationService;
import java.util.Collection;
import java.util.List;
public class AdminResource {

    public static final AdminResource adminResource = new AdminResource ( );
    private CustomerService customerService = CustomerService.getInstance();
    private ReservationService reservationService = ReservationService.getInstance();
    public Customer getCustomer(String email){
        return CustomerService.getInstance().getCustomer(email);
    }



    public  void createRooms(String roomNumber, double price, RoomType roomType) {
        reservationService.addRoom(roomNumber, price, roomType);
        System.out.println("Your Room has been Created!");
    }
    public Collection<IRoom> getAllRoom(){

       return reservationService.allRooms();
 }

 public Collection<Customer> getAllCustomer(){
        return customerService.getAllCustomers();

 }

 public void displayAllReservations(){


        reservationService.printAllReseverations();


 }

 public void displayAllRoom(){

        reservationService.printAllRooms();

 }


}
