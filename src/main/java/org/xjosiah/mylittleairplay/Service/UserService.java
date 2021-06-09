package org.xjosiah.mylittleairplay.Service;

import org.xjosiah.mylittleairplay.mybatis.entity.User;

public interface UserService {

    boolean register(String key, String uuid);

    User login(String key);
}
