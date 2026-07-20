package ma.ehei.gi4.repository;

import ma.ehei.gi4.model.Remise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("remiseSpringDataDao")
public class RemiseSpringDataDao implements RemiseDao {

    @Autowired
    private RemiseJpaRepository jpaRepository;

    @Override
    public Remise findByMontant(double montant) {
        return jpaRepository.findByMontant(montant);
    }

    @Override
    public Long save(Remise remise) {
        return jpaRepository.save(remise).getId();
    }

    @Override
    public void update(Long id, double taux) {
        Remise remise = jpaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Remise introuvable : " + id));
        remise.setTaux(taux);
        jpaRepository.save(remise);
    }

    @Override
    public void deleteById(Long id) {
        if (!jpaRepository.existsById(id))
            throw new RuntimeException("Remise introuvable : " + id);
        jpaRepository.deleteById(id);
    }
}