package com.personal.bebankaccount.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;

@Mapper
public interface User_DetailMapper {

  @Insert("INSERT INTO user_detail (Account_Number, Birth_Date, Address_3, Address_4, Address_1, Address_2, Zip_Code, ISO_3166_1) VALUES (#{accountNumber}, #{birthDate}, #{address3}, #{address4}, #{address1}, #{address2}, #{zipCode}, #{iso31661})")
  int insert(String accountNumber, LocalDate birthDate, String address3, String address4, String address1, String address2, int zipCode, int iso31661);
}
