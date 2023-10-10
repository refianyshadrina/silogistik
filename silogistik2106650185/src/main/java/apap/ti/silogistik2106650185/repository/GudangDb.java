package apap.ti.silogistik2106650185.repository;

import org.springframework.stereotype.Repository;

import apap.ti.silogistik2106650185.model.Gudang;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface GudangDb extends JpaRepository<Gudang, Long>{
    
}


