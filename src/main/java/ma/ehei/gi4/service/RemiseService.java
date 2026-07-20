package ma.ehei.gi4.service;

public interface RemiseService {
    Long calculerRemise(double montant,String nom,String prenom); // retourne l'id de la transaction

    Long calculerRemise(double montant);
}