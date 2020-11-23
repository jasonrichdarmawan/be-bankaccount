package com.personal.bebankaccount.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class AdminTransactionModel {

  private final LocalDate Date = LocalDate.now();

  @JsonProperty("Destination")
  @NotNull(message = "Destination must not be null")
  @Pattern(regexp = "[0-9]{17}", message = "Destination length must be 17")
  private String destination;

  @JsonProperty("Transaction_Value")
  @NotNull(message = "Transaction_Value must not be null")
  @DecimalMin(value = "0.0", inclusive = false)
  @Digits(integer = 11, fraction = 0, message = "Transaction_Value maximum digits is 11 and no decimal")
  private BigDecimal transactionValue;

  public LocalDate getDate() {
    return Date;
  }

  public String getDestination() {
    return destination;
  }

  public BigDecimal getTransactionValue() {
    return transactionValue;
  }
}
