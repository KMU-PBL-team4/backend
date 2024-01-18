package com.example.kmupbl3.service.user;

import com.example.kmupbl3.domain.User;
import com.example.kmupbl3.dto.UserInfoDTO;
import com.example.kmupbl3.repository.user.SpringDataJpaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final SpringDataJpaUserRepository jpaUserRepository;

    @Override
    public User join(User user) {
        User save;
        try {
            save = jpaUserRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            return null; // ex: duplicated username
        }
        return save;
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


}
