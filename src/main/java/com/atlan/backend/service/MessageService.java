package com.atlan.backend.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;


@Service
public class MessageService {
    @Value("${twilio.accountSid}")
    private String accountSid;
    @Value("${twilio.authToken}")
    private String authToken;

    public void sendSms(String phoneNumber, String message){
        Twilio.init(accountSid, authToken);

        Message.creator(
                    new com.twilio.type.PhoneNumber("+91"+phoneNumber),
                    new com.twilio.type.PhoneNumber("+12568263201"),
                    message
        ).create();
    }
}
