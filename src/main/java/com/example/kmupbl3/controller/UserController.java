package com.example.kmupbl3.controller;

import com.example.kmupbl3.domain.User;
import com.example.kmupbl3.dto.UserCreateForm;
import com.example.kmupbl3.dto.UserInfoDTO;
import com.example.kmupbl3.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.example.kmupbl3.tool.JsonTool.ApiResponseJsonMapper;
import static com.example.kmupbl3.tool.JsonTool.UserInfoJsonMapper;

@RestController
@Slf4j
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public String register(@Validated @RequestBody UserCreateForm form) {
        log.info("API Call [POST] - /users");

        User user = UserCreateForm.build(form);
        User result = userService.join(user);

        if (result != null) {
            log.info("Successfully added user. Id: {}", result.getId());
            return ApiResponseJsonMapper(0, null, result.getId());
        } else {
            log.warn("Failed to add user: {Age: {}, Gender: {}}", form.getAge(), form.getGender());
            return ApiResponseJsonMapper(1, "Failed to add user.", null);
        }
    }

    @GetMapping("/{id}") //todo hashtag
    public String getUserInfo(@PathVariable(name = "id") Integer id) {
        UserInfoDTO userInfo = userService.findUserInfo(id);

        if (userInfo != null) {
            log.info("Successfully found user. Id: {}", id);
            return UserInfoJsonMapper(0, null, userInfo);
        } else {
            log.warn("Failed to find user. Id: {}", id);
            return UserInfoJsonMapper(1, "User not found.", null);
        }

    }

    @DeleteMapping("/{id}")
    public String removeUser(@PathVariable(name = "id") Integer id) {
        boolean isSuccess = userService.remove(id);
        if (isSuccess) {
            log.info("Successfully removed user. Id: {}", id);
            return ApiResponseJsonMapper(0, null, id);
        } else {
            log.warn("Failed to find user. Id: {}", id);
            return ApiResponseJsonMapper(1, "User not found.", null);
        }
    }
}
