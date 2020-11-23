package com.personal.bebankaccount.model;

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

  public LocalDate getDate() {
    return Date;
  }

  public String getSource() {
    return Source;
  }

  public String getDestination() {
    return Destination;
  }

  public int getDestination_Type() {
    return Destination_Type;
  }

  public BigDecimal getTransaction_Value() {
    return Transaction_Value;
  }
}
