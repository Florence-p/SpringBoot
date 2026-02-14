package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
    //define field for entity manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement save method

    @Override
    @Transactional
    public void save(student theStudent){
        entityManager.persist(theStudent);





    }

    @Override
    public student findById(Integer id) {
        return entityManager.find(student.class, id);
    }

    @Override
    public List<student> findAll() {
        // create query
      //  TypedQuery<student> theQuery = entityManager.createQuery("FROM student order by lastName asc", student.class);
        TypedQuery<student> theQuery = entityManager.createQuery("FROM student ", student.class);

        // return query results
        return theQuery.getResultList();
    }

    @Override
    public List<student> findByLastName(String theLastName) {
        //create query
        TypedQuery<student> theQuery = entityManager.createQuery(
                "FROM student WHERE lastName=:theData", student.class);

        //set query parameters
        theQuery.setParameter("theData", theLastName);

        //return query results
        return theQuery.getResultList();


    }

    @Override
    @Transactional
    public void update(student theStudent) {
        entityManager.merge(theStudent);

    }
}
