package amz.bersi.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data 
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
		
}
