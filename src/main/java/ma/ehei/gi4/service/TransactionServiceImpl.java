package ma.ehei.gi4.service;

import ma.ehei.gi4.model.Transaction;
import ma.ehei.gi4.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository repository;

    @Override
    public Long save(Transaction t) {
        return repository.save(t);
    }

    @Override
    public Transaction findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void update(Long id, double montantApres) {
        repository.update(id, montantApres);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}