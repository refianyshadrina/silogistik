package apap.ti.silogistik2106650185.repository;

import org.springframework.stereotype.Repository;

import apap.ti.silogistik2106650185.model.PermintaanPengiriman;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PermintaanPengirimanDb extends JpaRepository<PermintaanPengiriman, Long>{
    
}


