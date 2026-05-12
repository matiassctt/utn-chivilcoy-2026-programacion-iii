package org.example.demoapp.service.user;

import org.example.demoapp.dto.request.user.UserRequest;
import org.example.demoapp.model.user.User;
import org.example.demoapp.repository.user.JpaUserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserCreatorService {
    private final JpaUserRepository jpaUserRepository;

    public UserCreatorService(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    public User create(UserRequest request) {
        User user = User.fromRequest(request);
        return jpaUserRepository.save(user);
    }
}
