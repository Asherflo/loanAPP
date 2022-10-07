package com.asherflo.loanApp.controller.dto.response.loan;


import com.asherflo.loanApp.model.Loan;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class LoanResponseDto {
    private String message;
    private Loan loan;
}
