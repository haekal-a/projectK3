package com.example.demo.controller;

import com.example.demo.model.CommonResponseModel;
import com.example.demo.model.PeminjamanInputModel;
import com.example.demo.model.PeminjamanOutputModel;
import com.example.demo.service.PeminjamanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PeminjamanController {

    private PeminjamanService peminjamanService;

    @Autowired
    public PeminjamanController (PeminjamanService peminjamanService){
        this.peminjamanService = peminjamanService;
    }

    @RequestMapping(value = "pinjam/save", method = RequestMethod.POST)
    public ResponseEntity<CommonResponseModel> savePeminjaman (@RequestBody PeminjamanInputModel pim){
        CommonResponseModel crm = new CommonResponseModel();
        crm.setTitle("Save peminjaman");
        try {
            peminjamanService.savePeminjaman(pim);
            crm.setCode("1");
            crm.setMessage("Data berhasil disimpan");
            return ResponseEntity.ok(crm);
        } catch (Exception e){
            crm.setCode("0");
            crm.setMessage(e.getMessage());
            return new ResponseEntity<>(crm, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "pinjam/get/{id}")
    public ResponseEntity<CommonResponseModel> cekPegawai(@PathVariable BigDecimal id) {
        CommonResponseModel crm = new CommonResponseModel();
        try {
            PeminjamanOutputModel pom = peminjamanService.getPeminjaman(id);
            crm.setTitle("Get Peminjaman");
            if (pom.getNip() != null) {
                crm.setCode("1");
                crm.setMessage("Data ditemukan");
                crm.setData(pom);
            } else {
                crm.setCode("0");
                crm.setMessage("Data tidak ditemukan");
            }

            return ResponseEntity.ok(crm);

        } catch (Exception e) {
            return new ResponseEntity<>(new CommonResponseModel("Get Peminjaman", "0", e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
