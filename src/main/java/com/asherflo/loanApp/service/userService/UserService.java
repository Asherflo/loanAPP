package com.asherflo.loanApp.service.userService;

import com.asherflo.loanApp.dto.request.UserRequest;
import com.asherflo.loanApp.dto.response.user.UserResponse;
import com.asherflo.loanApp.dto.response.user.UserResponseDto;
import com.asherflo.loanApp.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserResponse createUser(UserRequest userRequest);


    User searchUserByEmail(String email);

    UserResponseDto getAllUser();
}
