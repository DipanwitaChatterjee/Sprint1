package com.surveyBuilder.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.surveyBuilder.Service.SurveyorService;
import com.surveyBuilder.entities.Feedback;
import com.surveyBuilder.entities.Questions;
import com.surveyBuilder.entities.Responses;
import com.surveyBuilder.entities.Survey;

@RestController
@RequestMapping
public class SurveyorController {
	@Autowired
	private SurveyorService service;
	
	//http://localhost:9090/surveyor-api/survey
	
	@PostMapping(path="survey")											//For creating a survey
	public ResponseEntity<String>saveSurvey(@RequestBody Survey survey){
		ResponseEntity<String>response=null;
		//List<Questions> questions=null;
		service.addSurvey(survey);
		response=new ResponseEntity<String>(survey.getSurveyId()+" is created", HttpStatus.CREATED);
		return response;
	}
	
	
	@PostMapping(path="questions") 
	public ResponseEntity<String>saveQuestion(@RequestBody Questions questions){
	  ResponseEntity<String>response=null;
	  service.addQuestion(questions);
	  response=new ResponseEntity<String>(questions.getQuestionId()+" is created",HttpStatus.CREATED); 
	  return response; 
	  }

	
	
	  @GetMapping(path="allsurvey") 
	  public List<Questions> getAllSurvey(){ 
		  return service.findAllSurvey(); }
	 
	 
	
	  @GetMapping(path="survey/{surveyId}") 
	  public Survey getSurveyById(@PathVariable("surveyId")int surveyId) { 
		  return service.findSurveyById(surveyId); }
	 
	 
	/*@PutMapping
	public void updateQuestion(Questions questions,int questionId) {
		service.updateQuestion(questionId,questions);
		
	}*/
	
	  @DeleteMapping(path="questions/{questionId}") 
	  public void deleteQuestion(@PathVariable int questionId) { 
		  service.removeQuestion(questionId); 
		  }
	 
	  @DeleteMapping(path="survey/{surveyId}") 
	  public void deleteSurvey(@PathVariable int surveyId) { 
		  service.removeSurvey(surveyId); 
		  
		  }
	  @GetMapping(path="respondent/{respondentId}")
	  public List<Responses> findResponsesById(@PathVariable int respondentId){
		  return service.findResponsesById(respondentId);
	  }
	  @GetMapping(path="feedback")
	  public List<Feedback> findAllFeedback(){
		  return service.findAllFeedback();
	  }

}
