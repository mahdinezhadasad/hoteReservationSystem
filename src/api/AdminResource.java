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
    public static final CustomerService customerService = new CustomerService();
    public static final ReservationService reservationService = ReservationService.getInstance();
    public Customer getCustomer(String email) {
        return customerService.getCustomer(email);
    }
    public static void createRooms(String roomNumber, double price, RoomType roomType) {
        reservationService.addRoom(roomNumber, price,roomType);
        System.out.println("Your Room has been Created!");
    }
    public static Collection<IRoom> getAllRooms() {
        return reservationService.allRooms();
    }
    public static Collection<Customer> getAllCustomer() {
        return customerService.getAllCustomers();
    }
    public static Collection<Reservation> getAllReservations(){
        return reservationService.getAllReservations();
    }
}
