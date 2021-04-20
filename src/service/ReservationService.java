package service;
import Model.Customer;
import Model.IRoom;
import Model.*;

import java.util.*;

public class ReservationService {

    private static ReservationService ReservationService = null;
    Collection<Reservation> reservations = new HashSet<>();
    //List<IRoom> roomes = new ArrayList<IRoom>();
    public Collection<IRoom> rooms = new HashSet<>();

    private ReservationService() {
    }
    //static reference for Reservation class
    public static ReservationService getInstance(){
        if (ReservationService == null){
            ReservationService = new ReservationService();
        }
        return ReservationService;
    }

    public void addRoom(IRoom room) {


        // rooms.add(room);

        rooms.add(room);

    }

    public IRoom getARoom(String roomId) {
        //for(IRoom room : rooms){

        //  System.out.println(room);
        // }
        // return (IRoom) rooms;
        for (IRoom room : rooms) {
            System.out.println(room);
        }
        return (IRoom) rooms;
    }

    public Reservation reservation(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Reservation reservedRoom = new Reservation(customer, room, checkInDate, checkOutDate);
        reservations.add(reservedRoom);
        return reservedRoom;
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        for (IRoom room : rooms) {
            if (checkInDate.after(checkInDate) && checkInDate.before(checkOutDate)) {
                Iterator<IRoom> iRoomIterator = rooms.iterator();
                while (iRoomIterator.hasNext()) {
                    System.out.println(iRoomIterator.next());
                }
            }
        }
        return rooms;

    }
    public Collection<Reservation> getCustomerReservation(Customer customer) {

        CustomerService.getInstance().getCustomer(customer.getMail());

        return reservations;

    }

    public void printAllReservation() {

        for(Reservation reservation: reservations){

            System.out.println(reservation);
        }

    }


}