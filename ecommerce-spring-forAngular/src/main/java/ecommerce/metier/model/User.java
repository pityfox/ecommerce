package ecommerce.metier.model;


import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Utilisateur")
public class User {

	// ===============   ATTRIBUTS =================== //
	private Long id;
	private Integer version;
	private UserRole role;
	private String nom;
	private String prenom;
	private Integer numeroTel;
	private Integer numeroFax;
	private String email;
	private Adresse adresse;
	private String login;
	private String motDePass;
	private List<Commande> commandes;
	// ===============   CONSTRUCTEURS =================== //

	public User() {
	}
	
	
	
	public User(String nom) {
		this.nom = nom;
	}


	// ===============  SETTERS & GETTERS =================== //
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Version
	@Column(name="Version")
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Column(name="Nom",length=50)
	//@NotEmpty(message="{user.nom.notNull}")
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name="NumeroTel")
	public Integer getNumeroTel() {
		return numeroTel;
	}

	public void setNumeroTel(Integer numeroTel) {
		this.numeroTel = numeroTel;
	}

	@Column(name="NumeroFax")
	public Integer getNumeroFax() {
		return numeroFax;
	}

	public void setNumeroFax(Integer numeroFax) {
		this.numeroFax = numeroFax;
	}

	@Column(name="Email",length=100)
	//@NotEmpty(message="{user.email.notNull}")
	//@Email(message="{user.email.format}")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="adresse",column=@Column(name="C_RUE",length=50)),
		@AttributeOverride(name="codePostal",column=@Column(name="C_CP",length=20)),
		@AttributeOverride(name="ville",column=@Column(name="C_VILLE",length=50)),
		@AttributeOverride(name="pays",column=@Column(name="C_PAYS",length=50))
		})
	//@Valid
	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}



	public String getMotDePass() {
		return motDePass;
	}



	public void setMotDePass(String motDePass) {
		this.motDePass = motDePass;
	}


	@Enumerated(EnumType.STRING)
	public UserRole getRole() {
		return role;
	}



	public void setRole(UserRole role) {
		this.role = role;
	}


	@JsonIgnore
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	public List<Commande> getCommandes() {
		return commandes;
	}



	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}
	
	

	// ===============   METHODES =================== //
	
	
	
	// ===============   HASHCODE & COMPARE  =================== //
	
	
	// ===============   TOSTRING =================== //

}