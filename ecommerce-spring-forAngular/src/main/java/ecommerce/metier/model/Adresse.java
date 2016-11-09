package ecommerce.metier.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.Pattern;

@Embeddable
public class Adresse {

	// ===============   ATTRIBUTS =================== //
	private String adresse;
	private String codePostal;
	private String ville;
	private String pays;
	
	// ===============   CONSTRUCTEURS =================== //
	public Adresse() {
	}

	// ===============   GETTERS & SETTERS =================== //
	
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	//@Pattern(regexp="^[0-9]{5}$", message="{adresse.codePostal.pattern}")
	public String getCodePostal() {
		return codePostal;
	}


	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	// ===============   METHODES =================== //
	
	
	
	// ===============   HASHCODE & COMPARE  =================== //
	
	
	// ===============   TOSTRING =================== //
	
}
