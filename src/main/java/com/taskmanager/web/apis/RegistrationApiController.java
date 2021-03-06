package com.taskmanager.web.apis;

import com.taskmanager.domain.application.UserService;
import com.taskmanager.domain.model.user.EmailAddressExistsException;
import com.taskmanager.domain.model.user.RegistrationException;
import com.taskmanager.domain.model.user.UsernameExistsException;
import com.taskmanager.web.payload.RegistrationPayload;
import com.taskmanager.web.results.ApiResult;
import com.taskmanager.web.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
public class RegistrationApiController {

    private UserService service;

    @Autowired
    public RegistrationApiController(UserService service) {
        this.service = service;
    }

    @PostMapping("/api/registrations")
    public ResponseEntity<ApiResult> register(@Valid @RequestBody RegistrationPayload payload) {
        try {
            service.register(payload.toCommand());
            return Result.created();
        } catch (RegistrationException e) {
            String errorMessage = "Registration failed";
            if (e instanceof UsernameExistsException) {
                errorMessage = "Username already exists";
            } else if (e instanceof EmailAddressExistsException) {
                errorMessage = "Email address already exists";
            }
            return Result.failure(errorMessage);
        }
    }
}
