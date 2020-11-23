package com.personal.bebankaccount.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface User_LoginMapper {

  @Select("SELECT Hashed_PIN FROM user_login WHERE User_ID=#{userID}")
  String selectHashed_PIN(String userID);

  @Select("SELECT EXISTS(SELECT 1 FROM user_login WHERE User_ID=#{userID})")
  boolean exists(String userID);

  @Insert("INSERT INTO user_login (User_ID, Hashed_PIN) VALUES (#{userID}, #{hashedPIN})")
  int insert(String userID, String hashedPIN);
}
