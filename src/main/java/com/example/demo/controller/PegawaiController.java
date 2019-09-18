package com.example.demo.controller;

import com.example.demo.model.CommonResponseModel;
import com.example.demo.model.PegawaiOutputModel;
import com.example.demo.service.PegawaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PegawaiController {

    private PegawaiService pegawaiService;

    @Autowired
    public PegawaiController(PegawaiService pegawaiService) {
        this.pegawaiService = pegawaiService;
    }

    @GetMapping(value = "pegawai/get/{nip}")
    public ResponseEntity<CommonResponseModel> cekPegawai(@PathVariable String nip) {
        CommonResponseModel hasil = new CommonResponseModel();
        try {
            PegawaiOutputModel pegawai = pegawaiService.getDataPegawai(nip);
            hasil.setTitle("Get Pegawai");
            if (pegawai.getNip() != null) {
                hasil.setCode("1");
                hasil.setMessage("Data pegawai ditemukan disistem kepegawaian");
                hasil.setData(pegawai);
            } else {
                hasil.setCode("0");
                hasil.setMessage("Data pegawai tidak ditemukan disistem kepegawaian");
                hasil.setData(null);
            }

            return ResponseEntity.ok(hasil);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
