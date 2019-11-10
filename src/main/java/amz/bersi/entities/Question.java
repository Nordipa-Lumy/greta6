package amz.bersi.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Data
@Table(name = "QUESTIONS")
public class Question implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "question")
	private String question;
	
	@Column(name = "reponse_a")
	private String reponseA;
	
	@Column(name = "reponse_b")
	private String reponseB;
	
	@Column(name = "reponse_c")
	private String reponseC;
	
	@Column(name = "reponse_d")
	private String reponseD;
	
	@Column(name = "good")
	private String good;
	
	@Column(name = "theme")
	private String theme;
	
	@Column(name = "domaine")
	private String domaine;
	
	@Transient
	@Column(name = "yearok")
	private int year;
	
		
	public void setDate(int year) {
		this.year = year;
	}

	public Question() {
		this.good = "X";
	}

	public Question(String question, String reponseA, String reponseB, String reponseC, String reponseD, String good,
			String theme, String domaine, int year) {
		this.question = question;
		this.reponseA = reponseA;
		this.reponseB = reponseB;
		this.reponseC = reponseC;
		this.reponseD = reponseD;
		this.good = good;
		this.theme = theme;
		this.domaine = domaine;
		this.year = year;
	}
}
