package com.personal.bebankaccount.service;

import com.personal.bebankaccount.mapper.User_InfoMapper;
import com.personal.bebankaccount.mapper.User_LoginMapper;
import com.personal.bebankaccount.model.LoginModel;
import com.personal.bebankaccount.model.User_InfoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {

  @Autowired
  User_LoginMapper user_loginMapper;

  @Autowired
  User_InfoMapper user_infoMapper;

  @Autowired
  HashedPINService hashedPINService;

  @Autowired
  JWTService jwtService;

  public Map<String, Object> authenticate(LoginModel loginModel) {
    Map<String, Object> body = new HashMap<>();
    String hashedPIN = user_loginMapper.selectHashed_PIN(loginModel.getUserID());

    if (hashedPIN == null) {
      body.put("message_code", 302);
      body.put("message", "Not Found");
    } else {
      boolean isValid = hashedPINService.validate(loginModel.getPIN(), hashedPIN);

      if (!isValid) {
        body.put("message_code", 302);
        body.put("message", "Not Found");
      } else {
        User_InfoModel user_infoModel = user_infoMapper.selectAccount_NumberFull_NameISO_4217(loginModel.getUserID());

        if (user_infoModel == null) {
          body.put("message_code", 500);
          body.put("message", "User_Info is not found. Contact Customer Support 1500888");
        } else {
          String token = jwtService.generate(user_infoModel.getAccount_Number(), loginModel.getUserID());

          body.put("message_code", 200);
          body.put("message", "OK");
          body.put("Full_Name", user_infoModel.getFull_Name());
          body.put("ISO_4217", user_infoModel.getISO_4217());
          body.put("token", token);
        }
      }
    }

    return body;
  }
}
