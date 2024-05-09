package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import project.models.UserEntity;

import project.repository.RoleRepository;
import project.repository.UserRepository;
import project.security.JWTGenerator;

import javax.management.relation.Role;
import java.util.List;

@Service
public class UserServiceImpl implements UserServiceInter{

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;


    @Override
    public void deleteUser(Long id) {

        userRepository.deleteById(id);
    }

    @Override
    public List<UserEntity> getAllUsers()
    {

        return userRepository.findAll();
    }

    @Override
    public UserEntity updateUser(Long id,UserEntity user)
    {
        UserEntity usr= userRepository.findById(id).get();
        usr.setFirstName(  user.getFirstName()  );
        usr.setLastName( user.getLastName()  );
        usr.setUsername( user.getUsername()  );
        usr.setEmail( user.getEmail()  );
        usr.setPassword( user.getPassword()  );
        usr.setCompanyName( user.getCompanyName() );
        usr.setPhone(user.getPhone());
        return userRepository.save(usr);
    }

    @Override
    public  UserEntity getById(Long id)
    {

        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteUserId(Long id) {

        userRepository.deleteById(id);
    }



}

