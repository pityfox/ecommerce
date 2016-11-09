package ecommerce.metier.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ecommerce.metier.dao.CommandeDao;
import ecommerce.metier.model.Commande;

@Transactional
@Repository
public class CommandeDaoJpa implements CommandeDao {

	@PersistenceContext //annotation jpa qui injecte automatiquement l'entity manager
	private EntityManager em;
	

	@Override
	@Transactional(readOnly=true)
	public Commande find(Long id) {
		return em.find(Commande.class, id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Commande> findAll() {
		Query query = em.createQuery("from Commande c");		
		return query.getResultList();
	}

	@Override
	public void create(Commande commande) {
		em.persist(commande);
	}

	//un objet récupéré de la base est déjà managé donc les modif se font automatiquement pas besoin d'update
	//on utilise update pour merger objet
	@Override
	public Commande update(Commande commande) {
		return em.merge(commande);
		
	}

	@Override
	public void delete(Commande commande) {
		commande = em.merge(commande);
		em.remove(commande);
		
	}

	@Override
	public void delete(Long id) {
		Commande commande = find(id);
		em.remove(commande);
	
	}

}
