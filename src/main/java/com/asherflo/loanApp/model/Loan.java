package com.asherflo.loanApp.model;

import com.asherflo.loanApp.model.enums.LoanType;
import com.asherflo.loanApp.model.enums.LoanStatus;
import com.asherflo.loanApp.model.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "loan_details")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long loanId;
    private  String accountNumber;

    @Enumerated(EnumType.STRING)
    private LoanType loanType;
    private BigDecimal loanAmount;
    private BigDecimal loanBalance;
    private BigDecimal interestRate;
    @ManyToOne
    private  User user;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    @Enumerated(EnumType.STRING)
    private LoanStatus loanStatus;

}
