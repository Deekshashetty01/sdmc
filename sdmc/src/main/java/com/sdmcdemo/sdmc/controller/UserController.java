package com.sdmcdemo.sdmc.controller;


import com.sdmcdemo.sdmc.exception.UserHandledException;
import com.sdmcdemo.sdmc.model.user;
import com.sdmcdemo.sdmc.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
   private userRepository userRepository;

    @PostMapping("/saveUser")
    user newUser(@RequestBody user newUser) {
        return userRepository.save(newUser);
    }

    @GetMapping("/getUsers")
    List<user> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    user getUserById(@PathVariable Long id){
        return userRepository.findById(id).orElseThrow(() -> new UserHandledException(id));
    }

    @PutMapping("/user/{id}")
    user updateUser(@RequestBody user updateUser, @PathVariable Long id) {
        return userRepository.findById(id)
                .map(use -> {
                    use.setName(updateUser.getName());
                    use.setUsername(updateUser.getUsername());
                    use.setEmail(updateUser.getEmail());
                    return userRepository.save(use);
                }).orElseThrow(()-> new UserHandledException(id));
    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserHandledException(id);
        }
        userRepository.deleteById(id);
        return "User with id: "+id+ " has been deleted";
    }

}
