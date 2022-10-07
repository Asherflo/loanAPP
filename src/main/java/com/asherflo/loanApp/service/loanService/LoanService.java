package com.asherflo.loanApp.service.loanService;

import com.asherflo.loanApp.controller.dto.request.LoanRequest;
import com.asherflo.loanApp.controller.dto.response.loan.LoanResponseDto;
import com.asherflo.loanApp.model.Loan;
import com.asherflo.loanApp.model.enums.LoanType;

public interface LoanService {
    LoanResponseDto creatLoan(LoanRequest loanRequest);
    Loan searchLoan(String accountNumber);

    LoanResponseDto approveLoan(int loanId , LoanType loanType);
}
