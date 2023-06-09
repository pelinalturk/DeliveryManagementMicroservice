package com.pelin.boxservice.client;

import com.pelin.boxservice.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "authentication-server", path = "/v1/user")
public interface AuthServerClient {

    @GetMapping("/getUserById/{userId}")
    ResponseEntity<UserDto> getUserById(@PathVariable String userId);

}