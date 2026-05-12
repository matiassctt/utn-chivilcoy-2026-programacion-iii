package org.example.demoapp.controller.user;

import org.example.demoapp.dto.response.user.UserResponse;
import org.example.demoapp.model.user.User;
import org.example.demoapp.service.user.UserFinderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
public class UserGetController {

    private final UserFinderService userFinderService;

    public UserGetController(UserFinderService userFinderService) {
        this.userFinderService = userFinderService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> find(@PathVariable Long id) {
       User user = userFinderService.find(id);

       UserResponse response = UserResponse.fromEntity(user);

       return ResponseEntity.ok(response);
    }
}
