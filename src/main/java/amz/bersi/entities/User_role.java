package amz.bersi.entities;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Index;


@Entity
@Data @NoArgsConstructor
//@Table(name = "USER_ROLES")
@Table(
	    name="USER_ROLE", 
	    indexes = {
	       @Index(name = "USER_ROLE_0", columnList = "role"),
	       @Index(name = "USER_ROLE_1", columnList = "username")})
public class User_role implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id_userRole;
	
	private String role;
	
	private String username;
	
	public User_role(String role, String username) {
		this.role = role;
		this.username = username;
	}

}
