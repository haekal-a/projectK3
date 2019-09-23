package com.example.demo.repo.dbsimakbmn;

import java.util.List;

public interface IMasterBmnRepoCustom {

    List<Object[]> getBarangByKondisiAndStatus(String kondisi, String status);

    List<Object[]> getBarangByKdBarang(String kdBarang);
}
