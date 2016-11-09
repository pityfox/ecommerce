package tests;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ecommerce.metier.dao.CommandeDao;
import ecommerce.metier.dao.UserDao;
import ecommerce.metier.model.Adresse;
import ecommerce.metier.model.Commande;
import ecommerce.metier.model.User;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional
@Rollback(false)
public class TestEcommerce {

	// ===============  LISTE DAO =================== //
	
	@Autowired
	private UserDao clientDao;

	@Autowired
	private CommandeDao commandeDao;
	// ===============   REMPLISSAGE DE LA BDD =================== //
	
	@Test
	@Transactional
	public void apopulate() {
		
		// ADRESSES
		Adresse adrUser1 = new Adresse();
		adrUser1.setAdresse("33 rue du lol");
		adrUser1.setCodePostal("75001");
		adrUser1.setPays("France");
		adrUser1.setVille("Paris");
		
		Adresse adrUser2 = new Adresse();
		adrUser2.setAdresse("1337 rue du G33k");
		adrUser2.setCodePostal("1337");
		adrUser2.setPays("Syap");
		adrUser2.setVille("Elliv");

		// CLIENTS
		User user1 = new User();
		user1.setAdresse(adrUser1);
		user1.setNom("User1");

		User user2 = new User();
		user2.setAdresse(adrUser2);
		user2.setNom("User2");
		
		clientDao.create(user1);
		clientDao.create(user2);
		
		
		// COMMANDES
		Calendar cal = GregorianCalendar.getInstance();
		cal.set(2017, Calendar.APRIL, 18, 15, 20, 00);
		cal.set(Calendar.MILLISECOND, 0);
		Commande com1 = new Commande();
		com1.setDate(cal.getTime());
		com1.setCommentaire("Commentaire1");
		com1.setTotal(1250d);
		com1.setUser(user1);
		
		Calendar cal2 = GregorianCalendar.getInstance();
		cal2.set(2018, Calendar.MAY, 19, 16, 20, 00);
		cal2.set(Calendar.MILLISECOND, 0);
		Commande com2 = new Commande();
		com2.setDate(cal2.getTime());
		com2.setCommentaire("Commentaire2");
		com2.setTotal(2840d);
		com2.setUser(user2);
		
		commandeDao.create(com1);
		commandeDao.create(com2);

	}
	
	// TESTS JPQL
//	@Test
//	public void bjpql(){
//		long nbResa = reservationDao.countByVolNumber("963");
//		System.out.println("Nb resa : " + nbResa);
//	}
	
	// TESTS UNITAIRES

//	@Test
//	public void bcheck() {
//		Passager passager = passagerDao.find("Bunny");
//		Ville villeD = villeDao.find("Paris");
//		Ville villeA = villeDao.find("Lima");
//		Ville villeE = villeDao.find("Geneve");
//		Aeroport aeroportD = aeroportDao.find("charles de gaulle");
//		Aeroport aeroportA = aeroportDao.find("Lima airport");
//		Aeroport aeroportE = aeroportDao.find("Geneve airport");
//		CompagnieAerienneVol cav = compagnieAerienneVolDao.find("963");
//		UserPhysique cp = clientPhysiqueDao.find("DESTREZ");
//		Login login = loginDao.find("rd");
//		Reservation reservation = reservationDao.find(600);
//
//		assertEquals("Bunny", passager.getNom());
//		assertEquals("Paris", villeD.getNom());
//		assertEquals("Lima", villeA.getNom());
//		assertEquals("Geneve", villeE.getNom());
//		assertEquals("charles de gaulle", aeroportD.getNom());
//		assertEquals("Lima airport", aeroportA.getNom());
//		assertEquals("Geneve airport", aeroportE.getNom());
//		assertEquals("963", cav.getNumero());
//		assertEquals("DESTREZ", cp.getNom());
//		assertEquals("rd", login.getLogin());
//		assertEquals(600, reservation.getNumero());
//
//		passager.setNom("Tom");
//		villeD.setNom("Londres");
//		villeA.setNom("Toronto");
//		villeE.setNom("Lisbone");
//		aeroportD.setNom("Stansted");
//		aeroportD.setNom("Toronto Airport");
//		aeroportD.setNom("Lisbonne Airport");
//
//		passagerDao.update(passager);
//		villeDao.update(villeD);
//		villeDao.update(villeA);
//		villeDao.update(villeE);
//
//	}
//
//	@Test
//	public void cupdateCheck() {
//		Passager passager = passagerDao.find("Tom");
//
//		assertEquals("Tom", passager.getNom());
//	}
//
//	@Test
//	public void ddelete() {
//		Passager passager = passagerDao.find("Tom");
//		passagerDao.delete(passager);
//
//	}
//
//	@Test
//	public void edeleteCheck() {
//		Passager passager = passagerDao.find("Tom");
//		assertEquals(null, passager);
//
//	}

}
