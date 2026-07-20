package ma.ehei.gi4.repository;

import ma.ehei.gi4.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDateTime;

@Repository
public class TransactionRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Long save(Transaction t) {
        String sql = "INSERT INTO transactions(date, montant_avant, montant_apres, remise_id) VALUES (?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setObject(1, t.getDate());
            ps.setDouble(2, t.getMontantAvant());
            ps.setDouble(3, t.getMontantApres());
            ps.setObject(4, t.getRemiseId());
            return ps;
        }, keyHolder);

        return keyHolder.getKey().longValue();
    }

    public Transaction findById(Long id) {
        String sql = "SELECT * FROM transactions WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                new Transaction(
                        rs.getLong("id"),
                        rs.getObject("date", LocalDateTime.class),
                        rs.getDouble("montant_avant"),
                        rs.getDouble("montant_apres"),
                        rs.getLong("remise_id")
                ), id
        );
    }

    public void update(Long id, double montantApres) {
        jdbcTemplate.update("UPDATE transactions SET montant_apres = ? WHERE id = ?", montantApres, id);
    }

    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM transactions WHERE id = ?", id);
    }
}