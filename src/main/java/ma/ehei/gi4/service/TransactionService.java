package ma.ehei.gi4.service;

import ma.ehei.gi4.model.Transaction;

public interface TransactionService {
    Long save(Transaction t);
    Transaction findById(Long id);
    void update(Long id, double montantApres);
    void deleteById(Long id);
}