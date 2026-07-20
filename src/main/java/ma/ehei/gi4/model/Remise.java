package ma.ehei.gi4.model;

import jakarta.persistence.*;

@Entity
@Table(name = "remise")
public class Remise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double montantMin;
    private double montantMax;
    private double taux;

    public Remise() {}

    public Remise(double montantMin, double montantMax, double taux) {
        this.montantMin = montantMin;
        this.montantMax = montantMax;
        this.taux = taux;
    }

    public Long getId() { return id; }
    public double getMontantMin() { return montantMin; }
    public double getMontantMax() { return montantMax; }
    public double getTaux() { return taux; }
    public void setTaux(double taux) { this.taux = taux; }
}