package ma.ehei.gi4.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;
    private double montantAvant;
    private double montantApres;
    private Long remiseId;

    public Transaction() {}

    public Transaction(LocalDateTime date, double montantAvant, double montantApres, Long remiseId) {
        this.date = date;
        this.montantAvant = montantAvant;
        this.montantApres = montantApres;
        this.remiseId = remiseId;
    }

    public Transaction(Long id, LocalDateTime date, double montantAvant, double montantApres, Long remiseId) {
        this.id = id;
        this.date = date;
        this.montantAvant = montantAvant;
        this.montantApres = montantApres;
        this.remiseId = remiseId;
    }

    public Long getId() { return id; }
    public LocalDateTime getDate() { return date; }
    public double getMontantAvant() { return montantAvant; }
    public double getMontantApres() { return montantApres; }
    public Long getRemiseId() { return remiseId; }
    public void setMontantApres(double montantApres) { this.montantApres = montantApres; }
}