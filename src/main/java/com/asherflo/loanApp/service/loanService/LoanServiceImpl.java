package com.asherflo.loanApp.service.loanService;

import com.asherflo.loanApp.controller.dto.request.LoanRequest;
import com.asherflo.loanApp.controller.dto.response.loan.LoanResponseDto;
import com.asherflo.loanApp.model.Loan;
import com.asherflo.loanApp.repository.LoanRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class LoanServiceImpl implements  LoanService {
    @Autowired
    private LoanRepository loanRepository;



    @Override
    public LoanResponseDto creatLoan(LoanRequest loanRequest) {
        LoanResponseDto loanResponseDto = new LoanResponseDto();

        Loan newLoan = new Loan();
        newLoan.setLoanAmount(loanRequest.getLoanAmount());
        newLoan.setAccountNumber(loanRequest.getAccountNumber());
        newLoan.setLoanType(loanRequest.getLoanType());
        newLoan.setLoanBalance(loanRequest.getLoanBalance());
        newLoan.setLoanStatus(loanRequest.getLoanStatus());
        newLoan.setInterestRate(loanRequest.getInterestRate());
        newLoan.setPaymentStatus(loanRequest.getPayment());

        Loan loanSaved  = loanRepository.save(newLoan);
        loanResponseDto.setLoan(loanSaved);
        loanResponseDto.setMessage("you have successfully apply for this loan");
        return loanResponseDto;
    }

    @Override
    public Loan searchLoan(String accountNumber) {
        return loanRepository.findByAccountNUmber(accountNumber);
    }

    @Override
    public Optional<Loan> findById(long loanId) {
        return loanRepository.findById(loanId);
    }

//    @Override
//    public LoanResponseDto approveLoan(int loanId, LoanType loanType) {
//        LoanResponseDto responseDto = new LoanResponseDto();
//        Loan existingLoan= loanRepository.findLoanByLoanIdAndLoanType(loanId,loanType);
//            if(existingLoan == null){
//                responseDto.setMessage("Error approving the Loan");
//            }
//            else{
//                loanRepository.approveLoan(loanId);
//                responseDto.setMessage("Loan approved successfully");
//            }
//            return responseDto;
//    }
}
