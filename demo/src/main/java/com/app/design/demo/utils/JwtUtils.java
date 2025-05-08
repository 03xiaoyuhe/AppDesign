package com.app.design.demo.utils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtils {

    // 建议放在配置文件里
    private static final Key key = Keys.hmacShaKeyFor("your-secret-key-should-be-32-bytes!".getBytes());
    private static final long EXPIRATION = 7 * 24 * 60 * 60 * 1000; // 7天

    public static String generateToken(Long userId, String openid) {
        return Jwts.builder()
                .claim("uid", userId)
                .claim("openid", openid)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // 可选：解析 token 方法
    // ...
}
