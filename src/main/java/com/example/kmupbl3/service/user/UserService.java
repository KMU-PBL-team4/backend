package com.example.kmupbl3.service.user;

import com.example.kmupbl3.AdSearchCond;
import com.example.kmupbl3.domain.User;
import com.example.kmupbl3.dto.AdUpdateDTO;
import com.example.kmupbl3.dto.UserInfoDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User join(User user);

    Optional<User> findById(Integer id);
    Optional<User> findByUsername(String username);

    UserInfoDTO findUserInfoByUsername(String username);
    UserInfoDTO findUserInfo(Integer id);

    boolean remove(Integer id);

    List<AdUpdateDTO> selectAdForUser(Integer userId, AdSearchCond cond);


}
