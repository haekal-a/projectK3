package com.example.demo.service;

import com.example.demo.domain.dbpegawai.PegawaiEntity;
import com.example.demo.model.PegawaiOutputModel;
import com.example.demo.repo.dbpegawai.IPegawaiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PegawaiService {

    private IPegawaiRepo pegawaiRepo;

    @Autowired
    public PegawaiService(IPegawaiRepo pegawaiRepo) {
        this.pegawaiRepo = pegawaiRepo;
    }

    public PegawaiOutputModel getDataPegawai(String nip) {
        PegawaiOutputModel output = new PegawaiOutputModel();
        PegawaiEntity dataPegawai = pegawaiRepo.findByNip(nip);
        if (dataPegawai != null) {
            output.setNip(dataPegawai.getNip());
            output.setNamaPegawai(dataPegawai.getNamaPegawai());
            output.setSeksi(dataPegawai.getSeksi());
            output.setSubBagian(dataPegawai.getSubBagian());
            output.setJabatan(dataPegawai.getJabatan());
            output.setAlamat(dataPegawai.getAlamat());
            output.setAlamatEmail(dataPegawai.getAlamatEmail());
            output.setNoTelepon(dataPegawai.getNoTelepon());
        }

        return output;
    }
}
