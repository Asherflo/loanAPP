package com.asherflo.loanApp.repository;

import com.asherflo.loanApp.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan,Long> {
}
