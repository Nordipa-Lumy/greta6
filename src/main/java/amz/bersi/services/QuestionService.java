package amz.bersi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import amz.bersi.dao.ConseilDAO;
import amz.bersi.dao.QuestionDAO;
import amz.bersi.entities.Conseil;
import amz.bersi.entities.Question;



@Service
public class QuestionService {
	
	 @Autowired
	 private QuestionDAO questionDAO;
	 
	 @Autowired
	 private ConseilDAO conseilDAO;

	public List<Question> allQuestions() {
		List<Question> questions= new ArrayList<>(questionDAO.findAll());
		return questions;
	}
	
	
	public Question getQuestion(long id) {
		Question oneQuestion = questionDAO.getOne(id);
		return oneQuestion;
	}

	
	public boolean check(String ok, Long id) {

        if (questionDAO.findById(id).get().getGood().equals(ok)) {
            return true;
        }
        return false;
    }
	
	
	public Question addQuestion(Question q) {
		return questionDAO.save(q);
	}
	
	public Conseil addConseil(Conseil c) {
		return conseilDAO.save(c);
	}
	
	public Question editQuestion(long id) {
		Question q = questionDAO.findById(id).get();
		return q;
	}
	
	 public Question edittQuestion (Question editQuestions){
	        Question question = questionDAO.save(editQuestions);
	        return question;
	}
	 
	public void deleteQuestion(long id) {
		questionDAO.deleteById(id);
	}
}
