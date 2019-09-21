package com.example.demo.repo.dbpenaridesa;


import java.util.List;

public interface IPeminjamanRepoCustom {

    List<Object[]> getListPinjamBarangByNipAndStatusPeminjaman(String nip, String statusPeminjaman);
}
