package com.asherflo.loanApp.repository;

import com.asherflo.loanApp.controller.dto.response.loan.LoanResponseDto;
import com.asherflo.loanApp.model.Loan;
import com.asherflo.loanApp.model.enums.LoanType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public interface LoanRepository extends JpaRepository<Loan,Long> {
    @Query(nativeQuery = true,value = "select * from loan_details where account_number =:accountNumber")

    Loan findByAccountNUmber(String accountNumber);

    Loan findLoanByLoanIdAndLoanType(int loanId, LoanType loanType);
//    @Transactional
//    @Modifying
//    @Query(value = "update loan set loan_status='Approved',loan_balance=loan_amount where loan_id=:loanId",nativeQuery = true)
//    void approveLoan(int loadId);
}
