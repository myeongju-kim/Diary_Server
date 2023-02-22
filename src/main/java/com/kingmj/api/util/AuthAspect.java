package com.kingmj.api.util;

import com.kingmj.api.common.code.ServerCode;
import com.kingmj.api.common.exception.UnauthorizedException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class AuthAspect {
    @Value("${jwt.token.secret}")
    private String secretKey;
    private final HttpServletRequest servletRequest;
    public AuthAspect(HttpServletRequest servletRequest){
        this.servletRequest=servletRequest;
    }
    @Before("@annotation(com.kingmj.api.util.Auth)")
    public void inspectToken(JoinPoint joinPoint){
        try {
            Jwts.parser().setSigningKey(secretKey)
                    .parseClaimsJws(servletRequest.getHeader("Authorization"));
        } catch (ExpiredJwtException e){
            throw new UnauthorizedException(ServerCode.EXPIRE_TOKEN);
        } catch (Exception e){
            throw new UnauthorizedException(ServerCode.INVALID_TOKEN);
        }
    }
}
