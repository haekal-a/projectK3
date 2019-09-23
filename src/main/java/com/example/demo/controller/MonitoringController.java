package com.example.demo.controller;

import com.example.demo.model.CommonResponseModel;
import com.example.demo.model.PeminjamanOutputModel;
import com.example.demo.service.MonitoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "monitoring")
public class MonitoringController {

    private MonitoringService monitoringService;

    @Autowired
    MonitoringController(MonitoringService monitoringService){
        this.monitoringService = monitoringService;
    }

    @GetMapping(value = "pinjam/get")
    public ResponseEntity<CommonResponseModel> getDaftarPeminjaman() {
        CommonResponseModel crm = new CommonResponseModel();
        try {
            // Daftar peminjaman = getDaftarPeminjaman where status peminjaman = 1
            List<PeminjamanOutputModel> poms = monitoringService.getListPinjamBarangByStatusPeminjaman("1");
            crm.setTitle("Get Peminjaman");
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
            return new ResponseEntity<>(new CommonResponseModel("Get Peminjaman", "0", e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "pinjam/get/{nip}")
    public ResponseEntity<CommonResponseModel> getDaftarPeminjamanByNip(@PathVariable String nip) {
        CommonResponseModel crm = new CommonResponseModel();
        try {
            // Daftar peminjaman = getDaftarPeminjamanByNip where status peminjaman = 1 and nip = ?
            List<PeminjamanOutputModel> poms = monitoringService.getListPinjamBarangByStatusPeminjamanAndNip(nip,"1");
            crm.setTitle("Get Peminjaman");
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
            return new ResponseEntity<>(new CommonResponseModel("Get Peminjaman", "0", e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "pinjam/history/get/{nip}")
    public ResponseEntity<CommonResponseModel> getDaftarRiwayatPeminjamanByNip(@PathVariable String nip) {
        CommonResponseModel crm = new CommonResponseModel();
        try {
            // Daftar peminjaman = getDaftarPeminjamanByNip where nip = ?
            List<PeminjamanOutputModel> poms = monitoringService.getDaftarRiwayatPeminjamanByNip(nip);
            crm.setTitle("Get history Peminjaman");
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
            return new ResponseEntity<>(new CommonResponseModel("Get history Peminjaman", "0", e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "barang/get/{jenisBarang}")
    public ResponseEntity<CommonResponseModel> getDaftarBarangByJenisBarang(@PathVariable String jenisBarang) {
        CommonResponseModel crm = new CommonResponseModel();
        try {
            // Daftar barang = getDaftarBarangByJenisBarang where jenisBarang = ?
            List<PeminjamanOutputModel> poms = monitoringService.getDaftarBarangByJenisBarang(jenisBarang);
            crm.setTitle("Get history Peminjaman");
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
            return new ResponseEntity<>(new CommonResponseModel("Get history Peminjaman", "0", e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
