package project.service;


import project.models.UserEntity;

import java.util.List;

public interface UserServiceInter {


    void deleteUserId(Long id);
    void deleteUser(Long id);
    List<UserEntity> getAllUsers();
    UserEntity updateUser(Long id,UserEntity user);
    UserEntity getById(Long id);



}

