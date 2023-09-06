package com.atlan.backend.service;

import com.atlan.backend.entity.User;
import com.atlan.backend.entity.isValid;
import com.atlan.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserValidationService userValidationService;
    @Autowired
    MessageService messageService;
    public  List<User> getUsers() {return userRepository.findAll();}

    public Object addUser(User user){
        isValid response = userValidationService.validateUser(user);
        if(response.isEmailValid() && response.isIncomeValid() && response.isNameValid() && response.isPhoneValid()){
            userRepository.save(user);
            String MessageBody = "Hi, " + user.getName() + "your email is " + user.getEmail() + " and phone number is " + user.getMobileNumber() + " your monthly income is " + user.getMonthlyIncome() + " and your monthly savings are " + user.getMonthlySavings();
            messageService.sendSms(user.getMobileNumber(), MessageBody);
            return "User Added";
        }
        else{
            return response;
        }
    }
}
