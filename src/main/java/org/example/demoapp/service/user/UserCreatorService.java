package org.example.demoapp.service.user;

import org.example.demoapp.dto.request.user.UserRequest;
import org.example.demoapp.model.user.User;
import org.example.demoapp.repository.user.JpaUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserCreatorService {
    private final JpaUserRepository jpaUserRepository;
    private final PasswordEncoder passwordEncoder;

    public UserCreatorService(
            JpaUserRepository jpaUserRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.jpaUserRepository = jpaUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User create(UserRequest request) {
        User user = User.fromRequest(request);

        user.setPassword(passwordEncoder.encode(request.getPassword()));

        return jpaUserRepository.save(user);
    }
}
