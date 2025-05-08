package com.app.design.demo.controller;


import com.app.design.demo.model.WxLoginRequest;
import com.app.design.demo.utils.JwtUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class LoginController {

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody WxLoginRequest request) {
        String code = request.getUser();

        // 1. 用 code 调用微信接口获取 openid（略）
        String openid = "wx_openid_abc123"; // 示例
        Long userId = 123L; // 假设你查数据库或创建用户得到的

        // 2. 生成 token
        String token = JwtUtils.generateToken(userId, openid);

        // 3. 返回结果
        Map<String, Object> user = new HashMap<>();
        user.put("id", userId);
        user.put("openid", openid);

        Map<String, Object> result = new HashMap<>();
        result.put("token", token);
        result.put("user", user);

        return result;
    }
}
