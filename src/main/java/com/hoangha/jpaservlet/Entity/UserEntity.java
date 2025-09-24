package com.hoangha.jpaservlet.Entity;

import jakarta.persistence.*;

import java.util.Base64;

@Entity
@Table(name="account")
public class UserEntity {

    @Id
    @Column(name = "gmail")
    private String gmail;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "full_name")
    private String full_name;

    @Column(name = "password")
    private String password;

    @Lob
    @Column(name = "product_image")
    private byte[] product_image;

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getProduct_image() {
        return product_image;
    }

    public void setProduct_image(byte[] product_image) {
        this.product_image = product_image;
    }


    public String getBase64Image() {
        if (product_image != null && product_image.length > 0) {
            return Base64.getEncoder().encodeToString(product_image);
        }
        return null;
    }
}
