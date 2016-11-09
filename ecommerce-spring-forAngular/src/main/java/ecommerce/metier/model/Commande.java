package ecommerce.metier.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
public class Commande {

	// ===============   ATTRIBUTS =================== //
	private Long id;
	private Integer version;
	private Date date;
	private String commentaire;
	private Double total;
	private User user;
	
	// ===============   CONSTRUCTEURS =================== //

	public Commande() {
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


	@Temporal(TemporalType.DATE)
	//@DateTimeFormat(pattern = "dd-MM-yyyy")
	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public String getCommentaire() {
		return commentaire;
	}


	@Lob
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}



	public Double getTotal() {
		return total;
	}



	public void setTotal(Double total) {
		this.total = total;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	

	// ===============   METHODES =================== //
	
	
	
	// ===============   HASHCODE & COMPARE  =================== //
	
	
	// ===============   TOSTRING =================== //

}