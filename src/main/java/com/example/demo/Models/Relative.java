package com.example.demo.Models;

//Klasse som definerer objektet relative
public class Relative {
    //Attributes
    private int relatedID;
    private String firstName;
    private String lastName;
    private String email;
    private int phoneNumber;

    //Constructor til klassen Relative som bruger ovenstående attributes som parametre
    public Relative(int relatedID, String firstName, String lastName, String email, int phoneNumber) {
        this.relatedID = relatedID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    //Tom constructor til relative klassen
    public Relative()
    {
    }

    //Getters and setters
    public int getRelatedID() {
        return relatedID;
    }

    public void setRelatedID(int relatedID) {
        this.relatedID = relatedID;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}
