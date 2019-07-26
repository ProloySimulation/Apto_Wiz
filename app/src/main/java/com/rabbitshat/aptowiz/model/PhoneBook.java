package com.rabbitshat.aptowiz.model;

/**
 * Created by RHAndroidPC on 12/10/2016.
 */

public class PhoneBook {
//    @Column(name = "PhoneBookId")
    public String phoneBookId;

//    @Column(name = "Number")
    public String number;

//    @Column(name = "name")
    public String name;

//    @Column(name = "Designation")
    public String designation;

//    @Column(name = "Email")
    public String email;


//    @Column(name = "Type")
    public String type;


//    @Column(name = "ContactOption")
    public String contactOption;


//    @Column(name = "ApartmentInfoId")
    public String apartmentInfoId;

    public String getPhoneBookId() {
        return phoneBookId;
    }

    public void setPhoneBookId(String phoneBookId) {
        this.phoneBookId = phoneBookId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContactOption() {
        return contactOption;
    }

    public void setContactOption(String contactOption) {
        this.contactOption = contactOption;
    }

    public String getApartmentInfoId() {
        return apartmentInfoId;
    }

    public void setApartmentInfoId(String apartmentInfoId) {
        this.apartmentInfoId = apartmentInfoId;
    }

    public PhoneBook() {

    }
}
