package com.studentmanager.sm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "student")
public class StudentEntity {

    @Id
    @Column(name = "NIC", nullable = false, length = 20)
    private String nic;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "DOB", nullable = false)
    private LocalDate dob;

    @Column(name = "Address", nullable = false, length = 255)
    private String address;

    @Column(name = "email", nullable = false, length = 255)
    private String email;

    @Column(name = "phone_number", nullable = false, length = 15)
    private String phoneNumber;

    @Column(name = "gender", nullable = false, length = 20)
    private String gender;

    public StudentEntity() {
    }

    public StudentEntity(String nic, String name, LocalDate dob, String address, String email, String phoneNumber, String gender) {
        this.nic = nic;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
