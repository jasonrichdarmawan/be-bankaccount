package com.personal.bebankaccount.controller.admin;

import com.personal.bebankaccount.mapper.Admin_LoginMapper;
import com.personal.bebankaccount.model.LoginModel;
import com.personal.bebankaccount.service.LoginService;
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
public class AdminLoginController {

  @Autowired
  LoginService loginService;

  @Autowired
  Admin_LoginMapper adminLoginMapper;

  @PostMapping("api/v1/admin/login")
  public ResponseEntity<?> login(@Valid @RequestBody LoginModel loginModel) {
    boolean userIDisAdmin = adminLoginMapper.exists(loginModel.getUserID());

    if (!userIDisAdmin) {
      Map<String, Object> body = new HashMap<>();
      body.put("message_code", 404);
      body.put("message", "NOT FOUND");
      return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    } else {
      Map<String, Object> body = loginService.authenticate(loginModel);
      if ((int) body.get("message_code") != 200) {
        return new ResponseEntity<>(body, HttpStatus.valueOf((int) body.get("message_code")));
      } else {
        return ResponseEntity.ok().body(body);
      }
    }
  }
}
