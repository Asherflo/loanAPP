package com.asherflo.loanApp.service.userService;

import com.asherflo.loanApp.dto.request.UserRequest;
import com.asherflo.loanApp.dto.response.user.UserResponse;
import com.asherflo.loanApp.dto.response.user.UserResponseDto;
import com.asherflo.loanApp.model.Address;
import com.asherflo.loanApp.model.User;
import com.asherflo.loanApp.model.enums.Gender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static com.asherflo.loanApp.model.enums.Gender.FEMALE;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;

    @BeforeEach
    void setUp() {
        Address address = Address.builder()
                .city("Akure")
                .street("Aguda")
                .zipCode("101190")
                .houseNumber(21)
                .state("Ondo")
                .build();

        UserRequest userRequest = new UserRequest();
        userRequest.setUserId(2l);
        userRequest.setFirstName("Queen");
        userRequest.setLastName("Lilly");
        userRequest.setDateOfBirth(LocalDateTime.now());
        userRequest.setGender(FEMALE);
        userRequest.setPhoneNumber("08066787853");
        userRequest.setEmail("Queen@gmail.com");
        userRequest.setPassword("567845");
        userRequest.setAccountNumber("0145678");
        userRequest.setAddress(address);

        UserResponse response = userService.createUser(userRequest);

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    @DisplayName("test that a user can be created")
    void createUser(){
        Address address = Address.builder()
                .city("yaba")
                .houseNumber(12)
                .zipCode("101014")
                .state("lagos")
                .street("emily Akinsola")
                .build();
        UserRequest userRequest = new UserRequest();
        userRequest.setUserId(1l);
        userRequest.setFirstName("Grace");
        userRequest.setLastName("Agnes");
        userRequest.setGender(FEMALE);
        userRequest.setAddress(address);
        userRequest.setDateOfBirth(LocalDateTime.now());
        userRequest.setPassword("@qwe123#");
        userRequest.setEmail("pencilisup@gmail.com");
        userRequest.setPhoneNumber("234789099912");

        UserResponse userResponse = userService.createUser(userRequest);
        assertEquals("A user is created",userResponse.getMessage());
        assertNotNull(userResponse);
    }
    @Test
    @DisplayName("test that users can be searched by their email")
    void searchUserByEmail(){
        User users =  userService.searchUserByEmail("pencilisup@gmail.com");
        assertEquals("pencilisup@gmail.com",users.getEmail());
    }
    @Test
    @DisplayName("test to get all users")
    void getAllUser(){
        UserResponseDto user = userService.getAllUser();
        assertEquals(2,user.getResponseList().size());
    }

}