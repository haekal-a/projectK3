package com.example.demo.controller;

import com.example.basicauth.AuthModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Reza Pahlevie on 25/08/2019.
 */

@RestController
// secara default spring boot melarang transaksi antar domain, maka cross origin ini memberikan izin kepada domain diluar untuk
//melakukan transaksi data
@CrossOrigin(origins = "http://localhost:4200")
public class HelloWorldController {

    @GetMapping(value = "/hello-world")
    public String helloWorld (){
        return "Hello World";
    }

    @GetMapping(value = "/hello-world/{name}")
    public String helloWorldName (@PathVariable String name){
        return "Hai, " + name + ". You are handsome";
    }

    @GetMapping(value = "/hello-world-class")
    public AuthModel helloWorldClass (){
        // untuk bisa return class, maka class tersebut harus memilik getters untuk setiap variablenya
        return new AuthModel("This is a new spring web service", "Hello World");

        //contoh exception
//        throw new RuntimeException("This is an error");
    }

//    @GetMapping(value = "/getpegawai/{nip}")
//    private static void getEmployeeById(@PathVariable String nip)
//    {
//        final String uri = "http://localhost:8181/employees/{nip}";
//
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("nip", nip);
//        params.put("nip", "199212272014111002");
//
//        RestTemplate restTemplate = new RestTemplate();
//        TbPegawai result = restTemplate.getForObject(uri, TbPegawai.class, params);
//
//        System.out.println(result);
//    }

}
