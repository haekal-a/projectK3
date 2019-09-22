package com.example.demo.helper;

import com.example.demo.domain.dbpenaridesa.PeminjamanEntity;
import com.example.demo.model.PeminjamanInputModel;
import com.example.demo.model.PeminjamanOutputModel;
import com.example.demo.repo.dbpenaridesa.IPeminjamanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ServiceHelper {

    public List<PeminjamanOutputModel> getPeminjamanOutputModels(List<Object[]> list) {
        List<PeminjamanOutputModel> output = new ArrayList<>();
        for (Object[] data : list) {
            PeminjamanOutputModel pom = new PeminjamanOutputModel();
            pom.setIdPeminjaman(new BigDecimal((Integer) data[0]));
            pom.setIdBarang(new BigDecimal((Integer) data[1]));
            pom.setNip((String) data[2]);
            pom.setNamaPeminjam((String) data[3]);
            pom.setKeperluan((String) data[4]);
            pom.setTanggalPinjam((Date) data[5]);
            pom.setTanggalKembali((Date) data[6]);
            pom.setTanggalPersetujuan((Date) data[7]);
            pom.setJatuhTempoPengembalian((Date) data[8]);
            pom.setCreatedBy((String) data[9]);
            pom.setApprovedBy((String) data[10]);
            pom.setCreatedDate((Date) data[11]);
            pom.setStatusPeminjaman(String.valueOf(data[12]));
            pom.setAlasanPenolakan((String) data[13]);
            pom.setJenisBarang((String) data[14]);
            pom.setNamaBarang((String) data[15]);
            pom.setMerkBarang((String) data[16]);
            pom.setKeterangan((String) data[17]);
            pom.setKondisi(String.valueOf(data[18]));
            output.add(pom);
        }
        return output;
    }
}
