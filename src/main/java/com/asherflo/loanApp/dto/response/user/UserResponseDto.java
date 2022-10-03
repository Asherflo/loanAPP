package com.asherflo.loanApp.dto.response.user;

import com.asherflo.loanApp.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    private List<User> responseList;
}
