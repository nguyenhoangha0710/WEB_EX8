package com.hoangha.jpaservlet.Respository;

import com.hoangha.jpaservlet.Entity.UserEntity;

public interface UserRespository {
    public UserEntity getUserByGmail(String gmail);

    boolean updateUser(UserEntity userEntity);
}
