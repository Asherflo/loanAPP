package com.asherflo.loanApp.service.userService;

import com.asherflo.loanApp.dto.request.UserRequest;
import com.asherflo.loanApp.dto.response.user.UserResponse;
import com.asherflo.loanApp.dto.response.user.UserResponseDto;
import com.asherflo.loanApp.model.User;
import com.asherflo.loanApp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        UserResponse userResponse = new UserResponse();
        User user = new User();
        user.setUserId(userRequest.getUserId());
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setDateOfBirth(userRequest.getDateOfBirth());
        user.setEmail(userRequest.getEmail());
        user.setGender(userRequest.getGender());
        user.setPhoneNumber(userRequest.getPhoneNumber());
        user.setAccountNumber(userRequest.getAccountNumber());
        user.setPassword(userRequest.getPassword());
        userRequest.setAddress(userRequest.getAddress());
        User registeredUser = userRepository.save(user);
        userResponse.setUser(registeredUser);
        userResponse.setMessage("A user is created");
        return  userResponse;

    }

    @Override
    public User searchUserByEmail(String email) {
         return  userRepository.findByEmail(email);
    }

    @Override
    public UserResponseDto getAllUser() {
        List<User> userList = new ArrayList<>(userRepository.findAll());
        if(userList.isEmpty()){
            throw  new IllegalArgumentException("user list is empty");
        }
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setResponseList(userList);
        return responseDto;
    }
}
