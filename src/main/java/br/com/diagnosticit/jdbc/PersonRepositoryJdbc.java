/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diagnosticit.jdbc;

import br.com.diagnosticit.domain.Person;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cristianoca
 */
@Repository
public class PersonRepositoryJdbc {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public List<Person> listAll(){
        return jdbcTemplate.query("SELECT * FROM person", new BeanPropertyRowMapper<Person>(Person.class));
    }
    
    public Person findById( Long id ){
        return jdbcTemplate.queryForObject( 
            "SELECT * FROM person WHERE id = ?", 
            new Object[]{id},
            new BeanPropertyRowMapper<Person>(Person.class));
    }
    
     public int deleteById( Long id ){
        return jdbcTemplate.update("DELETE FROM person WHERE id = ?", new Object[]{id});
    }
     
    public int insert( Person person ){
        return jdbcTemplate.update( "INSERT INTO person( id, name, location, birth_date )VALUES( ?, ?, ?, ? )", 
            new Object[]{ person.getId(), person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime())});
    }
    
    public int update( Person person ){
        return jdbcTemplate.update( "UPDATE person SET name = ?, location = ?, birth_date = ? WHERE id = ?",  
            new Object[]{ person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()), person.getId() });
    }
    
}
