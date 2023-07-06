package com.moovda_project.moovda.oauth2_jwt.jwt;

import lombok.Getter;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.nio.charset.StandardCharsets;
import java.security.Key;

// JwtTokenizer 클래스를 Spring Container에 Bean으로 등록하기 위해 @Component 추가
@Component
public class JwtTokenizer {

    //jwt secretKey 정보
//    @Getter
//    @Value("${jwt.key.secret}")
//    private String secretKey;
//
//
//    //액세스 토큰 정보
//    @Getter
//    @Value("${jwt.access-token-expiration-minutes}")
//    private int accessTokenExpirationMinutes;
//
//    //리프레쉬 토큰 정보
//    @Getter
//    @Value("${jwt.refresh-token-expiration-minutes}")
//    private int refreshTokenExpirationMinutes;

    //Plain Text 형태의 secretKey의 byte를 Base64형식의 문자열로 인코딩해주는 메서드
    public String encodeBase64SecretKey(String secretKey) {
        return Encoders.BASE64.encode(secretKey.getBytes(StandardCharsets.UTF_8));
    }

    //인증된 사용자에게 JWT를 최초로 발급해 주는 메서드
    public String generateAccessToken(Map<String, Object> claims,
                                      String subject,
                                      Date expiration,
                                      String base64EncodedSecretKey) {
        Key key = getKeyFromBase64EncodedKey(base64EncodedSecretKey);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(Calendar.getInstance().getTime())
                .setExpiration(expiration)
                .signWith(key)
                .compact();
    }
    
    //Access Token이 만료 되었을 경우, Refesh 토큰을 생성하는 메서드
    public String generateRefreshToken(String subject, Date expiration, String base64EncodedSecretKey) {
        Key key = getKeyFromBase64EncodedKey(base64EncodedSecretKey);

        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(Calendar.getInstance().getTime())
                .setExpiration(expiration)
                .signWith(key)
                .compact();
    }

    // 검증 후, Claims을 반환 하는 용도
    public Jws<Claims> getClaims(String jws, String base64EncodedSecretKey) {
        Key key = getKeyFromBase64EncodedKey(base64EncodedSecretKey);

        Jws<Claims> claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(jws);
        return claims;
    }

    // 단순히 검증만 하는 용도로 쓰일 경우
    public void verifySignature(String jws, String base64EncodedSecretKey) {
        Key key = getKeyFromBase64EncodedKey(base64EncodedSecretKey);

        Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(jws);
    }

    // JWT의 만료 일시를 지정하기 위한 메서드
    public Date getTokenExpiration(int expirationMinutes) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, expirationMinutes);
        Date expiration = calendar.getTime();

        return expiration;
    }

    //JWT의 서명에 사용할 secret Key 생성해주는 메서드
    private Key getKeyFromBase64EncodedKey(String base64EncodedSecretKey) {
        byte[] keyBytes = Decoders.BASE64.decode(base64EncodedSecretKey);
        Key key = Keys.hmacShaKeyFor(keyBytes);

        return key;
    }
}
