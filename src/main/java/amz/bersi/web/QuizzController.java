package amz.bersi.web;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import amz.bersi.entities.Conseil;
import amz.bersi.entities.Question;
import amz.bersi.services.QuestionService;

@Controller
public class QuizzController {

	@Autowired
	private QuestionService questionService;
	
	private long random;
	public long getRandom() {
		return random;
	}

	public void setRandom() {
		this.random = 1L + (long) (Math.random() * (20L - 1L)); /* AU HASARD ENTRE 1 ET 20*/
	}

	public static long random() {
		return (long) Math.random();
	}
	
	
	@GetMapping({"/", "/home", "/homepage"}) 
	public String home(){
		return "views/homepage"; 
	} 
	
	@GetMapping("/resultatspabien") 
	public String resultatsko(){
		return "views/resultatsko"; 
	} 
	
	@GetMapping("/resultatsbien") 
	public String resultatsok(){
		return "views/resultatsok"; 
	} 
	
	
	@GetMapping("/projectenvironment")
	public String showQuizEnvironment(){
		return "views/projectenvironment";
	}
	
	@GetMapping("/projectenvironment/quiz/oneQuestion")
	public String startUpEnvironmentPage(@ModelAttribute("question") Question question, 
			Model model) {
		
		setRandom();
		
		model.addAttribute("question", questionService.getQuestion(getRandom()).getQuestion());
		//model.addAttribute("questionId", questionService.getQuestionId(question));
		//idQuestion = questionService.getQuestionId(question);
		model.addAttribute("reponseA", questionService.getQuestion(getRandom()).getReponseA());
		model.addAttribute("reponseB", questionService.getQuestion(getRandom()).getReponseB());
		model.addAttribute("reponseC", questionService.getQuestion(getRandom()).getReponseC());
		model.addAttribute("reponseD", questionService.getQuestion(getRandom()).getReponseD());
		
		return "views/environmentoneQuestion";
	}
	
	
	@GetMapping("/projectenvironement/quiz/reponseQuestion{reponse}")
	public String checkAnswerEnvironment( HttpServletRequest request, Model model, @PathParam(value = "reponse") String reponse){
		
		String valeur = request.getQueryString();
		String numReponse = valeur.substring(12);
		String goodReponse = "";
		
		switch(numReponse) {
		case "1":
			goodReponse = "A";
			break;
		case "2":
			goodReponse = "B";
			break;
		case "3":
			goodReponse = "C";
			break;
		case "4":
			goodReponse = "D";
			break;	
		}
				
		
		Question q = questionService.getQuestion(getRandom());
		
		System.out.println("bersi projectenvironment controller radios " + valeur +" "+ numReponse );
		
		String reponsequizz = (q.getGood().equals(goodReponse)) ? "correct" : "faux"; 
		System.out.println("reponsequizz :" + reponsequizz);
		model.addAttribute("reponsequizz", reponsequizz);
			
		if(q.getGood().equals(goodReponse)) {
			System.out.println("bravo!! jai taper "+ numReponse + " correct : "+ q.getGood()+ " hasard :" + getRandom());
			return "views/resultatsok";
		
		}else {
			System.out.println("tant pis!! jai taper :" + numReponse + " correct : "+ q.getGood()+ "  hasard :" + getRandom());
			return "views/resultatsko";
		}
				
	}
	
	@GetMapping("/projectenvironment/quiz/addQuestion")/*GET*/
	public String addNewQuestion (Model model){
		model.addAttribute("addQuestion", new Question());
		return "views/addQuestion";
	}
	
	@PostMapping("/projectenvironment/quiz/addQuestion")/*POST*/
	public String addNewQuestion(@ModelAttribute("addQuestion") Question q){
		questionService.addQuestion(q);
		return "views/homepage";
	}
	
	@GetMapping("/projectenvironment/quiz/addConseil")/*GET*/
	public String addNewConseil (Model model){
		model.addAttribute("addConseil", new Conseil());
		return "views/addConseil";
	}
	
	@PostMapping("/projectenvironment/quiz/addConseil")/*POST*/
	public String addNewConseil(@ModelAttribute("addConseil") Conseil c){
		questionService.addConseil(c);
		return "views/homepage";
	}
	
	@GetMapping("/projectsocial")
	public String showQuizSocial(){
		return "views/projectsocial";
	}
	
