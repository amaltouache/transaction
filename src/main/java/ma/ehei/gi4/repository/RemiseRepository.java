package ma.ehei.gi4.repository;

import ma.ehei.gi4.model.Remise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RemiseRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Remise findByMontant(double montant) {

        String sql = "SELECT montant_min, montant_max, taux FROM remise WHERE ? BETWEEN montant_min AND montant_max";

        return jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                new Remise(
                        rs.getDouble("montant_min"),
                        rs.getDouble("montant_max"),
                        rs.getDouble("taux")
                ), montant
        );
    }
}