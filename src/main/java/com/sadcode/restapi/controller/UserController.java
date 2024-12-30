package com.sadcode.restapi.controller;

import com.sadcode.restapi.dto.UserDto;
import com.sadcode.restapi.respository.UserRepository;
import com.sadcode.restapi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
/*    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }*/

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user) {
        UserDto savedUsed = userService.createUser(user);
        return new ResponseEntity<>(savedUsed, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAllUsers(UserDto user) {
        List<UserDto> users = userService.getAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto user, @PathVariable Long id) {
        user.setId(id);
        UserDto updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable("userId") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("User: " + id + " is successfully deleted", HttpStatus.OK);
    }
}
