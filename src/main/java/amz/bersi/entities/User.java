package amz.bersi.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "USERS")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String username; 
	private String password;
	private boolean active;
		
}
