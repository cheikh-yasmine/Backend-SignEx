package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.models.UserEntity;
import project.repository.UserRepository;
import project.service.UserServiceInter;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    UserServiceInter userServiceInter;

    @Autowired
    UserRepository userRepository;



    @DeleteMapping("delete/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable String username) {
        // Recherche de l'utilisateur dans la base de données
        Optional<UserEntity> userOptional = userRepository.findByUsername(username);
        if (userOptional.isPresent()) {
            // L'utilisateur existe, le supprimer de la base de données
            userRepository.delete(userOptional.get());
            return ResponseEntity.ok("User deleted successfully");
        } else {
            // L'utilisateur n'existe pas dans la base de données
            return ResponseEntity.notFound().build();
        }
    }


    //liste des utilisateurs
    @GetMapping(value = "/getAllUsers")
    public  List<UserEntity> getAllUsers()
    {
        return userServiceInter.getAllUsers();

    }

    @PutMapping(value = "/updateUserP/{id}")
    public UserEntity updateUser(@PathVariable Long id ,@RequestBody UserEntity user)
    {
        return userServiceInter.updateUser(id,user);

    }

    @GetMapping(value = "/getUserById/{id}")
    public UserEntity getUserById(@PathVariable Long id)
    {
        return userServiceInter.getById(id);

    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteUserId(@PathVariable Long id)
    {

        userServiceInter.deleteUserId(id);
    }
}

