package com.asherflo.loanApp.dto.response.user;

import com.asherflo.loanApp.model.User;
import lombok.Data;

@Data
public class UserResponse {
    private String message;
    private User user;
}
