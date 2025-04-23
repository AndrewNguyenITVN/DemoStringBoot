package com.example.demo.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component
public class JwtUtils {
    @Value("${jwt.privateKey}")
    private String privateKey;
    public String generateToken(String data){
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(privateKey));
        String jws = Jwts.builder().subject(data).signWith(key).compact();
        return jws;
    }

    public boolean verifyToken(String token){
        try{
            SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(privateKey));
//            System.out.println("Loaded JWT privateKey: " + privateKey);
//            System.out.println("Loaded JWT Key: " + key);
//            System.out.println("Loaded JWT Key: " + token);
            Jwts.parser()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch(Exception e){
            return false;
        }
    }
}
