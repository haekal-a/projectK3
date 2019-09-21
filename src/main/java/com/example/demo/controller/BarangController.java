package com.example.demo.controller;

import com.example.demo.model.CommonResponseModel;
import com.example.demo.model.BarangOutputModel;
import com.example.demo.service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "barang")
public class BarangController {

    private BarangService barangService;

    @Autowired
    public BarangController (BarangService barangService){
        this.barangService = barangService;
    }

    @GetMapping(value = "get")
    public ResponseEntity<CommonResponseModel> getDaftarBarangTersedia(){
        CommonResponseModel crm = new CommonResponseModel();
        try {
            // DaftarBarangTersedia = getMasterBmn where kondisi = 0 (baik) and status = 1 (tersedia)
            List<BarangOutputModel> mbom = barangService.getBarangByKondisiAndStatus("0","1");
            crm.setTitle("Get Barang");
            if (mbom.size() > 0) {
                crm.setCode("1");
                crm.setMessage("Data Barang ditemukan di SIMAK BMN");
                crm.setData(mbom);
                crm.setTotalData((long) mbom.size());
            } else {
                crm.setCode("0");
                crm.setMessage("Data Barang tidak ditemukan di SIMAK BMN");
            }
            return ResponseEntity.ok(crm);
        } catch (Exception e){
            return new ResponseEntity<>(new CommonResponseModel("Get Barang", "0", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
