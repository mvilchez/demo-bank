package com.marino.demobank.mapper;

import com.marino.demobank.domain.User;
import com.marino.demobank.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Service
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mappings(
            @Mapping(source = "entity.status", target = "userStatus")
    )
    User userEntityToUser(UserEntity entity);

    List<User> mapToDomain(List<UserEntity> users);

    @Mappings(
            @Mapping(source = "domain.userStatus", target = "status")
    )
    UserEntity userToUserEntity(User domain);

    List<UserEntity> mapToEntity(List<User> users);
}
