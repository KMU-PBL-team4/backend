package com.example.kmupbl3.dto;

import com.example.kmupbl3.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateForm {

    @NotBlank
    private String username;

    @Positive @NotNull
    private Integer age;

    @Pattern(regexp = "^(male|female)$", message = "Gender must be 'male' or 'female'")
    private String gender;

    public static User build(UserCreateForm form) {
        return new User(form.getUsername(), form.getAge(), form.getGender());
    }
}
