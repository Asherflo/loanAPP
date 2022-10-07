package com.asherflo.loanApp.controller.dto.request;

import com.asherflo.loanApp.model.User;
import com.asherflo.loanApp.model.enums.LoanStatus;
import com.asherflo.loanApp.model.enums.LoanType;
import com.asherflo.loanApp.model.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoanRequest {
    private  Long loanId;
    private String accountNumber;
    private LoanType loanType;
    private BigDecimal loanBalance;
    private BigDecimal interestRate;
    private LoanStatus loanStatus;
    private PaymentStatus payment;
    private BigDecimal loanAmount;

    private Date loanStartDate;
    private User user;


}
