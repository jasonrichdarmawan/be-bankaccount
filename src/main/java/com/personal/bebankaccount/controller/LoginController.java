package com.personal.bebankaccount.controller;

import com.personal.bebankaccount.model.LoginModel;
import com.personal.bebankaccount.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@RestController
public class LoginController {

  @Autowired
  LoginService loginService;

  @PostMapping("api/v1/login")
  public ResponseEntity<?> login(@Valid @RequestBody LoginModel loginModel) {
    Map<String, Object> body = loginService.authenticate(loginModel);
    if ((int) body.get("message_code") != 200) {
      return new ResponseEntity<>(body, HttpStatus.valueOf((int) body.get("message_code")));
    } else {
      return ResponseEntity.ok().body(body);
    }
  }
}
