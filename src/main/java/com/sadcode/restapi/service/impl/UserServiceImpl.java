package com.sadcode.restapi.service.impl;

import com.sadcode.restapi.dto.UserDto;
import com.sadcode.restapi.entity.User;
import com.sadcode.restapi.exception.EmailAlreadyExistException;
import com.sadcode.restapi.exception.ResourceNotFoundException;
import com.sadcode.restapi.respository.UserRepository;
import com.sadcode.restapi.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        // Convert UserDto in userJpa entity
      /*  User user = new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        User savedUser = userRepository.save(user);
        );*/
        // User user = UserMapper.mapToUser(userDto);
        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
        if (optionalUser.isPresent()){
            throw new EmailAlreadyExistException("This email is already exist");
        }

        User user = modelMapper.map(userDto, User.class);
        User savedUser = userRepository.save(user);

        // convert User JPA entity into UserDto
       /*         UserDto savedUserDto = new UserDto(
                        savedUser.getId(),
                        savedUser.getFirstName(),
                        savedUser.getLastName(),
                        savedUser.getEmail()
        return savedUserDto;
                );*/
        //        UserDto savedUserDto = UserMapper.mapToUserDto(user);
        UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);
        return savedUserDto;
    }

    @Override
    public List<UserDto> getAll() {
        List<User> users = userRepository.findAll();
        // return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
        return users.stream()
                .map((user) -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id)
        );
        // return UserMapper.mapToUserDto(user);
        return modelMapper.map(user, UserDto.class);
    }


    @Override
    public UserDto updateUser(UserDto user) {
        User existingUser = userRepository.findById(user.getId()).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", user.getId())
        );
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updateUser = userRepository.save(existingUser);
        //  return UserMapper.mapToUserDto(updateUser);
        return modelMapper.map(updateUser, UserDto.class);
    }

    @Override
    public void deleteUser(Long id) {
        User existingUser = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id)
        );
        userRepository.deleteById(id);
    }


}
