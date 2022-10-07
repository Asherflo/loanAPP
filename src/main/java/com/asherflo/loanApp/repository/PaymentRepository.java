package com.asherflo.loanApp.repository;

import com.asherflo.loanApp.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
