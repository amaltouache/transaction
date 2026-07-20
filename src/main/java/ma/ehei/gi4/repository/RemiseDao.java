package ma.ehei.gi4.repository;

import ma.ehei.gi4.model.Remise;

public interface RemiseDao {
    Remise findByMontant(double montant);
    Long save(Remise remise);
    void update(Long id, double taux);
    void deleteById(Long id);
}
// Cela permet de changer d'implémentation sans toucher au reste du code.