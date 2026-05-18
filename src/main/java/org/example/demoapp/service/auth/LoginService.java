package org.example.demoapp.service.auth;

import org.example.demoapp.dto.request.auth.LoginRequest;
import org.example.demoapp.dto.response.auth.LoginResponse;
import org.example.demoapp.exception.auth.WrongPasswordException;
import org.example.demoapp.exception.user.UserNotFoundByEmailException;
import org.example.demoapp.model.user.User;
import org.example.demoapp.repository.user.JpaUserRepository;
import org.example.demoapp.service.jwt.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final JpaUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public LoginService(
            JpaUserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UserNotFoundByEmailException(request.getEmail()));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new WrongPasswordException();
        }

        String token = jwtService.generateToken(user.getEmail());
        return new LoginResponse(token);
    }
}