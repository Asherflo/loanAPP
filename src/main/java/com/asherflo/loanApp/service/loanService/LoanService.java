package com.asherflo.loanApp.service.loanService;

import com.asherflo.loanApp.controller.dto.request.LoanRequest;
import com.asherflo.loanApp.controller.dto.response.loan.LoanResponseDto;
import com.asherflo.loanApp.model.Loan;

import java.util.Optional;

public interface LoanService {
    LoanResponseDto creatLoan(LoanRequest loanRequest);
    Loan searchLoan(String accountNumber);

    Optional<Loan> findById(long loanId);
//
//    LoanResponseDto approveLoan(int loanId , LoanType loanType);
}
