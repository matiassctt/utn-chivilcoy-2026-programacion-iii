package org.example.demoapp.service.user;

import org.example.demoapp.model.user.User;
import org.example.demoapp.repository.user.JpaUserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserDeleterService {
    private final JpaUserRepository jpaUserRepository;
    private final UserFinderService userFinderService;

    public UserDeleterService(
            JpaUserRepository jpaUserRepository,
            UserFinderService userFinderService
    ) {
        this.jpaUserRepository = jpaUserRepository;
        this.userFinderService = userFinderService;
    }

    public void delete(Long id) {
        User user = userFinderService.find(id);
        jpaUserRepository.delete(user);
    }
}
