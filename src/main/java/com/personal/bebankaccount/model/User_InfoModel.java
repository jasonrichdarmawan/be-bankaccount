package com.personal.bebankaccount.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@SuppressWarnings("unused")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User_InfoModel {
  private Integer ID;
  private String User_ID;
  private String Account_Number;
  private String Full_Name;
  private Integer ISO_4217;

  public Integer getID() {
    return ID;
  }

  public String getUser_ID() {
    return User_ID;
  }

  public String getAccount_Number() {
    return Account_Number;
  }

  public String getFull_Name() {
    return Full_Name;
  }

  public Integer getISO_4217() {
    return ISO_4217;
  }
}
