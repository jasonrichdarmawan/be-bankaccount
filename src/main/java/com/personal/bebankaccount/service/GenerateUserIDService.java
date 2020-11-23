package com.personal.bebankaccount.service;

import com.personal.bebankaccount.mapper.User_LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class GenerateUserIDService {

  @Autowired
  User_LoginMapper userLoginMapper;

  public String generate(String fullName, LocalDate birthDate) {
    fullName = fullName.toLowerCase().replaceAll("[\\s]", "");

    StringBuilder userID = new StringBuilder(fullName.substring(0, 8) + DateTimeFormatter.ofPattern("ddMM").format(birthDate));

    int index = 7;
    char ch = 'a';
    while (userLoginMapper.exists(userID.toString())) {
      if (ch > 'z') {
        ch = 'a';
        --index;
      }
      userID.setCharAt(index, ch);
      ++ch;
    }

    return userID.toString();
  }
}
