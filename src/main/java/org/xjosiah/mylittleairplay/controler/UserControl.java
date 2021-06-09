package org.xjosiah.mylittleairplay.controler;

import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xjosiah.mylittleairplay.Service.UserService;
import org.xjosiah.mylittleairplay.mybatis.entity.User;

import java.util.Objects;

@Controller
@CrossOrigin
@RequestMapping("/user")
public class UserControl {
    @Autowired
    UserService userService;

    @GetMapping("/register")
    public ResponseEntity<String> register() {
        String uuid = IdUtil.simpleUUID();
        String key = uuid.substring(0, 5);
        while (!userService.register(key, uuid)) {
            uuid = IdUtil.simpleUUID();
            key = uuid.substring(0, 5);
        }
        User newUser = new User(key, uuid);
        return ResponseEntity.ok(JSONUtil.toJsonStr(newUser));
    }

    @GetMapping("/login/{key}")
    public ResponseEntity<String> login(@PathVariable String key){
        User user = userService.login(key);
        return ResponseEntity.ok(JSONUtil.toJsonStr(Objects.requireNonNullElse(user, "登录失败！请重新校验KEY")));
    }

}
