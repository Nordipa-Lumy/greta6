package amz.bersi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import amz.bersi.entities.User;

public interface UserDAO extends JpaRepository<User, String>{

}
