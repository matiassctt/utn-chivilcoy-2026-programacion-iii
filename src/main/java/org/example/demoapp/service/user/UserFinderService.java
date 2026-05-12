package org.example.demoapp.service.user;

import org.example.demoapp.exception.user.UserNotFoundException;
import org.example.demoapp.model.user.User;
import org.example.demoapp.repository.user.JpaUserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserFinderService {

    private final JpaUserRepository jpaUserRepository;

    public UserFinderService(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    public User find(Long id) {
        return jpaUserRepository.findById(id)
                .orElseThrow( () -> new UserNotFoundException(id));
    }
}
