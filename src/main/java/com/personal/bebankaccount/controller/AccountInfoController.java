package com.personal.bebankaccount.controller;

import com.personal.bebankaccount.mapper.User_InfoMapper;
import com.personal.bebankaccount.service.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Pattern;
import java.util.HashMap;
import java.util.Map;

@Validated
@RestController
public class AccountInfoController {

  @Autowired
  JWTService jwtService;

  @Autowired
  User_InfoMapper userInfoMapper;

  @GetMapping("api/v1/account/{Account_Number}")
  public ResponseEntity<?> getAccountInfoByAccount_Number(@RequestHeader(value = "Authorization") @Pattern(regexp = "^Bearer .*$", message = "Authorization must contains Bearer token") String authorization, @PathVariable("Account_Number") @Pattern(regexp = "[0-9]{17}", message = "Account Number length must be 17") String accountNumber) {
    boolean isValid = jwtService.isValid(authorization.split(" ")[1]);

    Map<String, Object> body = new HashMap<>();

    if (!isValid) {
      body.put("message_code", 401);
      body.put("message", "Unauthorized");
      return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
    } else {
      String fullName = userInfoMapper.selectByAccount_Number(accountNumber);

      if (fullName == null) {
        body.put("message_code", 404);
        body.put("message", "NOT FOUND");
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
      } else {
        body.put("message_code", 200);
        body.put("message", "OK");

        Map<String, String> account_info = new HashMap<>();
        account_info.put("Full_Name", fullName);

        body.put("account_info", account_info);

        return new ResponseEntity<>(body, HttpStatus.OK);
      }
    }
  }
}
