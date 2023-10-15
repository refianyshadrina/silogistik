package apap.ti.silogistik2106650185.repository;

import org.springframework.stereotype.Repository;

import apap.ti.silogistik2106650185.model.GudangBarang;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface GudangBarangDb extends JpaRepository<GudangBarang, Long>{

}
