package com.hoangha.jpaservlet.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Transient;

import java.util.Base64;

public class UserDTO {
    private String gmail;

    private String address;

    private String phone_number;

    private String full_name;

    private String password;
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

    @Transient
    public String getBase64Image() {
        if (product_image != null) {
            return Base64.getEncoder().encodeToString(product_image);
        }
        return null;
    }


    // Phương thức trả về Data URI dạng Base64 để hiển thị ảnh
    public String getImageDataUri() {
        if (product_image != null && product_image.length > 0) {
            String base64Image = Base64.getEncoder().encodeToString(product_image);
            return "data:image/png;base64," + base64Image;
        }
        return null;
    }

    public void setBase64Image(String base64) {
    }
}
