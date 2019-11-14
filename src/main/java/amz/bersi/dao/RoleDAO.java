package amz.bersi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import amz.bersi.entities.Role;

public interface RoleDAO extends JpaRepository<Role, String>{

}
