package com.personal.bebankaccount.mapper;

import com.personal.bebankaccount.model.Transactions_ProgressModel;
import org.apache.ibatis.annotations.*;

@Mapper
public interface Transactions_ProgressMapper {

  @Select("SELECT Message_Code FROM transactions_progress WHERE Progress_ID=#{progressID} AND Account_Number=#{accountNumber}")
  Integer selectMessage_Code(String progressID, String accountNumber);

  @SelectKey(before = true, keyProperty = "Progress_ID", resultType = String.class, statement = "SELECT UUID_SHORT()")
  @Insert("INSERT INTO transactions_progress (Progress_ID, Account_Number, Message_Code) VALUES (#{Progress_ID}, #{Account_Number}, #{Message_Code})")
  int insertSelectKeyProgress_ID(Transactions_ProgressModel transactionsProgressModel);

  @Update("UPDATE transactions_progress SET Message_Code=#{messageCode} WHERE Progress_ID=#{progressID}")
  int updateMessage_Code(int messageCode, String progressID);
}
