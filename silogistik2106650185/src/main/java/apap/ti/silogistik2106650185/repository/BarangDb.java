package apap.ti.silogistik2106650185.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apap.ti.silogistik2106650185.model.Barang;

@Repository
public interface BarangDb extends JpaRepository<Barang, String> {
    
}
