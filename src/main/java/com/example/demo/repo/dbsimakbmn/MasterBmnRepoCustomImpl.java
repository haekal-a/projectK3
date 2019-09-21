package com.example.demo.repo.dbsimakbmn;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class MasterBmnRepoCustomImpl implements IMasterBmnRepoCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Object[]> getBarangByKondisiAndStatus(String kondisi, String status) {
        String s = "SELECT \n" +
                "    a.*, b.jenis_barang\n" +
                "FROM\n" +
                "    (SELECT \n" +
                "        a.*, b.sts_barang, b.Kondisi kondisi_db_penari\n" +
                "    FROM\n" +
                "        db_simak_bmn.master_bmn a\n" +
                "    JOIN db_penari_desa.status_barang b ON a.id = b.id_barang\n" +
                "    WHERE\n" +
                "        b.Kondisi = ? AND b.sts_barang = ?) a\n" +
                "        JOIN\n" +
                "    db_simak_bmn.kode_barang b ON a.kd_barang = b.kd_barang";
        Query query = entityManager.createNativeQuery(s);
        query.setParameter(1, kondisi).setParameter(2, status);
        return query.getResultList();
    }
}
