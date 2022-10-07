package com.asherflo.loanApp.controller.dto.response.payment;

import com.asherflo.loanApp.model.Payment;
import lombok.Data;

@Data
public class PaymentResponse {
    private String message;
    private Payment payment;
}
