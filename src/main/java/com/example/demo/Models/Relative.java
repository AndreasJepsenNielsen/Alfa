package com.example.demo.Models;

public class Relative {
    @Override
    public String toString() {
        return "Relative{" +
                "relatedID=" + relatedID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", addictID=" + addictID +
                '}';
    }

    private int relatedID;
    private String firstName;
    private String lastName;
    private String email;
    private int phoneNumber;
    private int addictID;


    public Relative(int relatedID, String firstName, String lastName, String email, int phoneNumber, int addictID) {
        this.relatedID = relatedID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.addictID = addictID;

    }

    public Relative()
    {

    }

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

    public int getAddictID() {
        return addictID;
    }

    public void setAddictID(int addictID) {
        this.addictID = addictID;
    }
}
