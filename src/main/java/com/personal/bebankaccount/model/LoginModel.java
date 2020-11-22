package com.personal.bebankaccount.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Size;

@SuppressWarnings("unused")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginModel {
  @JsonProperty("User_ID")
  @Size(min = 12, max = 12, message = "User_ID length must be 12")
  private String User_ID;

  @JsonProperty("PIN")
  @Size(min = 6, max = 6, message = "PIN length must be 6")
  private String PIN;

  public String getUser_ID() {
    return User_ID;
  }

  public String getPIN() {
    return PIN;
  }
}
