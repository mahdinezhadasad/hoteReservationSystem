package api;
import Model.Customer;
import Model.IRoom;
import Model.Room;
import Model.RoomType;
import service.CustomerService;
import service.ReservationService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class MainMenu {
    public static void main(String[] args) {


        int selection = selecetMenu();

        switch (selection){

            case 1:

                addReservationMenu();


            case 2:
                addCustomer();


                ReservationService.getInstance().printAllReservation();


            case 5:

                int selectedAdminOption = AdminMenu.selectAdminMenu();
                AdminMenu.addLogicForAdminOptions(selectedAdminOption);


            case 6:


                System.exit(0);

        }

    }
    public static int selecetMenu(){
        System.out.println(" welcom to our hotel in zanzibar please\n" +
                "Select one Item\n" +
                "1.Find a Room or Reserv it \n" +
                "2.See my Reservation\n" +
                "5.Admin\n" +
                "6.Exit");
        Scanner input = new  Scanner(System.in);
        int selection = input.nextInt();
        System.out.println(selection + "has been selected  ");

        return selection;

 }
 public static void addCustomer(){
        Scanner input = new Scanner(System.in);

     System.out.println("Enter Email");
     String customerEmail = input.nextLine();
     System.out.println("Enter First Name");
     String firstName = input.nextLine();
     System.out.println("Enter Last Name");
     String lastName = input.nextLine();

     CustomerService.getInstance().addCustomer(customerEmail,firstName,lastName);
      }


   public static void addReservationMenu(){

       try { IRoom reservedRoom = null;

        Scanner input = new Scanner(System.in);
       System.out.println("Add Date format day/month/year");


           Date chechInDate = new SimpleDateFormat("MM/dd/yyyy").parse(input.nextLine());


           System.out.println("Add chechOutDate MM/DD/YY");

           Date chechOutDate = new SimpleDateFormat("MM/dd/yyyy").parse(input.nextLine());


           System.out.println("Enter your Email");
           String reservationEmail  = input.nextLine();
           System.out.println("What room would you like to reserve\n");
           System.out.println("Single or double");
           String roomNumber = input.nextLine();
           reservedRoom = ReservationService.getInstance().getARoom(roomNumber);


           System.out.println("Available rooms "+ReservationService.getInstance().findRooms(chechInDate, chechOutDate));

           Customer customer = CustomerService.getInstance().getCustomer(reservationEmail);

           ReservationService.getInstance().reservation(customer,reservedRoom,chechInDate,chechOutDate);




       } catch (ParseException e) {
           e.printStackTrace();
       }


   }







}