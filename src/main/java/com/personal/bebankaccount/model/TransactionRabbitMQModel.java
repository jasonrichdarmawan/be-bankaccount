package com.personal.bebankaccount.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class TransactionRabbitMQModel implements Serializable {
  private final LocalDate Date = LocalDate.now();
  private final String Source;
  private final String Destination;
  private final int Destination_Type;
  private final BigDecimal Transaction_Value;
  private final String Progress_ID;

  public TransactionRabbitMQModel(String source, String destination, int destination_Type, BigDecimal transaction_Value, String progress_ID) {
    Source = source;
    Destination = destination;
    Destination_Type = destination_Type;
    Transaction_Value = transaction_Value;
    Progress_ID = progress_ID;
  }

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

  public String getProgress_ID() {
    return Progress_ID;
  }
}
