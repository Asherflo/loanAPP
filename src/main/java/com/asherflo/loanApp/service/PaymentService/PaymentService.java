package com.asherflo.loanApp.service.PaymentService;

import com.asherflo.loanApp.controller.dto.response.payment.PaymentResponse;
import com.asherflo.loanApp.model.Payment;

public interface PaymentService {
    PaymentResponse payLoan(Payment payments, long loanId);
}
