package org.example.demoapp.controller.user;

import jakarta.validation.Valid;
import org.example.demoapp.dto.request.user.UserRequest;
import org.example.demoapp.dto.response.user.UserResponse;
import org.example.demoapp.model.user.User;
import org.example.demoapp.service.user.UserUpdaterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
public class UserPutController {
    private final UserUpdaterService userUpdaterService;

    public UserPutController(
            UserUpdaterService userUpdaterService
    ) {
        this.userUpdaterService = userUpdaterService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody UserRequest request
    ) {
        User user = userUpdaterService.update(request, id);

        UserResponse response = UserResponse.fromEntity(user);

        return ResponseEntity.ok(response);
    }
}
