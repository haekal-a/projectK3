package com.example.demo.service;

import com.example.demo.domain.dbpegawai.PegawaiEntity;
import com.example.demo.model.PegawaiOutputModel;
import com.example.demo.repo.dbpegawai.PegawaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Component
public class PegawaiService {

    private PegawaiRepository pegawaiRepository;

    @Autowired
    public PegawaiService(PegawaiRepository pegawaiRepository) {
        this.pegawaiRepository = pegawaiRepository;
    }

    public PegawaiOutputModel getDataPegawai(String nip){
        PegawaiOutputModel output = new PegawaiOutputModel();
        PegawaiEntity dataPegawai = pegawaiRepository.findByNip(nip);
        if (dataPegawai != null){
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
