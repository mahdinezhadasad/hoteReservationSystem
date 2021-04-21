package api;


import Model.*;
import service.CustomerService;
import service.ReservationService;
import java.util.Collection;
import java.util.List;
import api.HotelResource;
import java.util.Scanner;

public class AdminMenu {

    public static int exitApp = 5;
    public static void startAdmin() {




        System.out.println("ADMIN MENU");
        System.out.println("Choose option");
        System.out.println("1. See all customers");
        System.out.println("2. See all rooms");
        System.out.println("3. See all reservations");
        System.out.println("4. Add a Room");
        System.out.println("5. Back to Main Menu");

    }

    public static void seeAllCustomer() {
        CustomerService.getInstance().getAllCustomers()

        ;

        startAdmin();
    }


    public static void seeAllRooms() {

        ReservationService.getInstance().allRooms();

    }

    public static void seeAllReservations() {

        ReservationService.getInstance().getAllReservations();

    }

    public static void addRoomMenu() {
        boolean addAnotherRoom = true;
        String newRoomNumber;
        Double newRoomPrice;
        int newRoomType;
        while (addAnotherRoom) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter room number: ");
            newRoomNumber = input.nextLine();
            System.out.println("Enter price per night: ");
            newRoomPrice = input.nextDouble();
            System.out.println("Enter room type: 1 for single bed, 2 for double bed");
            while (!input.hasNext("[1|2]")) {
                System.out.println("Please enter 1 (Single Room) or 2 (Double Room)!");
                input.next();
            }
            newRoomType = input.nextInt() - 1;
            System.out.println("Would you like to add another room? y/n");
            while (!input.hasNext("(?i)[Y|N]")) {
                System.out.println("Please enter Y (Yes) or N (No)!");
                input.next();
            }
            if (input.nextLine().equalsIgnoreCase("Y")) {
                addAnotherRoom = true;
            } else {
                addAnotherRoom = false;
            }
            ReservationService.getInstance().addRoom(newRoomNumber, newRoomPrice, RoomType.values()[newRoomType]);
        }

        startAdmin();

    }

    public static void selectionImplementation(){

        Scanner scanner = new Scanner(System.in);
        startAdmin();


        int selection = scanner.nextInt();
        System.out.println("you have selected " + selection);

        while (selection != exitApp) {
            switch (selection) {
                case 1:

                    seeAllCustomer();
                    //finds and Reserves a room
                    System.out.println("You Selected to see Reservation");
                    ;
                    break;
                case 2:

                    seeAllRooms();
                    //Views the customers current reservations
                    System.out.println("You Selected to view your Rooms");
                    ;
                    break;
                case 3:
                    seeAllReservations();
                    //creates a user account
                    System.out.println("You Selected to See all reservation");
                    ;
                    break;
                case 4:
                    addRoomMenu();
                    System.out.println("You Selected to add room");
                    break;
                case 5:
                    //closes console
                    ;
                    System.exit(0);
                default:
                    //User inputs an unexpected choice
                    System.out.println("Incorrect Input");
                    break;
            }

            //startAdmin();
            selection = scanner.nextInt();

        }





    }

}