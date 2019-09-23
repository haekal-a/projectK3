package com.example.demo.helper;

import com.example.demo.domain.dbpenaridesa.PeminjamanEntity;
import com.example.demo.model.BarangOutputModel;
import com.example.demo.model.PeminjamanInputModel;
import com.example.demo.model.PeminjamanOutputModel;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@Component
public class ServiceHelper {

    public PeminjamanOutputModel getPeminjamanOutputModel(Object[] data) {
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
        return pom;
    }

    public BarangOutputModel getBarangOutputModel(Object[] o) {
        BarangOutputModel output = new BarangOutputModel();
        output.setId(new BigDecimal((Integer) o[0]));
        output.setKdBarang((String) o[1]);
        output.setNamaBarang((String) o[2]);
        output.setMerkBarang((String) o[3]);
        output.setTahunPembelian((String) o[4]);
        output.setKeterangan((String) o[5]);
        output.setKondisi((String) o[6]);
        output.setCreatedBy((String) o[7]);
        output.setCreatedDate((Date) o[8]);
        output.setStsBarang(String.valueOf(o[9]));
        output.setKondisiDbPenari(String.valueOf(o[10]));
        output.setJenisBarang((String) o[11]);
        return output;
    }
}
