package com.marino.demobank.services;

import com.marino.demobank.domain.User;
import com.marino.demobank.entities.UserEntity;
import com.marino.demobank.mapper.UserMapper;
import com.marino.demobank.repositories.UserEntityRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.util.Assert;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceAdapterTest {
    @InjectMocks
    private UserServiceAdapter userServiceAdapter;
    @Mock
    private UserEntityRepository userEntityRepository;

    @BeforeEach
    public void init() {
        // init mocks
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldCreateUser() {
        User expectedUser = User.builder()
                .firstName("Marino")
                .lastName("Vilchez")
                .email("myfreshnewemail@fake.com")
                .phone("555-1234567")
                .userStatus("DISABLED")
                .build();

        UserEntity userEntity = UserMapper.INSTANCE.userToUserEntity(expectedUser);

        when(userEntityRepository.save(any(UserEntity.class)))
                .thenReturn(userEntity);

        User newUser = userServiceAdapter.createUser(expectedUser);

        Assert.isTrue(newUser != null, "New user is null");
        Assert.isTrue(newUser.getFirstName().equals(expectedUser.getFirstName()), "First name is not the same");
        Assert.isTrue(newUser.getLastName().equals(expectedUser.getLastName()), "Last name is not the same");
        Assert.isTrue(newUser.getEmail().equals(expectedUser.getEmail()), "Email is not the same");
        Assert.isTrue(newUser.getPhone().equals(expectedUser.getPhone()), "Phone is not the same");
        Assert.isTrue(newUser.getUserStatus().equals(expectedUser.getUserStatus()), "User status is not the same");
    }
}
