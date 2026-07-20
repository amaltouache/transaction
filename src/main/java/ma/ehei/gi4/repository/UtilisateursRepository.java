package ma.ehei.gi4.repository;

import ma.ehei.gi4.model.Utilisateurs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
public class UtilisateursRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Sauvegarder un utilisateur et retourner son id généré
    public Long save(Utilisateurs u) {
        String sql = "INSERT INTO utilisateurs (nom, prenom) VALUES (?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, u.getNom());
            ps.setString(2, u.getPrenom());
            return ps;
        }, keyHolder);

        return keyHolder.getKey().longValue();
    }

    // Rechercher un utilisateur par nom
    public Utilisateurs findByNom(String nom) {
        String sql = "SELECT id, nom, prenom FROM utilisateurs WHERE nom = ?";

        return jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                new Utilisateurs(
                        rs.getString("nom"),
                        rs.getString("prenom")
                ), nom
        );
    }

    // Rechercher un utilisateur par id
    public Utilisateurs findById(Long id) {
        String sql = "SELECT id, nom, prenom FROM utilisateurs WHERE id = ?";

        return jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                new Utilisateurs(
                        rs.getString("nom"),
                        rs.getString("prenom")
                ), id
        );
    }
}