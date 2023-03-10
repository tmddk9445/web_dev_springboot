package com.example.vsc_springboot.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwatAuthenticationFilter extends OncePerRequestFilter{

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
      
        try {

          //? Request Header에 있는 Bearer Token을 가져옴


        } catch (Exception exception) {
          exception.printStackTrace();
        }
  }

  private String parseBearerToken(HttpServletRequest request) {
    //? Request Header의 Authorization 필드의 Value를 가져옴
    String authorizationValue = request.getHeader("Authorization");

    if (StringUtils.hasText(authorizationValue) && authorizationValue.startsWith("Bearer ")) 
      return authorizationValue.substring(7);

    return null;
  }
  
}
