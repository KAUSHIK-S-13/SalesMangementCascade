package com.sales.management.Util;


import com.sales.management.Model.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

public class JwtUtil {
    public static String generateToken(String signinKey, Integer userId, String subject, String userName, List<Role> authorities) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        JwtBuilder builder = Jwts.builder().setSubject(subject).claim("userId", userId)
                .claim("Authorities", authorities)
                .claim("userName", userName).setIssuedAt(now)
                .signWith(SignatureAlgorithm.HS256, "secret");

        return builder.compact();
    }

    public static String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");

        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer")) {
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }

    public boolean validateToken(String authToken,String signingKey) {
        try {
            Jwts.parser().setSigningKey("secret").parseClaimsJws(authToken);

            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getUserNameFromJWTs(String token, String signingKey) {
        Claims claims = Jwts.parser().setSigningKey("secret").parseClaimsJws(token).getBody();
        return String.valueOf(claims.get("userName"));
    }


}