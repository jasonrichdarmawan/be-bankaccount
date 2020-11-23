package com.personal.bebankaccount.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class RegisterModel {
  @JsonProperty("PIN")
  @NotNull(message = "PIN must not be null")
  @Pattern(regexp = "[0-9]{6}", message = "PIN length must be 6")
  private String pin;

  @JsonProperty("Full_Name")
  @NotNull(message = "Full_Name must not be null")
  @Pattern(regexp = "\\s*(?:[a-zA-Z]\\s*){8,35}$", message = "Full_Name length must be between 8 and 35")
  private String fullName;

  @JsonProperty("Birth_Date")
  @NotNull(message = "Birth_date must not be null")
  private LocalDate birthDate;

  @JsonProperty("ISO_4217")
  @NotNull(message = "ISO_4217 must not be null")
  private int iso4217;

  @JsonProperty("Address_3")
  @NotNull(message = "Address_3 must not be null")
  private String address3;

  @JsonProperty("Address_4")
  @NotNull(message = "Address_4 must not be null")
  private String address4;

  @JsonProperty("Address_1")
  @NotNull(message = "Address_1 must not be null")
  private String address1;

  @JsonProperty("Address_2")
  @NotNull(message = "Address_2 must not be null")
  private String address2;

  @JsonProperty("Zip_Code")
  @NotNull(message = "Zip_Code must not be null")
  private int zipCode;

  @JsonProperty("ISO_3166_1")
  @NotNull(message = "ISO_3166_1 must not be null")
  private int iso31661;

  public String getPIN() {
    return pin;
  }

  public String getFullName() {
    return fullName;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public int getISO4217() {
    return iso4217;
  }

  public String getAddress3() {
    return address3;
  }

  public String getAddress4() {
    return address4;
  }

  public String getAddress1() {
    return address1;
  }

  public String getAddress2() {
    return address2;
  }

  public int getZipCode() {
    return zipCode;
  }

  public int getISO31661() {
    return iso31661;
  }
}
