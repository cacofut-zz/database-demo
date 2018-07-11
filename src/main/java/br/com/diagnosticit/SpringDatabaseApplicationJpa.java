package br.com.diagnosticit;

import br.com.diagnosticit.domain.Person;
import br.com.diagnosticit.jdbc.PersonRepositoryJdbc;
import br.com.diagnosticit.jdbc.PersonRepositoryJpa;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDatabaseApplicationJpa implements CommandLineRunner{

    @Autowired
    PersonRepositoryJpa repository;
    
    Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(SpringDatabaseApplicationJpa.class, args);                

    }

    @Override
    public void run(String... args) throws Exception {
       
        logger.info( "\nAll Users -> {}", repository.findAll() );
        logger.info( "\nUser -> {}", repository.findById(1002L) );
        logger.info( "\nInsert User -> {}", repository.insert( new Person("Novo Usuário", "São paulo", new Date()) ));
        logger.info( "\nUpdate User -> {}", repository.update( new Person( 1001L, "Usuário atualizado JPA", "São Paulo JPA", new Date() )));
        repository.deleteById(1002L);
        
    }
    
   
}
