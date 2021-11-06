package com.surveybuilder.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.surveybuilder.entities.Feedback;
import com.surveybuilder.entities.Respondent;
import com.surveybuilder.exception.ResourceNotFoundException;
import com.surveybuilder.service.RespondentService;
import com.surveybuilder.entities.Responses;

@RestController
@RequestMapping(path="respondents")
public class RespondentController{
	
	@Autowired
	private RespondentService rs=null;
	
	//login of respondent 
	@GetMapping(path="authRespondent/{authRespondentUserName}/{pass}")
	public String authRespondentController(@PathVariable("authRespondentUserName") String authRespondentUserName, @PathVariable("pass") String pass){
		Respondent s = rs.authRespondent(authRespondentUserName, pass);
		
		
		if( rs.authRespondent(authRespondentUserName, pass) != null)
			return "login successfull";
		else
			return "login failed";
	}
	
     // registration of respondent
	@PostMapping("createRespondent")
	public Respondent createRespondentController(@Valid  @RequestBody Respondent s) {
		return rs.createRespondentService(s);
	}
	
	//view the Respondent by Id
	@GetMapping(path="readRespondent/{id}")
	public Respondent viewRespondentByIdController(@PathVariable("id") int id){
		System.out.println("these is  id"+ id);
		 return rs.viewRespondentByIdService(id);
		
	}
	
	//update the Respondent by Id
	@PutMapping("updateRespondentById/{s}/{id}")
	public Respondent updateRespondentController(@RequestBody Respondent s, @PathVariable("id") long id) throws ResourceNotFoundException {
		return rs.updateRespondentService(s, id);
	}
	
	
	//Delete the Respondent by Id
	
	@DeleteMapping("deleteRespondentById/{id}")
	public String deleteRespondentByIdController(@PathVariable("id") Long id) throws ResourceNotFoundException{
		if(rs.deleteRespondentByIdService(id))
			return "Record deleted Successfully";
		else
			return "Can not delete record";
	}
	
	
	//List of all Respondent
	@GetMapping(path="{listAllRespondent}")
	public List<Respondent> listAllRespondentController(){
		
		List<Respondent> lst = new ArrayList<Respondent>();
		
		for(Respondent a : rs.listAllRespondentService()) {
			Respondent a1 = new Respondent();
			a1.setRespondentId(a.getRespondentId());
			a1.setRespondentUsername(a.getRespondentUsername());
			a1.setRespondentName(a.getRespondentName());;
			a1.setRespondentPassword(a.getRespondentPassword());;
			lst.add(a1);
		}
		
		return lst;
	}
	
	
	// responses 
	@PostMapping(path="responses")
	
	public void giveRespondentResponseController(@RequestBody Responses responses) {
		rs.giveResponse(responses);
	}
	
	//Give  feedback of Respondent
	@PostMapping(path="feedback")
	public void giveFeedback(@RequestBody Feedback feedback) {
		rs.giveFeedback(feedback);
	} 
			
}

