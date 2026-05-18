package org.example.demoapp.controller.auth;

import org.example.demoapp.dto.request.auth.LoginRequest;
import org.example.demoapp.dto.response.auth.LoginResponse;
import org.example.demoapp.service.auth.LoginService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return loginService.login(request);
    }
}