package amz.bersi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import amz.bersi.entities.Question;


public interface QuestionDAO extends JpaRepository<Question, Long>{

}