	@GetMapping("/projectsocial/quiz/oneQuestion")
	public String startUpSocialPage(@ModelAttribute("question") Question question, 
			Model model) {
		
		setRandom();
		
		model.addAttribute("question", questionService.getQuestion(getRandom()).getQuestion());
		//model.addAttribute("questionId", questionService.getQuestionId(question));
		//idQuestion = questionService.getQuestionId(question);
		model.addAttribute("reponseA", questionService.getQuestion(getRandom()).getReponseA());
		model.addAttribute("reponseB", questionService.getQuestion(getRandom()).getReponseB());
		model.addAttribute("reponseC", questionService.getQuestion(getRandom()).getReponseC());
		model.addAttribute("reponseD", questionService.getQuestion(getRandom()).getReponseD());
		
		return "views/socialoneQuestion";
	}
	
	
	@GetMapping("/projectsocial/quiz/reponseQuestion{reponse}")
	public String checkAnswerSocial( HttpServletRequest request, Model model, @PathParam(value = "reponse") String reponse){
		
		String valeur = request.getQueryString();
		String numReponse = valeur.substring(12);
		String goodReponse = "";
		
		switch(numReponse) {
		case "1":
			goodReponse = "A";
			break;
		case "2":
			goodReponse = "B";
			break;
		case "3":
			goodReponse = "C";
			break;
		case "4":
			goodReponse = "D";
			break;	
		}
				
		
		Question q = questionService.getQuestion(getRandom());
		
		System.out.println("bersi projectenvironment controller radios " + valeur +" "+ numReponse );
		
		String reponsequizz = (q.getGood().equals(goodReponse)) ? "correct" : "faux"; 
		System.out.println("reponsequizz :" + reponsequizz);
		model.addAttribute("reponsequizz", reponsequizz);
			
		if(q.getGood().equals(goodReponse)) {
			System.out.println("bravo!! jai taper "+ numReponse + " correct : "+ q.getGood()+ " hasard :" + getRandom());
			return "views/resultatsok";
		
		}else {
			System.out.println("tant pis!! jai taper :" + numReponse + " correct : "+ q.getGood()+ "  hasard :" + getRandom());
			return "views/resultatsko";
		}
				
	}
	
	@GetMapping("/projecteconomy")
	public String showQuizEconomy(){
		return "views/projecteconomy";
	}
	
	
	@GetMapping("/projecteconomy/quiz/oneQuestion")
	public String startUpEconomyPage(@ModelAttribute("question") Question question, 
			Model model) {
		
		setRandom();
		
		model.addAttribute("question", questionService.getQuestion(getRandom()).getQuestion());
		//model.addAttribute("questionId", questionService.getQuestionId(question));
		//idQuestion = questionService.getQuestionId(question);
		model.addAttribute("reponseA", questionService.getQuestion(getRandom()).getReponseA());
		model.addAttribute("reponseB", questionService.getQuestion(getRandom()).getReponseB());
		model.addAttribute("reponseC", questionService.getQuestion(getRandom()).getReponseC());
		model.addAttribute("reponseD", questionService.getQuestion(getRandom()).getReponseD());
		
		return "views/economyoneQuestion";
	}
	
	@GetMapping("/projecteconomy/quiz/reponseQuestion{reponse}")
	public String checkAnswerEconomy( HttpServletRequest request, Model model, @PathParam(value = "reponse") String reponse){
		
		String valeur = request.getQueryString();
		String numReponse = valeur.substring(12);
		String goodReponse = "";
		
		switch(numReponse) {
		case "1":
			goodReponse = "A";
			break;
		case "2":
			goodReponse = "B";
			break;
		case "3":
			goodReponse = "C";
			break;
		case "4":
			goodReponse = "D";
			break;	
		}
				
		
		Question q = questionService.getQuestion(getRandom());
		
		System.out.println("bersi projectenvironment controller radios " + valeur +" "+ numReponse );
		
		String reponsequizz = (q.getGood().equals(goodReponse)) ? "correct" : "faux"; 
		System.out.println("reponsequizz :" + reponsequizz);
		model.addAttribute("reponsequizz", reponsequizz);
			
		if(q.getGood().equals(goodReponse)) {
			System.out.println("bravo!! jai taper "+ numReponse + " correct : "+ q.getGood()+ " hasard :" + getRandom());
			return "views/resultatsok";
		
		}else {
			System.out.println("tant pis!! jai taper :" + numReponse + " correct : "+ q.getGood()+ "  hasard :" + getRandom());
			return "views/resultatsko";
		}
				
	}
}
