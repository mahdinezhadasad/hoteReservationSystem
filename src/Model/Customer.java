package Model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer {

    String firstName;
    String lastName;
    String mail;
    String emailRegex = "^(.+)@(.+).(.+)$";
    Pattern pattern = Pattern.compile(emailRegex);


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Customer(String firstName, String lastName, String mail){
    if(!pattern.matcher(mail).matches()){
        throw new IllegalArgumentException ( "Email is not correct");

    }

    this.firstName = firstName;
    this.lastName = lastName;
    this.mail = mail;

    }



    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
