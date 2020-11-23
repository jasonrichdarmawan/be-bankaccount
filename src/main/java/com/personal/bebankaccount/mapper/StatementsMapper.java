package com.personal.bebankaccount.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;

@Mapper
public interface StatementsMapper {

  @Select("SELECT Ending_Balance FROM statements WHERE Account_Number=#{accountNumber} AND Month=#{month} AND Year=#{year}")
  BigDecimal select(String accountNumber, int month, int year);
}
