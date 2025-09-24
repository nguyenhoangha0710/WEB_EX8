package com.hoangha.jpaservlet.Service;

import com.hoangha.jpaservlet.DTO.UserDTO;
import com.hoangha.jpaservlet.Entity.UserEntity;
import jakarta.servlet.http.Part;

public interface UserService {
    public UserDTO getUserByGmail(String gmail);

    boolean updateUserProfile(String gmail, String address, String fullname, String phone,  byte[] imagePart);
}
