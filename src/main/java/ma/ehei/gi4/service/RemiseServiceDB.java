package ma.ehei.gi4.service;

import ma.ehei.gi4.exception.RemiseException;
import ma.ehei.gi4.model.Remise;
import ma.ehei.gi4.model.Transaction;
import ma.ehei.gi4.model.Utilisateurs;
import ma.ehei.gi4.repository.UtilisateursRepository;
import ma.ehei.gi4.repository.RemiseRepository;
import ma.ehei.gi4.service.RemiseService;
import ma.ehei.gi4.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemiseServiceDB implements RemiseService {

    @Autowired
    private RemiseRepository repository;

    @Autowired
    private UtilisateursRepository repo;

    @Autowired
    private TransactionService transactionService;

    @Override
    public Long calculerRemise(double montant,String nom,String prenom) {
        if (montant <= 0) throw new RemiseException("Montant invalide !");

        try {
            Utilisateurs utilisateur = new Utilisateurs(nom, prenom);
            Long utilisateurId = repo.save(utilisateur);

            Remise remise = repository.findByMontant(montant);
            double montantApres = montant - (montant * remise.getTaux());

            Transaction t = new Transaction(
                    java.time.LocalDateTime.now(),
                    montant,
                    montantApres,
                    null
            );

            return transactionService.save(t); // retourne l'id
        } catch (Exception e) {
            throw new RemiseException("Aucune remise trouvée");
        }
    }

    @Override
    public Long calculerRemise(double montant) {
        return 0L;
    }
}