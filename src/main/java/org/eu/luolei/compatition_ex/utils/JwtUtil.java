package org.eu.luolei.compatition_ex.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;

import java.util.Date;
import java.util.Map;

public class JwtUtil {

    private static final String secret = "123456";

    public static String genUserToken(Integer userId, String username) {
        return JWT.create()
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 12))
                .withClaim("username", username)
                .withClaim("userId", userId)
                .sign(Algorithm.HMAC256(secret));
    }

    public static Integer parseToken(String token) {
        return JWT.require(Algorithm.HMAC256(secret)).build()
                .verify(token)
                .getClaim("userId")
                .asInt();
    }
}
