package com.personal.bebankaccount.mapper;

import com.personal.bebankaccount.model.User_InfoModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

@Mapper
public interface User_InfoMapper {
  @Select("SELECT Account_Number, Full_Name, ISO_4217 FROM user_info WHERE User_ID=#{userID}")
  User_InfoModel selectAccount_NumberFull_NameISO_4217(String userID);

  @Select("SELECT Full_Name FROM user_info WHERE Account_Number=#{accountNumber}")
  String selectFull_Name(String accountNumber);

  @SelectKey(statement = "SELECT UUID_SHORT()", keyProperty = "Account_Number", resultType = String.class, before = true)
  @Insert("INSERT INTO user_info (User_ID, Account_Number, Full_Name, ISO_4217) VALUES (#{User_ID}, #{Account_Number}, #{Full_Name}, #{ISO_4217})")
  int insertSelectKeyAccount_Number(User_InfoModel user_infoModel);
}
