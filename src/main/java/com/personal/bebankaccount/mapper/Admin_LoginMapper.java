package com.personal.bebankaccount.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface Admin_LoginMapper {

  @Select("SELECT EXISTS(SELECT 1 FROM admin_login WHERE User_ID=#{userID})")
  boolean selectByUser_ID(String userID);
}
