package com.marino.demobank.services;

import com.marino.demobank.domain.User;
import com.marino.demobank.entities.UserEntity;
import com.marino.demobank.interfaces.UserInterface;
import com.marino.demobank.mapper.UserMapper;
import com.marino.demobank.mapper.UserMapperImpl;
import com.marino.demobank.repositories.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceAdapter implements UserInterface {
    @Autowired
    private UserEntityRepository userEntityRepository;
    private UserMapper mapper = new UserMapperImpl();

    @Override
    public User createUser(User newUser) {
        UserEntity newUserEntity = mapper.userToUserEntity(newUser);
        UserEntity result = userEntityRepository.save(newUserEntity);
        User resultDomain = mapper.userEntityToUser(result);
        return resultDomain;
    }
}
