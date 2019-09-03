package com.example.demo.jwt.resource;

import java.io.Serializable;

public class JwtTokenRequest implements Serializable {

    private static final long serialVersionUID = -5616176897013108345L;

    private String username;
    private String password;

    /*{
        "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJpbjI4bWludXRlcyIsImV4cCI6MTU2Nzc4MDUxOCwiaWF0IjoxNTY3MTc1NzE4fQ.RRwBMOKjeppgwfF-ytFxaCnvn9HA46tA-Zu9mKvVTEDaQoGxK-_JUhJ4bQOGMqZSkE2CqSN_c7ychdoluZotMA"
    }*/

    public JwtTokenRequest() {
        super();
    }

    public JwtTokenRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
