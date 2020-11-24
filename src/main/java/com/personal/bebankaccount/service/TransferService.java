package com.personal.bebankaccount.service;

import com.personal.bebankaccount.mapper.StatementsMapper;
import com.personal.bebankaccount.mapper.TransactionsMapper;
import com.personal.bebankaccount.mapper.User_InfoMapper;
import com.personal.bebankaccount.model.TransferModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Service
public class TransferService {
  @Autowired
  StatementsMapper statementsMapper;

  @Autowired
  TransactionsMapper transactionsMapper;

  @Autowired
  User_InfoMapper userInfoMapper;

  public Map<String, Object> transfer(String source, TransferModel transferModel) {
    Map<String, Object> response = new HashMap<>();

    if (source.equals(transferModel.getDestination()) || !userInfoMapper.exists(transferModel.getDestination())) {
      response.put("message_code", 400);
      response.put("message", "Bad Request");
      return response;
    } else {
      if (transferModel.getTransactionValue().compareTo(BigDecimal.ZERO) == 0) {
        response.put("message_code", 402);
        response.put("message", "Payment Required");
        return response;
      } else {
        BigDecimal currentBalance = calculateCurrentBalance(source);
        if (currentBalance.compareTo(transferModel.getTransactionValue()) < 0) {
          response.put("message_code", 402);
          response.put("message", "Insufficient Funds");
          return response;
        } else {
          if (transactionsMapper.insert(transferModel, source) != 1) {
            response.put("message_code", 500);
            response.put("message", "Internal Server Error");
            return response;
          } else {
            response.put("message_code", 201);
            response.put("message", "CREATED");
            return response;
          }
        }
      }
    }
  }

  public BigDecimal selectPreviousMonthEndingBalance(String accountNumber) {
    LocalDate now = LocalDate.now();
    int previousMonth = now.getMonthValue() - 1;
    int year = now.getYear();
    if (previousMonth == 0) {
      previousMonth = 12;
      year -= 1;
    }

    BigDecimal previousMonthEndingBalance = statementsMapper.select(accountNumber, previousMonth, year);

    return previousMonthEndingBalance == null ? new BigDecimal(0) : previousMonthEndingBalance;
  }

  public BigDecimal calculateCurrentBalance(String accountNumber) {
    BigDecimal previousMonthEndingBalance = selectPreviousMonthEndingBalance(accountNumber);

    LocalDate now = LocalDate.now();
    LocalDate start = now.withDayOfMonth(1);
    LocalDate end = now.withDayOfMonth(now.lengthOfMonth());

    BigDecimal mutation = transactionsMapper.mutation(accountNumber, start, end);

    if (mutation == null) {
      return previousMonthEndingBalance;
    } else {
      return previousMonthEndingBalance.add(mutation);
    }
  }
}
