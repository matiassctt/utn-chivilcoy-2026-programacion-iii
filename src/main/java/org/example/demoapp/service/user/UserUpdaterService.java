package org.example.demoapp.service.user;

import org.example.demoapp.dto.request.user.UserRequest;
import org.example.demoapp.model.user.User;
import org.example.demoapp.repository.user.JpaUserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserUpdaterService {
    private final JpaUserRepository jpaUserRepository;
    private final UserFinderService userFinderService;

    public UserUpdaterService(
            JpaUserRepository jpaUserRepository,
            UserFinderService userFinderService
    ) {
        this.jpaUserRepository = jpaUserRepository;
        this.userFinderService = userFinderService;
    }

    public User update(UserRequest userRequest, Long id) {
        User user = userFinderService.find(id);

        user.setUserName(userRequest.getUserName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setDni(userRequest.getDni());

        return jpaUserRepository.save(user);
    }
}
