package com.hoangha.jpaservlet.Service.impl;

import com.hoangha.jpaservlet.DTO.UserDTO;
import com.hoangha.jpaservlet.Entity.UserEntity;
import com.hoangha.jpaservlet.Respository.UserRespository;
import com.hoangha.jpaservlet.Respository.impl.UserRespositoryImpl;
import com.hoangha.jpaservlet.Service.UserService;
import jakarta.servlet.http.Part;

public class UserServiceImpl implements UserService {

    private UserRespository userRespository = new UserRespositoryImpl();

    @Override
    public UserDTO getUserByGmail(String gmail) {
        UserEntity user = userRespository.getUserByGmail(gmail);
        UserDTO dto = new UserDTO();
        dto.setGmail(user.getGmail());
        dto.setFull_name(user.getFull_name());
        dto.setAddress(user.getAddress());
        dto.setPhone_number(user.getPhone_number());
        dto.setProduct_image(user.getProduct_image());
        dto.setPassword(user.getPassword());

        return dto;
    }

    @Override
    public boolean updateUserProfile(String gmail, String address, String fullname, String phone,  byte[] imagePart) {
        try {
            UserEntity user = userRespository.getUserByGmail(gmail);
            if (user == null) {
                return false;
            }
            // Validate dữ liệu nếu cần (có thể tách ra hàm riêng)
            // Cập nhật thông tin
            user.setFull_name(fullname != null ? fullname.trim() : user.getFull_name());
            user.setAddress(address != null ? address.trim() : user.getAddress());
            user.setPhone_number(phone != null ? phone.trim() : user.getPhone_number());
            if (imagePart != null && imagePart.length > 0) {
                user.setProduct_image(imagePart);
            }
            userRespository.updateUser(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
