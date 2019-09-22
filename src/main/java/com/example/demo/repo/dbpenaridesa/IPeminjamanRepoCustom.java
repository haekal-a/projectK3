package com.example.demo.repo.dbpenaridesa;


import java.math.BigDecimal;
import java.util.List;

public interface IPeminjamanRepoCustom {

    List<Object[]> getListPinjamBarangByNipAndStatusPeminjaman(String nip, String statusPeminjaman);

    List<Object[]> getListPinjamBarangByStatusPeminjaman(String statusPeminjaman);

    Object[] getPinjamBarangByIdPeminjaman(BigDecimal idPeminjaman);
}
