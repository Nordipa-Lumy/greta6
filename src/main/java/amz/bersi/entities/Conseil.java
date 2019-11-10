package amz.bersi.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONSEIL")
public class Conseil implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConseil;
	
	private String texte;
	
	
	public Conseil() {
	}
	
	public Conseil(String texte) {
		this.texte = texte;
	}

	public Long getIdConseil() {
		return idConseil;
	}

	public void setIdConseil(Long idConseil) {
		this.idConseil = idConseil;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}
	
}
