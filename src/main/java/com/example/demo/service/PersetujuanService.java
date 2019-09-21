package com.example.demo.service;

import com.example.demo.helper.ServiceHelper;
import com.example.demo.model.PeminjamanOutputModel;
import com.example.demo.repo.dbpenaridesa.IPeminjamanRepoCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class PersetujuanService {

    private ServiceHelper serviceHelper;
    private IPeminjamanRepoCustom peminjamanRepoCustom;

    @Autowired
    PersetujuanService(ServiceHelper serviceHelper, IPeminjamanRepoCustom peminjamanRepoCustom){
        this.serviceHelper = serviceHelper;
        this.peminjamanRepoCustom = peminjamanRepoCustom;
    }

    public List<PeminjamanOutputModel> getListPinjamBarangStatusPeminjaman(String statusPeminjaman) {
        List<Object[]> list = peminjamanRepoCustom.getListPinjamBarangByStatusPeminjaman(statusPeminjaman);
        return serviceHelper.getPeminjamanOutputModels(list);
    }
}
