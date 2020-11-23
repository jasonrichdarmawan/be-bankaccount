package com.personal.bebankaccount.controller;

import com.personal.bebankaccount.model.TransactionModel;
import com.personal.bebankaccount.service.JWTService;
import com.personal.bebankaccount.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TransactionController {

  @Autowired
  JWTService jwtService;

  @Autowired
  TransferService transferService;

  @GetMapping("api/v1/balance")
  public ResponseEntity<?> calculateCurrentBalance(@RequestHeader(value = "Authorization") String authorization) {
    String token = authorization.split(" ")[1];
    boolean isValid = jwtService.isValid(authorization.split(" ")[1]);

    Map<String, Object> body = new HashMap<>();

    if (!isValid) {
      body.put("message_code", 401);
      body.put("message", "Unauthorized");
      return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
    } else {
      String accountNumber = (String) jwtService.getClaim(token, "Account_Number");
      BigDecimal currentBalance = transferService.calculateCurrentBalance(accountNumber);
      body.put("message_code", 200);
      body.put("message", "OK");
      body.put("balance", currentBalance);
      return new ResponseEntity<>(body, HttpStatus.OK);
    }
  }

  @PostMapping("api/v1/transaction")
  public ResponseEntity<?> transfer(@RequestHeader(value = "Authorization") String authorization, @Valid @RequestBody TransactionModel transactionModel) {
    String token = authorization.split(" ")[1];
    boolean isValid = jwtService.isValid(token);

    Map<String, Object> body = new HashMap<>();

    if (!isValid) {
      body.put("message_code", 401);
      body.put("message", "Unauthorized");
      return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
    } else {
      String accountNumber = (String) jwtService.getClaim(token, "Account_Number");
      Map<String, Object> response = transferService.transfer(accountNumber, transactionModel);
      return ResponseEntity.status((int) response.get("message_code")).body(response);
    }
  }
}
