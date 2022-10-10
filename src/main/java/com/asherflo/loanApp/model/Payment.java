package com.asherflo.loanApp.model;

import com.asherflo.loanApp.model.enums.PaymentStatus;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "loan_id")
    private Loan loanId;


    @Column(name = "payment_status")
    private PaymentStatus paymentStatus;

    @Column(name = "payment_date")
    private Date paymentDate;


    @Column(name = "payment_amount")
    private BigDecimal paymentAmount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
        private User user;
}
