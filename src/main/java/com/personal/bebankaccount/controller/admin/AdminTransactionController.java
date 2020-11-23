package com.personal.bebankaccount.controller.admin;

import com.personal.bebankaccount.mapper.Admin_LoginMapper;
import com.personal.bebankaccount.mapper.Admin_TransactionsMapper;
import com.personal.bebankaccount.mapper.TransactionsMapper;
import com.personal.bebankaccount.mapper.User_InfoMapper;
import com.personal.bebankaccount.model.AdminTransactionModel;
import com.personal.bebankaccount.model.TransactionModel;
import com.personal.bebankaccount.service.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AdminTransactionController {

  @Autowired
  JWTService jwtService;

  @Autowired
  Admin_LoginMapper adminLoginMapper;

  @Autowired
  User_InfoMapper userInfoMapper;

  @Autowired
  Admin_TransactionsMapper adminTransactionsMapper;

  @Autowired
  TransactionsMapper transactionsMapper;

  @PostMapping("api/v1/admin/transaction")
  public ResponseEntity<?> transfer(@RequestHeader(value = "Authorization") String authorization, @Valid @RequestBody AdminTransactionModel adminTransactionModel) {
    String token = authorization.split(" ")[1];
    boolean isValid = jwtService.isValid(token);

    Map<String, Object> body = new HashMap<>();

    if (!isValid) {
      body.put("message_code", 401);
      body.put("message", "Unauthorized");
      return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
    } else {
      String accountNumber = (String) jwtService.getClaim(authorization.split(" ")[1], "Account_Number");

      if (accountNumber.equals(adminTransactionModel.getDestination())) {
        body.put("message_code", 400);
        body.put("message", "Bad Request");
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
      } else {
        String userID = (String) jwtService.getClaim(token, "User_ID");

        if (!adminLoginMapper.exists(userID)) {
          body.put("message_code", 400);
          body.put("message", "Bad Request");
          return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
        } else {

          if (!userInfoMapper.exists(adminTransactionModel.getDestination())) {
            body.put("message_code", 404);
            body.put("message", "NOT FOUND");
            return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
          } else {
            if (adminTransactionsMapper.insert(adminTransactionModel, userID) != 1) {
              body.put("message_code", 503);
              body.put("message", "Service Unavailable");
              return new ResponseEntity<>(body, HttpStatus.SERVICE_UNAVAILABLE);
            } else {
              if (transactionsMapper.insert(new TransactionModel(adminTransactionModel.getDestination(), 1, adminTransactionModel.getTransactionValue()), "SETORAN TUNAI") != 1) {
                body.put("message_code", 503);
                body.put("message", "Service Unavailable");
                return new ResponseEntity<>(body, HttpStatus.SERVICE_UNAVAILABLE);
              } else {
                body.put("message_code", 201);
                body.put("message", "CREATED");
                return new ResponseEntity<>(body, HttpStatus.CREATED);
              }
            }
          }
        }
      }

    }
  }
}
