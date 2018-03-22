package com.resource.user.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.resource.user.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	@Transactional
	public List<User> getAll() {
		
		return entityManager.createQuery("FROM User").getResultList(); 

	}

	@Override
	@Transactional
	public long save(User user) {
		entityManager.persist(user); 
		return user.getId();
	}
	
	@Override
	@Transactional
	public long update(User user) {
		entityManager.merge(user); 
		return user.getId();
	}

	@Override
	@Transactional
	public void delete(User user) {
		entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
	}

	@Override
	@Transactional
	public String getAllUsingProcedure() {
        StoredProcedureQuery storedProcedure = 
          entityManager
            .createStoredProcedureQuery("getUserNames",User.class)
            .registerStoredProcedureParameter(1, String.class, ParameterMode.OUT);
        
        storedProcedure.execute();
        
        
       return storedProcedure.getOutputParameterValue(1).toString();
    }
}
