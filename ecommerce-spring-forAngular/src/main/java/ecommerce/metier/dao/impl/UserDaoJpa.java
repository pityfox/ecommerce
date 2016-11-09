package ecommerce.metier.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ecommerce.metier.dao.UserDao;
import ecommerce.metier.model.User;

@Transactional
@Repository
public class UserDaoJpa implements UserDao {

	@PersistenceContext //annotation jpa qui injecte automatiquement l'entity manager
	private EntityManager em;
	

	@Override
	@Transactional(readOnly=true)
	public User find(Long id) {
		return em.find(User.class, id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<User> findAll() {
		Query query = em.createQuery("from User c");		
		return query.getResultList();
	}

	@Override
	public void create(User user) {
		em.persist(user);
	}

	//un objet r�cup�r� de la base est d�j� manag� donc les modif se font automatiquement pas besoin d'update
	//on utilise update pour merger objet
	@Override
	public User update(User user) {
		return em.merge(user);
		
	}

	@Override
	public void delete(User user) {
		user = em.merge(user);
		em.remove(user);
		
	}

	@Override
	public void delete(Long id) {
		User user = find(id);
		em.remove(user);
	
	}

}
