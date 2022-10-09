package com.asherflo.loanApp.controller.dto;

import com.asherflo.loanApp.controller.dto.request.UserRequest;
import com.asherflo.loanApp.controller.dto.response.user.UserResponse;
import com.asherflo.loanApp.controller.dto.response.user.UserResponseDto;
import com.asherflo.loanApp.model.User;
import com.asherflo.loanApp.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class LoanAppController {
    @Autowired
    private UserService userService;
    @PostMapping("/createUser")
    public UserResponse createUser(@RequestBody UserRequest userRequest){
        return userService.createUser(userRequest);
    }
    @GetMapping("/email/{email}")
    public User findUserByEmail(@PathVariable String email){
        return  userService.searchUserByEmail(email);
    }

    @GetMapping("/findAll")
    public UserResponseDto findAllUser(){
        return userService.getAllUser();

    }
}
