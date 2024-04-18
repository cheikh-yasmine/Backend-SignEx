package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.models.UserEntity;
import project.repository.UserRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

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
}

