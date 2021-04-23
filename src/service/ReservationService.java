package service;
import Model.IRoom;
import Model.*;

import Model.*;
import java.util.*;
public class ReservationService {
    private static ReservationService reservationService = null;
    Collection<IRoom> rooms = new HashSet<>();
    Collection<Reservation> reservations = new HashSet<>();
    private ReservationService() {
    }
    public static ReservationService getInstance() {
        if (null == reservationService) {
            reservationService = new ReservationService();
        }
        return reservationService;
    }

    public void addRoom(String roomNumber, double price, RoomType roomType) {
        Room room = new Room(roomNumber, price, roomType);
        rooms.add(room);
    }
    public IRoom getARoom(String roomNumber) {
        for (IRoom room : rooms) {
            if (roomNumber.equals(room.getRoomNumber())) {
                return room;
            }
        }
        return null;
    }
    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        reservations.add(reservation);
        return reservation;
    }
    public List<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        boolean found = false;
        List<IRoom> findAvailableRooms = new ArrayList<>();
        if (reservations.size() == 0) {
            findAvailableRooms = new ArrayList<>(rooms);
        } else {
            for (IRoom room : rooms) {
                for (Reservation reservation : reservations) {
                    if ((room.getRoomNumber() == reservation.getRoom().getRoomNumber()
                            && ((!checkInDate.after(reservation.getCheckInDate()) &&
                            !checkInDate.before(reservation.getCheckOutDate())) ||
                            (!checkOutDate.after(reservation.getCheckInDate()) &&
                                    !checkInDate.before(reservation.getCheckOutDate())))) ||
                            (!reservation.getRoom().getRoomNumber().contains(room.getRoomNumber()))) {
                        findAvailableRooms.add(room);
                    }
                }
            }
        }
        return findAvailableRooms;
    }
    public List<Reservation> getCustomersReservation(String customer) {
        List<Reservation> reservationsByCustomer = new ArrayList<>();
        for (Reservation reservation : reservations) {
            Customer customers = CustomerService.getInstance().getCustomer(customer);

            if (reservation.getCustomer().equals(customers)) {
                reservationsByCustomer.add(reservation);
            }
        }
        return reservationsByCustomer;
    }
    public Collection<Reservation> getAllReservations() {
       if (!reservations.isEmpty()) {
           Iterator<Reservation> customerIterator = reservations.iterator();
            while (customerIterator.hasNext()) {
               System.out.println(customerIterator.next());
           }

       }
        return reservations;
    }
    public Collection<IRoom> allRooms() {
        return rooms;
    }
    public void printAllRooms(){
        for(IRoom room : rooms){
            System.out.println(room);
        }
          }
          public void printAllReseverations(){

        for(Reservation reservation : reservations){
            System.out.println(reservation);
        }

          }
}