package com.personal.bebankaccount.mapper;

import com.personal.bebankaccount.model.AdminTransactionModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Admin_TransactionsMapper {

  @Insert("INSERT INTO admin_transactions (Date, User_ID, Destination, Transaction_Value) VALUES (#{adminTransactionModel.Date}, #{userID}, #{adminTransactionModel.destination}, #{adminTransactionModel.transactionValue})")
  int insert(AdminTransactionModel adminTransactionModel, String userID);
}
