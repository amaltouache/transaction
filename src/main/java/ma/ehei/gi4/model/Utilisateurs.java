package ma.ehei.gi4.model;

public class Utilisateurs {

    private Long id;
    private String nom;
    private String prenom;

    public Utilisateurs(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
}