package ma.ehei.gi4;

import ma.ehei.gi4.service.RemiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    private RemiseService remiseService;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

        @Override
        public void run(String... args) {
            System.out.println("Application démarrée !");
            double montant = 200;
            String nom = "Amal";
            String prenom = "TOUACHE";

            Long id = remiseService.calculerRemise(montant,nom,prenom);
            System.out.println("Transaction créée avec id : " + id);
        }
    }