package com.example.kmupbl3.service.user;

import com.example.kmupbl3.AdSearchCond;
import com.example.kmupbl3.domain.AD;
import com.example.kmupbl3.domain.User;
import com.example.kmupbl3.dto.AdUpdateDTO;
import com.example.kmupbl3.dto.UserInfoDTO;
import com.example.kmupbl3.repository.user.SpringDataJpaUserRepository;
import com.example.kmupbl3.service.ad.AdService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final SpringDataJpaUserRepository jpaUserRepository;
    private final AdService adService;

    @Override
    public User join(User user) {
        return jpaUserRepository.save(user);
    }

    @Override
    public Optional<User> findById(Integer id) {
        return jpaUserRepository.findById(id);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.ofNullable(jpaUserRepository.findByUsername(username));
    }

    @Override
    public UserInfoDTO findUserInfoByUsername(String username) {
        Optional<User> findUser = findByUsername(username);
        return findUser.map(user -> findUserInfo(user.getId())).orElse(null);
    }

    @Override
    public UserInfoDTO findUserInfo(Integer id) {
        Optional<User> findUser = findById(id);
        if (findUser.isPresent()) {
            User user = findUser.get();
            return new UserInfoDTO(user.getAge(), user.getGender());
        } else return null;
    }

    @Override
    public boolean remove(Integer id) {
        Optional<User> byId = findById(id);
        if (byId.isPresent()) {
            jpaUserRepository.delete(byId.get());
            return true;
        }
        return false;
    }

    @Override
    public List<AdUpdateDTO> selectAdForUser(Integer userId, AdSearchCond cond) {
        UserInfoDTO userInfo = findUserInfo(userId);
        List<AD> adList = adService.findAds(cond);

//        for (AD ad : adList) {
//
//        }

        // todo
        return null;

    }
}
