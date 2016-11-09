package ecommerce.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import ecommerce.metier.dao.UserDao;
import ecommerce.metier.model.User;
import ecommerce.metier.model.UserRole;

@RestController
public class UserRestController {

	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAll() {
		List<User> users = userDao.findAll();
		if (users == null) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> get(@PathVariable("id") Long id) {
		User user = userDao.find(id);
		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/user/", method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody User user, UriComponentsBuilder ucBuilder) {
		if (user.getId() != null && userDao.find(user.getId()) != null) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		} else {
			userDao.create(user);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}
	}
	

	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> update(@PathVariable("id") Long id, @RequestBody User user) {
		User currentUser = userDao.find(id);
		if (currentUser == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		} else {
			currentUser.setRole(user.getRole());
			currentUser.setNom(user.getNom());
			currentUser.setPrenom(user.getPrenom());
			currentUser.setNumeroFax(user.getNumeroFax());
			currentUser.setNumeroTel(user.getNumeroTel());
			currentUser.setEmail(user.getEmail());
			currentUser.setAdresse(user.getAdresse());
			currentUser.setLogin(user.getLogin());
			currentUser.setMotDePass(user.getMotDePass());
			currentUser = userDao.update(currentUser);
			currentUser = userDao.find(currentUser.getId());
			return new ResponseEntity<User>(currentUser, HttpStatus.OK);
		}
	}
	

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<User> delete(@PathVariable("id") Long id) {
		User user = userDao.find(id);
		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		userDao.delete(user);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/user/role", method = RequestMethod.GET)
	public ResponseEntity<UserRole[]> listUserRole() {

		return new ResponseEntity<UserRole[]>(UserRole.values(), HttpStatus.OK);

	}
	
}
