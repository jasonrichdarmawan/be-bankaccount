package com.personal.bebankaccount.model;

public class Transactions_ProgressModel {
  private String Progress_ID;
  private String Account_Number;
  private String Message_Code;

  public Transactions_ProgressModel(String account_number, String message_code) {
    Account_Number = account_number;
    Message_Code = message_code;
  }

  public String getProgress_ID() {
    return Progress_ID;
  }

  public String getAccount_Number() {
    return Account_Number;
  }

  public String getMessage_Code() {
    return Message_Code;
  }
}
