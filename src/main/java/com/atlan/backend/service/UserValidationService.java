package com.atlan.backend.service;


import com.atlan.backend.entity.User;
import com.atlan.backend.entity.isValid;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserValidationService {

    public static final String EMAIL_PATTERN = "^[a-zA-Z0-9_!#$%&amp;'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    public static final String MOBILE_REGEX = "(0/91)?[6-9][0-9]{9}";

    public static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    public isValid validateUser(User user) {

//        ValidationResult validationResult = new ValidationResult();
        isValid validity = new isValid();
        Matcher matcher = pattern.matcher(user.getEmail());

        if(matcher.matches()){
            validity.setEmailValid(true);
        }else{
            validity.setEmailValid(false);
        }

        char[] __name =user.getName().toCharArray();

        for(char ch: __name){
            if(Character.isDigit(ch)){
                validity.setNameValid(false);
                break;
            }else{
                validity.setNameValid(true);
            }
        }
        if(user.getMobileNumber().matches(MOBILE_REGEX)){
            validity.setPhoneValid(true);
        }else{
            validity.setPhoneValid(false);
        }
        if (user.getMonthlySavings() >= user.getMonthlyIncome()) {
            validity.setIncomeValid(false);
        }else {
            validity.setIncomeValid(true);
        }


        return validity;
    }
}
