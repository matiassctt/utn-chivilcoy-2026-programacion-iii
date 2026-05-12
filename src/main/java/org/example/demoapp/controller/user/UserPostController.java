package org.example.demoapp.controller.user;

import jakarta.validation.Valid;
import org.example.demoapp.dto.request.user.UserRequest;
import org.example.demoapp.dto.response.user.UserResponse;
import org.example.demoapp.model.user.User;
import org.example.demoapp.service.user.UserCreatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
public class UserPostController {
    private final UserCreatorService userCreatorService;

    public UserPostController(UserCreatorService userCreatorService) {
        this.userCreatorService = userCreatorService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(
            @Valid @RequestBody UserRequest userRequest
    ) {
        User user =  userCreatorService.create(userRequest);

        UserResponse userResponse = UserResponse.fromEntity(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }
}
