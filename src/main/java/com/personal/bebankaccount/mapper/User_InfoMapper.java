package com.personal.bebankaccount.mapper;

import com.personal.bebankaccount.model.User_InfoModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface User_InfoMapper {
  @Select("SELECT Account_Number, Full_Name, ISO_4217 FROM user_info WHERE User_ID=#{userID}")
  User_InfoModel selectByUser_ID(String userID);

  @Select("SELECT Full_Name FROM user_info WHERE Account_Number=#{accountNumber}")
  String selectByAccount_Number(String accountNumber);
}
