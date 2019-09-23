package com.example.demo.service;

import com.example.demo.helper.ServiceHelper;
import com.example.demo.model.BarangOutputModel;
import com.example.demo.repo.dbsimakbmn.IMasterBmnRepo;
import com.example.demo.repo.dbsimakbmn.IMasterBmnRepoCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class BarangService {

    private IMasterBmnRepo masterBmnRepo;
    private IMasterBmnRepoCustom masterBmnRepoCustom;
    private ServiceHelper serviceHelper;

    @Autowired
    public BarangService(IMasterBmnRepo masterBmnRepo, IMasterBmnRepoCustom masterBmnRepoCustom, ServiceHelper serviceHelper){
        this.masterBmnRepo = masterBmnRepo;
        this.masterBmnRepoCustom = masterBmnRepoCustom;
        this.serviceHelper = serviceHelper;
    }

    public List<BarangOutputModel> getBarangByKondisiAndStatus (String kondisi, String status){
        List<BarangOutputModel> list = new ArrayList<>();
        List<Object[]> data = masterBmnRepoCustom.getBarangByKondisiAndStatus(kondisi, status);
        for (Object[] o : data){
            list.add(serviceHelper.getBarangOutputModel(o));
        }
        return list;
    }
}
