package api;
import Model.Customer;
import Model.IRoom;
import Model.Reservation;
import service.CustomerService;
import service.ReservationService;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class HotelResource {
    public static final CustomerService customerService = new CustomerService();
    public static final ReservationService reservationService = ReservationService.getInstance();
    public static Customer getCustomer(String email){
        return customerService.getCustomer(email);
    }
    public static void createACustomer(String email, String firstName, String lastName){
        customerService.addCustomer(email, firstName, lastName);
        System.out.println("Your account has been Created!");
    }
    public static IRoom getRoom(String roomNumber){
        return reservationService.getARoom(roomNumber);
    }
    public static Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate){

        return reservationService.reserveARoom(getCustomer(customerEmail), room, checkInDate, checkOutDate);
    }
    public static List<Reservation> getCustomersReservation(String customerEmail){
        return reservationService.getCustomersReservation(customerEmail);
    }
    public static Collection<IRoom> findARoom(Date checkInDate, Date checkOutDate){
        return reservationService.findRooms(checkInDate, checkOutDate);
    }
}