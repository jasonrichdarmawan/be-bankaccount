package com.personal.bebankaccount.controller;

import com.personal.bebankaccount.mapper.TransactionsMapper;
import com.personal.bebankaccount.model.TransactionModel;
import com.personal.bebankaccount.model.TransferModel;
import com.personal.bebankaccount.service.JWTService;
import com.personal.bebankaccount.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.time.temporal.ChronoUnit.DAYS;

@RestController
public class TransactionController {

  @Autowired
  JWTService jwtService;

  @Autowired
  TransferService transferService;

  @Autowired
  TransactionsMapper transactionsMapper;

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
  public ResponseEntity<?> transfer(@RequestHeader(value = "Authorization") String authorization, @Valid @RequestBody TransferModel transferModel) {
    String token = authorization.split(" ")[1];
    boolean isValid = jwtService.isValid(token);

    Map<String, Object> body = new HashMap<>();

    if (!isValid) {
      body.put("message_code", 401);
      body.put("message", "Unauthorized");
      return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
    } else {
      String accountNumber = (String) jwtService.getClaim(token, "Account_Number");
      Map<String, Object> response = transferService.transfer(accountNumber, transferModel);
      return ResponseEntity.status((int) response.get("message_code")).body(response);
    }
  }

  @GetMapping("api/v1/history/{start}/{end}")
  public ResponseEntity<?> selectTransactionBetweenStartAndDate(@RequestHeader(value = "Authorization") String authorization, @PathVariable("start") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate start, @PathVariable("end") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
    Map<String, Object> body = new HashMap<>();

    LocalDate today = LocalDate.now();
    if (
            today.equals(start) || today.equals(end) ||
            today.compareTo(start) < 0 || today.compareTo(end) < 0 ||
            start.compareTo(end) > 0 ||
            DAYS.between(start, today) > 30 ||
            DAYS.between(start, end) > 30
    ) {
      body.put("message_code", 400);
      body.put("message", "Bad Request");
      return new ResponseEntity<>(body, HttpStatus.OK);
    } else {
      String token = authorization.split(" ")[1];
      boolean isValid = jwtService.isValid(token);

      if (!isValid) {
        body.put("message_code", 401);
        body.put("message", "Unauthorized");
        return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
      } else {
        String accountNumber = (String) jwtService.getClaim(token, "Account_Number");
        List<TransactionModel> transactionModels = transactionsMapper.select(accountNumber, start, end);
        BigDecimal openingBalance = transferService.selectPreviousMonthEndingBalance(accountNumber);

        body.put("message_code", 200);
        body.put("message", "OK");
        body.put("Opening_Balance", openingBalance);
        body.put("transactions", transactionModels);
        return new ResponseEntity<>(body, HttpStatus.OK);
      }
    }
  }
}
