package com.example.demo.repo.dbpenaridesa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Repository
@Transactional
public class PeminjamanRepoCustomImpl implements IPeminjamanRepoCustom {

    @PersistenceContext
    private EntityManager entityManager;

    static String joinEmpatTable = "SELECT \n" +
            "    a.*,\n" +
            "    b.jenis_barang,\n" +
            "    b.nama_barang,\n" +
            "    b.merk_barang,\n" +
            "    b.keterangan,\n" +
            "    b.kondisi_db_penari\n" +
            "FROM db_penari_desa.peminjaman a\n" +
            "   JOIN (SELECT a.jenis_barang, b.*\n" +
            "FROM db_simak_bmn.kode_barang a\n" +
            "   JOIN (SELECT a.*, b.kondisi kondisi_db_penari\n" +
            "FROM db_simak_bmn.master_bmn a\n" +
            "   JOIN db_penari_desa.status_barang b\n" +
            "ON a.id = b.id_barang) b\n" +
            "ON b.kd_barang = a.kd_barang) b\n" +
            "ON a.id_barang = b.id ";

    @Override
    public List<Object[]> getListPinjamBarangByNipAndStatusPeminjaman(String nip, String statusPeminjaman) {

        String s = joinEmpatTable + " WHERE\n" +
                "    a.nip = ? AND a.status_peminjaman = ?\n" +
                "ORDER BY a.created_date DESC";
        Query query = entityManager.createNativeQuery(s);
        query.setParameter(1, nip).setParameter(2, statusPeminjaman);
        return query.getResultList();
    }

    @Override
    public List<Object[]> getListPinjamBarangByStatusPeminjaman(String statusPeminjaman) {
        String s = joinEmpatTable +" WHERE a.status_peminjaman = ?\n" +
                "ORDER BY a.created_date DESC";
        Query query = entityManager.createNativeQuery(s);
        query.setParameter(1, statusPeminjaman);
        return query.getResultList();
    }

    @Override
    public Object[] getPinjamBarangByIdPeminjaman(BigDecimal idPeminjaman) {
        String s = joinEmpatTable +" WHERE a.id_peminjaman = ?\n" +
                "ORDER BY a.created_date DESC";
        Query query = entityManager.createNativeQuery(s);
        query.setParameter(1, idPeminjaman);
        return (Object[]) query.getSingleResult();
    }
}
