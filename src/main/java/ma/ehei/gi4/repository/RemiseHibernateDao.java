package ma.ehei.gi4.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ma.ehei.gi4.model.Remise;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("remiseHibernateDao")
public class RemiseHibernateDao implements RemiseDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Remise findByMontant(double montant) {
        return em.createQuery(
                        "SELECT r FROM Remise r WHERE :montant BETWEEN r.montantMin AND r.montantMax",
                        Remise.class)
                .setParameter("montant", montant)
                .getSingleResult();
    }

    @Override
    @Transactional
    public Long save(Remise remise) {
        em.persist(remise);
        return remise.getId();
    }

    @Override
    @Transactional
    public void update(Long id, double taux) {
        Remise remise = em.find(Remise.class, id);
        if (remise == null) throw new RuntimeException("Remise introuvable : " + id);
        remise.setTaux(taux);
        em.merge(remise);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Remise remise = em.find(Remise.class, id);
        if (remise == null) throw new RuntimeException("Remise introuvable : " + id);
        em.remove(remise);
    }
}