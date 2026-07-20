package ma.ehei.gi4.repository;

import ma.ehei.gi4.model.Remise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RemiseJpaRepository extends JpaRepository<Remise, Long> {

    @Query("SELECT r FROM Remise r WHERE :montant BETWEEN r.montantMin AND r.montantMax")
    Remise findByMontant(@Param("montant") double montant);
}