package api;


import Model.*;
import service.CustomerService;
import service.ReservationService;
import java.util.Collection;
import java.util.List;
import api.HotelResource;
import java.util.Scanner;

public class AdminMenu {


    public static int startAdmin() {


        Scanner scanner = new Scanner(System.in);

        System.out.println("ADMIN MENU");
        System.out.println("Choose option");
        System.out.println("1. See all customers");
        System.out.println("2. See all rooms");
        System.out.println("3. See all reservations");
        System.out.println("4. Add a Room");
        System.out.println("5. Back to Main Menu");
        int selection = scanner.nextInt();
        System.out.println("you have selected " + selection);
        return selection;
    }

    public static void seeAllCustomer() {
        CustomerService.getInstance().getAllCustomers();
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

    }

    public static void selectionImplementation(int selection){


        switch(selection){

            case 1:
                seeAllCustomer();

                break;


            case 2:
                seeAllRooms();


                break;


            case 3:

                seeAllReservations();


                break;


            case 4:

                addRoomMenu();

                break;

            case 5:

                MainMenu.display_Menu();


                break;

        }

    }

}