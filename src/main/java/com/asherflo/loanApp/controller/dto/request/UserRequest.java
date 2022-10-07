package com.asherflo.loanApp.controller.dto.request;

import com.asherflo.loanApp.model.Address;
import com.asherflo.loanApp.model.enums.AccountType;
import com.asherflo.loanApp.model.enums.Gender;
import com.asherflo.loanApp.model.enums.LoanType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private Long userId;
    private  String firstName;
    private String lastName;
    private Gender gender;
    @Column(unique = true)
    private String email;
    private  String password;
    private String accountNumber;
    private AccountType accountType;
    private LoanType loanType;
    private Address address;
    private String phoneNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDateTime dateOfBirth;

}
