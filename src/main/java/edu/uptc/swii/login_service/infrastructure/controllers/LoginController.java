package edu.uptc.swii.login_service.infrastructure.controllers;


import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.uptc.swii.login_service.domain.model.Login;
import edu.uptc.swii.login_service.domain.ports.in.LoginUseCase;

@RestController
@RequestMapping("/api/login")
public class LoginController {

private final LoginUseCase loginUseCase;

    public LoginController(LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
    }

    // Registro de usuario
@PostMapping("/register")
public ResponseEntity<String> register(@RequestBody Login loginRequest) {
    loginUseCase.register(loginRequest.getUserId(), loginRequest.getPassword());
    return ResponseEntity.ok("Usuario registrado exitosamente");
}

@PostMapping
public ResponseEntity<Map<String, String>> login(@RequestBody Login loginRequest) {
    String token = loginUseCase.login(loginRequest.getUserId(), loginRequest.getPassword());
    Map<String, String> response = new HashMap<>();
    response.put("token", token);
    return ResponseEntity.ok(response);
}
}