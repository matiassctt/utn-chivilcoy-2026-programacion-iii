package org.example.demoapp.service.user;

import org.example.demoapp.model.user.User;
import org.example.demoapp.repository.user.JpaUserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UsersSearcherService {
    private final JpaUserRepository jpaUserRepository;

    public UsersSearcherService(
            JpaUserRepository jpaUserRepository
    ) {
        this.jpaUserRepository = jpaUserRepository;
    }

    public Page<User> findAll(Pageable pageable) {
        return jpaUserRepository.findAll(pageable);
    }
}
