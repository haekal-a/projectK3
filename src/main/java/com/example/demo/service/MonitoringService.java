package com.example.demo.service;

import com.example.demo.helper.ServiceHelper;
import com.example.demo.model.BarangOutputModel;
import com.example.demo.model.PeminjamanOutputModel;
import com.example.demo.repo.dbpenaridesa.IPeminjamanRepoCustom;
import com.example.demo.repo.dbsimakbmn.IMasterBmnRepoCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MonitoringService {

    private IPeminjamanRepoCustom peminjamanRepoCustom;
    private ServiceHelper serviceHelper;
    private IMasterBmnRepoCustom masterBmnRepoCustom;

    @Autowired
    public MonitoringService(IPeminjamanRepoCustom peminjamanRepoCustom, ServiceHelper serviceHelper, IMasterBmnRepoCustom masterBmnRepoCustom) {
        this.peminjamanRepoCustom = peminjamanRepoCustom;
        this.serviceHelper = serviceHelper;
        this.masterBmnRepoCustom = masterBmnRepoCustom;
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

    public List<BarangOutputModel> getListBarangByKdBarang(String kdBarang) {
        List<BarangOutputModel> list = new ArrayList<>();
        List<Object[]> data = masterBmnRepoCustom.getBarangByKdBarang(kdBarang);
        for (Object[] o : data){
            list.add(serviceHelper.getBarangOutputModel(o));
        }
        return list;
    }

    public List<PeminjamanOutputModel> getListHistoryBarangByIdBarang(String idBarang) {
        List<Object[]> list = peminjamanRepoCustom.getListHistoryBarangByIdBarang(idBarang);
        List<PeminjamanOutputModel> output = new ArrayList<>();
        for (Object[] data : list) {
            output.add(serviceHelper.getPeminjamanOutputModel(data));
        }
        return output;
    }
}
