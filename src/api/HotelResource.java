package api;

import Model.*;
import service.*;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;

public class HotelResource {
    private static HotelResource hotelResource;
    public static CustomerService customerService = CustomerService.getInstance();
    public static ReservationService reservationService = ReservationService.getInstance();

    private HotelResource(){
    }
    public Customer getCustomer(String email){
        return customerService.getCustomer(email);

    }
    public void createACustomer(String email, String firstName,String lastName){

        customerService.addCustomer(email,firstName,lastName);

    }


    public IRoom getRoom(String roomNumber){

            return reservationService.getARoom(roomNumber);
    }


    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate){




        Customer customer = customerService.getInstance().getCustomer(customerEmail);


        if(customer == null){


            return null;

        }

        return reservationService.reservation(customer,room,checkInDate,checkOutDate);



    }


    public Collection<Reservation>  getCustomerReservation(String customerEmail){


        Customer customer = CustomerService.getInstance().getCustomer(customerEmail);



        return reservationService.getCustomerReservation(customer);

    }

    public Collection<IRoom> finaARoom(Date checkIn,Date checkOut){

        return reservationService.findRooms(checkIn,checkOut);

    }


}
