package com.personal.bebankaccount.service;

import com.personal.bebankaccount.mapper.User_DetailMapper;
import com.personal.bebankaccount.mapper.User_InfoMapper;
import com.personal.bebankaccount.mapper.User_LoginMapper;
import com.personal.bebankaccount.model.RegisterModel;
import com.personal.bebankaccount.model.User_InfoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RegisterService {
  @Autowired
  User_LoginMapper userLoginMapper;

  @Autowired
  HashedPINService hashedPINService;

  @Autowired
  User_InfoMapper userInfoMapper;

  @Autowired
  User_DetailMapper userDetailMapper;

  @Autowired
  JWTService jwtService;

  public Map<String, Object> insert(RegisterModel registerModel, String userID) {
    Map<String, Object> result = new HashMap<>();

    String hashedPIN = hashedPINService.hash(registerModel.getPIN());

    if (userLoginMapper.insert(userID, hashedPIN) != 1) {
      result.put("message_code", 500);
      result.put("message", "Internal Server Error");
      return result;
    } else {
      User_InfoModel userInfoModel = new User_InfoModel(userID, registerModel.getFullName(), registerModel.getISO4217());

      if (userInfoMapper.insertSelectKeyAccount_Number(userInfoModel) != 1) {
        result.put("message_code", 500);
        result.put("message", "Internal Server Error");
        return result;
      } else {
        if (userDetailMapper.insert(userInfoModel.getAccount_Number(), registerModel.getBirthDate(), registerModel.getAddress3(), registerModel.getAddress4(), registerModel.getAddress1(), registerModel.getAddress2(), registerModel.getZipCode(), registerModel.getISO31661()) != 1) {
          result.put("message_code", 500);
          result.put("message", "Internal Server Error");
          return result;
        } else {
          String token = jwtService.generate(userInfoModel.getAccount_Number(), userID);
          result.put("message_code", 201);
          result.put("message", "CREATED");
          result.put("User_ID", userID);
          result.put("token", token);
          return result;
        }
      }
    }
  }
}
