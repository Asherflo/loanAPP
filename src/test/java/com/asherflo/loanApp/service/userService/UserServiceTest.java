package com.asherflo.loanApp.service.userService;

import com.asherflo.loanApp.controller.dto.request.LoanRequest;
import com.asherflo.loanApp.controller.dto.request.UserRequest;
import com.asherflo.loanApp.controller.dto.response.loan.LoanResponseDto;
import com.asherflo.loanApp.controller.dto.response.user.UserResponse;
import com.asherflo.loanApp.controller.dto.response.user.UserResponseDto;
import com.asherflo.loanApp.model.Address;
import com.asherflo.loanApp.model.Loan;
import com.asherflo.loanApp.model.Payment;
import com.asherflo.loanApp.model.User;
import com.asherflo.loanApp.service.PaymentService.PaymentService;
import com.asherflo.loanApp.service.loanService.LoanService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

import static com.asherflo.loanApp.model.enums.Gender.FEMALE;
import static com.asherflo.loanApp.model.enums.LoanType.AUTO;
import static com.asherflo.loanApp.model.enums.LoanType.STUDENT;
import static com.asherflo.loanApp.model.enums.PaymentStatus.NOT_PAID;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;

    @Autowired
    private LoanService loanService;

    @Autowired
    private PaymentService paymentService;
//    @BeforeEach
//    void setUp() {
//        Address address = Address.builder()
//                .city("Akure")
//                .street("Aguda")
//                .zipCode("101190")
//                .houseNumber(21)
//                .state("Ondo")
//                .build();
//
//        UserRequest userRequest = new UserRequest();
//        userRequest.setUserId(2l);
//        userRequest.setFirstName("Queen");
//        userRequest.setLastName("Lilly");
//        userRequest.setDateOfBirth(LocalDateTime.now());
//        userRequest.setGender(FEMALE);
//        userRequest.setPhoneNumber("08066787853");
//        userRequest.setEmail("Queen@gmail.com");
//        userRequest.setPassword("567845");
//        userRequest.setAccountNumber("0145678");
//        userRequest.setAddress(address);
//
//        UserResponse response = userService.createUser(userRequest);
//
//    }

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
//        userRequest.setUserId(1l);
        userRequest.setFirstName("Grace");
        userRequest.setLastName("Agnes");
        userRequest.setGender(FEMALE);
        userRequest.setAddress(address);
        userRequest.setDateOfBirth(LocalDateTime.now());
        userRequest.setPassword("@qwe123#");
        userRequest.setEmail("pencilisup@gmail.comm");
        userRequest.setPhoneNumber("234789099912");
        userRequest.setLoanType(STUDENT);

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
    @Test
    @DisplayName("loan can be created")
    void createLoan(){
        User user = userService.searchUserByEmail("pencilisup@gmail.comm");

//        user.setGender(Gender.MALE);
        LoanRequest loanRequest = new LoanRequest();
        loanRequest.setLoanType(AUTO);
        loanRequest.setLoanBalance(BigDecimal.valueOf(0.000));
        loanRequest.setInterestRate(BigDecimal.valueOf(0.20));
        loanRequest.setLoanAmount(BigDecimal.valueOf(5_000_0000));
        loanRequest.setAccountNumber("0168924692");
        loanRequest.setUser(user);
        loanRequest.setPayment(NOT_PAID);
        loanRequest.setLoanStartDate(Date.from(Instant.now()));

        LoanResponseDto savedLoan = loanService.creatLoan(loanRequest);
        assertNotNull(savedLoan);
    }
    @Test
    @DisplayName("test that user can search for loan")
    void testThatUserCanSearchForLoan(){
        Loan loan = loanService.searchLoan("0168924692");
        assertEquals("0168924692",loan.getAccountNumber());
    }

    @Test
    @DisplayName("test to approve loan")
    void approveLoanForEligibleUser(){
        LoanResponseDto loanResponseDto = loanService.approveLoan(1,AUTO);
        assertEquals("Loan approved successfully",loanResponseDto.getMessage());

//
//    @Test
//    @DisplayName("test that user can search for payment")
//    void testThatUserCanSearchForPayment(){
//
//
  }

}