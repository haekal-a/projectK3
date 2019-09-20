package com.example.demo.controller;

import com.example.demo.model.CommonResponseModel;
import com.example.demo.model.MasterBmnOutputModel;
import com.example.demo.service.MasterBmnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MasterBmnController {

    private MasterBmnService masterBmnService;

    @Autowired
    public MasterBmnController (MasterBmnService masterBmnService){
        this.masterBmnService = masterBmnService;
    }

    @GetMapping(value = "barang/get")
    public ResponseEntity<CommonResponseModel> getBarangByKondisiAndStatus(){
        CommonResponseModel crm = new CommonResponseModel();
        try {
            List<MasterBmnOutputModel> mbom = masterBmnService.getBarangByKondisiAndStatus();
            crm.setTitle("Get Barang");
            if (mbom.size() > 0) {
                crm.setCode("1");
                crm.setMessage("Data Barang ditemukan di SIMAK BMN");
                crm.setData(mbom);
            } else {
                crm.setCode("0");
                crm.setMessage("Data Barang tidak ditemukan di SIMAK BMN");
            }
            return ResponseEntity.ok(crm);
        } catch (Exception e){
            return new ResponseEntity<>(new CommonResponseModel("Get Barang", "0", e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
