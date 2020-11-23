package com.personal.bebankaccount.mapper;

import com.personal.bebankaccount.model.TransactionModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.time.LocalDate;

@Mapper
public interface TransactionsMapper {

  @Select("SELECT\n" +
          "(SELECT sum(Transaction_Value) FROM transactions WHERE DATE BETWEEN #{start} AND #{end} AND Destination=#{accountNumber})\n" +
          "-\n" +
          "(SELECT sum(Transaction_Value) FROM transactions WHERE DATE BETWEEN #{start} AND #{end} AND Source=#{accountNumber});")
  BigDecimal mutation(String accountNumber, LocalDate start, LocalDate end);

  @Insert("INSERT INTO transactions (Date, Source, Destination, Destination_Type, Transaction_Value) VALUES (#{transactionModel.Date}, #{source}, #{transactionModel.destination}, #{transactionModel.destinationType}, #{transactionModel.transactionValue})")
  int insert(TransactionModel transactionModel, String source);
}
