package br.com.diagnosticit;

import br.com.diagnosticit.domain.Person;
import br.com.diagnosticit.jdbc.PersonRepositoryJdbc;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner{

    @Autowired
    PersonRepositoryJdbc repository;
    
    Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(DatabaseDemoApplication.class, args);                

    }

    @Override
    public void run(String... args) throws Exception {
        repository.listAll().forEach( p -> logger.info( "\nAll users -> {}", p ));
        logger.info( "\nUser -> {}", repository.findById(1002L) );
        logger.info( "\nDelete user 1003 -> number rows affect {}", repository.deleteById(1003L) );
        
        
        logger.info( "Insert Juliano", repository.insert( new Person( 1004L, "Juliano da Silva", "Rio de Janeiro", new Date())));
        logger.info( "Insert Capriano", repository.insert( new Person( 1005L, "Capriano da Silva", "Rio Grande do Sul", new Date())));
        
        logger.info( "Update 1001", repository.update( new Person( 1001L, "Cristiano Carvalho Amaral atualizado", "São Paulo", new Date())));
        repository.listAll().forEach( p -> logger.info( "\nAll users -> {}", p ));
        
    }
    
   
}
