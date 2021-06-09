package org.xjosiah.mylittleairplay.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.xjosiah.mylittleairplay.mybatis.entity.User;

@Component
public interface UserMapper {
    boolean insertUser(@Param("key") String key, @Param("uuid") String uuid);

    User selUserByKey(@Param("key") String key);
}
