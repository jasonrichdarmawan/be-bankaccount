package com.personal.bebankaccount.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface User_LoginMapper {

  @Select("SELECT Hashed_PIN FROM user_login WHERE User_ID=#{userID}")
  String getHashedPIN(String userID);

}
