package com.personal.bebankaccount.controller;

import com.personal.bebankaccount.model.RegisterModel;
import com.personal.bebankaccount.service.GenerateUserIDService;
import com.personal.bebankaccount.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RegisterController {

  @Autowired
  GenerateUserIDService generateUserIDService;

  @Autowired
  RegisterService registerService;

  @PostMapping("api/v1/register")
  public ResponseEntity<?> register(@Valid @RequestBody RegisterModel registerModel) {

    String userID = generateUserIDService.generate(registerModel.getFullName(), registerModel.getBirthDate());

    if (userID == null) {
      Map<String, Object> body = new HashMap<>();
      body.put("message_code", 500);
      body.put("message", "Internal Server Error");
      return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    } else {
      Map<String, Object> result = registerService.insert(registerModel, userID);
      return ResponseEntity.status((int) result.get("message_code")).body(result);
    }
  }
}
