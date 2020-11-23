package com.personal.bebankaccount.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * JsonProperty is used to change the attribute name for ResponseEntity.
 */
public class TransactionModel {
  private LocalDate Date;
  private String Source;
  private String Destination;
  private int Destination_Type;
  private BigDecimal Transaction_Value;

  @JsonProperty("Date")
  public LocalDate getDate() {
    return Date;
  }

  @JsonProperty("Source")
  public String getSource() {
    return Source;
  }

  @JsonProperty("Destination")
  public String getDestination() {
    return Destination;
  }

  @JsonProperty("Destination_Type")
  public int getDestination_Type() {
    return Destination_Type;
  }

  public BigDecimal getTransaction_Value() {
    return Transaction_Value;
  }
}
