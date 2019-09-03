package com.example.demo.jwt.resource;

import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;

public class JwtTokenResponse implements Serializable {

  private static final long serialVersionUID = 8317676219297719109L;

  private final String token;
  private final UserDetails userDetails;

    public JwtTokenResponse(String token, UserDetails userDetails) {
        this.token = token;
        this.userDetails = userDetails;
    }

    public String getToken() {
        return this.token;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }
}
