package com.example.demo.service;

import com.example.demo.helper.ServiceHelper;
import com.example.demo.model.PeminjamanOutputModel;
import com.example.demo.repo.dbpenaridesa.IPeminjamanRepoCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MonitoringService {

    private IPeminjamanRepoCustom peminjamanRepoCustom;
    private ServiceHelper serviceHelper;

    @Autowired
    public MonitoringService(IPeminjamanRepoCustom peminjamanRepoCustom, ServiceHelper serviceHelper) {
        this.peminjamanRepoCustom = peminjamanRepoCustom;
        this.serviceHelper = serviceHelper;
    }

    public List<PeminjamanOutputModel> getListPinjamBarangByStatusPeminjaman(String statusPeminjaman) {
        List<Object[]> list = peminjamanRepoCustom.getListPinjamBarangByStatusPeminjamanOrderByTglJatuhTempo(statusPeminjaman);
        List<PeminjamanOutputModel> output = new ArrayList<>();
        for (Object[] data : list) {
            output.add(serviceHelper.getPeminjamanOutputModel(data));
        }
        return output;
    }

    public List<PeminjamanOutputModel> getListPinjamBarangByStatusPeminjamanAndNip(String nip, String statusPeminjaman) {
        List<Object[]> list = peminjamanRepoCustom.getListPinjamBarangByNipAndStatusPeminjamanOrderByTglJatuhTempo(nip, statusPeminjaman);
        List<PeminjamanOutputModel> output = new ArrayList<>();
        for (Object[] data : list) {
            output.add(serviceHelper.getPeminjamanOutputModel(data));
        }
        return output;
    }

    public List<PeminjamanOutputModel> getDaftarRiwayatPeminjamanByNip(String nip) {
        List<Object[]> list = peminjamanRepoCustom.getListPinjamBarangByNip(nip);
        List<PeminjamanOutputModel> output = new ArrayList<>();
        for (Object[] data : list) {
            output.add(serviceHelper.getPeminjamanOutputModel(data));
        }
        return output;
    }

    public List<PeminjamanOutputModel> getDaftarBarangByJenisBarang(String jenisBarang) {
        List<Object[]> list = peminjamanRepoCustom.getListPinjamBarangByJenisBarang(jenisBarang);
        List<PeminjamanOutputModel> output = new ArrayList<>();
        for (Object[] data : list) {
            output.add(serviceHelper.getPeminjamanOutputModel(data));
        }
        return output;
    }
}
