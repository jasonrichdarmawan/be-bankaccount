package com.personal.bebankaccount.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@SuppressWarnings("unused")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginModel {
  @JsonProperty("User_ID")
  @Size(min = 12, max = 12, message = "User_ID length must be 12")
  private String userID;

  @JsonProperty("PIN")
  @NotNull(message = "PIN must not be null")
  @Pattern(regexp = "[0-9]{6}", message = "PIN length must be 6")
  private String pin;

  public String getUserID() {
    return userID;
  }

  public String getPIN() {
    return pin;
  }
}
