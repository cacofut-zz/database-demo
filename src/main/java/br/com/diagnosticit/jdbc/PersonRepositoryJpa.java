/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diagnosticit.jdbc;

import br.com.diagnosticit.domain.Person;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cristianoca
 */
@Transactional
@Repository
public class PersonRepositoryJpa {
    
    @PersistenceContext
    EntityManager entityManager;
    
    public Person findById( Long id ){
        return entityManager.find( Person.class , id );
    }
    
    public Person insert( Person person ){
        person.setId( null );
        return entityManager.merge( person );
    }
    
    public Person update( Person person ){
        return entityManager.merge( person );
    }
    
    public void deleteById( Long id ){
        Person person = findById(id);
        entityManager.remove(person);
    }
    
    public List<Person> findAll(){
        TypedQuery<Person> namedQuery = entityManager.createNamedQuery( "find_all_person", Person.class );
        return namedQuery.getResultList();
    }
    
}
