package com.personal.bebankaccount.mapper;

import com.personal.bebankaccount.model.TransactionModel;
import com.personal.bebankaccount.model.TransferModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Mapper
public interface TransactionsMapper {

  @Select("SELECT\n" +
          "(SELECT sum(Transaction_Value) FROM transactions WHERE DATE BETWEEN #{start} AND #{end} AND Destination=#{accountNumber})\n" +
          "-\n" +
          "(SELECT sum(Transaction_Value) FROM transactions WHERE DATE BETWEEN #{start} AND #{end} AND Source=#{accountNumber});")
  BigDecimal mutation(String accountNumber, LocalDate start, LocalDate end);

  @Insert("INSERT INTO transactions (Date, Source, Destination, Destination_Type, Transaction_Value) VALUES (#{transferModel.Date}, #{source}, #{transferModel.destination}, #{transferModel.destinationType}, #{transferModel.transactionValue})")
  int insert(TransferModel transferModel, String source);

  @Select("SELECT Date, Source, Destination, Destination_Type, Transaction_Value FROM transactions" +
          "\nWHERE (Source=#{accountNumber} OR Destination=#{accountNumber}) AND" +
          "\nDATE BETWEEN #{start} AND #{end}" +
          "\nORDER BY ID ASC"
  )
  List<TransactionModel> select(String accountNumber, LocalDate start, LocalDate end);
}
