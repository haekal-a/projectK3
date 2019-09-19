package com.example.demo.service;

import com.example.demo.domain.dbpenaridesa.PeminjamanEntity;
import com.example.demo.model.PeminjamanInputModel;
import com.example.demo.repo.dbpenaridesa.IPeminjamanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PeminjamanService {

    private IPeminjamanRepo peminjamanRepo;

    @Autowired
    public PeminjamanService (IPeminjamanRepo peminjamanRepo){
        this.peminjamanRepo = peminjamanRepo;
    }

    public void savePeminjaman (PeminjamanInputModel pim){
        PeminjamanEntity pinjam = new PeminjamanEntity();
        pinjam.setIdBarang(pim.getIdBarang());
        pinjam.setNip(pim.getNip());
        pinjam.setNamaPeminjam(pim.getNamaPeminjam());
        pinjam.setKeperluan(pim.getKeperluan());
        pinjam.setTanggalPinjam(pim.getTanggalpinjam());
        pinjam.setJatuhTempoPengembalian(pim.getTanggaljatuhtempo());
        pinjam.setCreatedBy(pim.getNip());
        pinjam.setCreatedDate(new Date());
        pinjam.setStatusPeminjaman("0");
        peminjamanRepo.save(pinjam);
    }
}
