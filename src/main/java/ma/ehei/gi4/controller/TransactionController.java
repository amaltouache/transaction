package ma.ehei.gi4.controller;

import ma.ehei.gi4.exception.RemiseException;
import ma.ehei.gi4.model.Transaction;
import ma.ehei.gi4.service.RemiseService;
import ma.ehei.gi4.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private RemiseService remiseService;

    @Autowired
    private TransactionService transactionService;

    // POST /transactions?montant=200
    @PostMapping
    public ResponseEntity<?> creerTransaction(@RequestParam double montant) {
        try {
            Long id = remiseService.calculerRemise(montant);
            return ResponseEntity.ok("Transaction créée avec id : " + id);
        } catch (RemiseException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // GET /transactions/{id}
    @GetMapping("/{id}")
    public ResponseEntity<?> getTransaction(@PathVariable Long id) {
        try {
            Transaction t = transactionService.findById(id);
            return ResponseEntity.ok(t);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // PUT /transactions/{id}?montantApres=180
    @PutMapping("/{id}")
    public ResponseEntity<?> updateTransaction(@PathVariable Long id,
                                               @RequestParam double montantApres) {
        try {
            transactionService.update(id, montantApres);
            return ResponseEntity.ok("Transaction " + id + " mise à jour");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /transactions/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTransaction(@PathVariable Long id) {
        try {
            transactionService.deleteById(id);
            return ResponseEntity.ok("Transaction " + id + " supprimée");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}