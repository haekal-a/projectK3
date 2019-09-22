package com.example.demo.controller;


import com.example.demo.model.CommonResponseModel;
import com.example.demo.model.PeminjamanOutputModel;
import com.example.demo.model.PengembalianInputModel;
import com.example.demo.service.PengembalianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "return")
public class PengembalianController {

    private PengembalianService pengembalianService;

    @Autowired
    public PengembalianController(PengembalianService pengembalianService) {
        this.pengembalianService = pengembalianService;
    }

    @GetMapping(value = "get")
    public ResponseEntity<CommonResponseModel> getDaftarDisetujui() {
        CommonResponseModel crm = new CommonResponseModel();
        try {
            // Daftar disetujui = getDaftarDisetujui where status peminjaman = 1
            List<PeminjamanOutputModel> poms = pengembalianService.getListPinjamBarangStatusPeminjaman("1");
            crm.setTitle("Get list approved");
            if (poms.size() > 0) {
                crm.setCode("1");
                crm.setMessage("Data ditemukan");
                crm.setData(poms);
                crm.setTotalData((long) poms.size());
            } else {
                crm.setCode("0");
                crm.setMessage("Data tidak ditemukan");
            }

            return ResponseEntity.ok(crm);

        } catch (Exception e) {
            return new ResponseEntity<>(new CommonResponseModel("Get list approved", "0", e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ResponseEntity<CommonResponseModel> savePengembalian(@RequestBody PengembalianInputModel pim) {
        try {
            pengembalianService.savePengembalian(pim);
            return ResponseEntity.ok(new CommonResponseModel("Save Pengembalian", "1", "Data Pengembalian berhasil disimpan"));
        } catch (EntityNotFoundException nfe) {
            return ResponseEntity.ok(new CommonResponseModel("Save Pengembalian", "0", nfe.getMessage()));
        } catch (Exception e) {
            return new ResponseEntity<>(new CommonResponseModel("Save Pengembalian", "0", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
