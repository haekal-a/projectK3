package com.example.basicauth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Reza Pahlevie on 25/08/2019.
 */

@RestController
// secara default spring boot melarang transaksi antar domain, maka cross origin ini memberikan izin kepada domain diluar untuk
//melakukan transaksi data
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @GetMapping(value = "/basicauth")
    public AuthModel authenticate() {
        return new AuthModel("You Are Good to Go!", "Authentication");
    }


}
