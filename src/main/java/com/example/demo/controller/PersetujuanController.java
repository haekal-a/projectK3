package com.example.demo.controller;

import com.example.demo.model.CommonResponseModel;
import com.example.demo.model.PeminjamanOutputModel;
import com.example.demo.model.PersetujuanInputModel;
import com.example.demo.service.PersetujuanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "approval")
public class PersetujuanController {

    private PersetujuanService persetujuanService;

    @Autowired
    PersetujuanController(PersetujuanService persetujuanService) {
        this.persetujuanService = persetujuanService;
    }

    @GetMapping(value = "get")
    public ResponseEntity<CommonResponseModel> getDaftarPersetujuan() {
        CommonResponseModel crm = new CommonResponseModel();
        try {
            // Daftar Persetujuan = getDaftarPeminjaman where status peminjaman = 0 (Menunggu konfirmasi)
            List<PeminjamanOutputModel> poms = persetujuanService.getListPinjamBarangStatusPeminjaman("0");
            crm.setTitle("Get list approval");
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
            return new ResponseEntity<>(new CommonResponseModel("Get list approval", "0", e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "setuju/{id}", method = RequestMethod.POST)
    public ResponseEntity<CommonResponseModel> saveSetuju(@PathVariable String id) {
        try {
            persetujuanService.saveSetuju(new BigDecimal(id));
            return ResponseEntity.ok(new CommonResponseModel("Save approval", "1", "Data Peminjaman berhasil disetujui"));
        } catch (EntityNotFoundException nfe) {
            return ResponseEntity.ok(new CommonResponseModel("Save approval", "0", nfe.getMessage()));
        } catch (Exception e) {
            return new ResponseEntity<>(new CommonResponseModel("Save approval", "0", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "tolak", method = RequestMethod.POST)
    public ResponseEntity<CommonResponseModel> saveTolak(@RequestBody PersetujuanInputModel pim) {
        try {
            persetujuanService.saveTolak(pim.getIdPeminjaman(), pim.getAlasanPenolakan());
            return ResponseEntity.ok(new CommonResponseModel("Save approval", "1", "Data Peminjaman berhasil ditolak"));
        } catch (EntityNotFoundException nfe) {
            return ResponseEntity.ok(new CommonResponseModel("Save approval", "0", nfe.getMessage()));
        } catch (Exception e) {
            return new ResponseEntity<>(new CommonResponseModel("Save approval", "0", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
