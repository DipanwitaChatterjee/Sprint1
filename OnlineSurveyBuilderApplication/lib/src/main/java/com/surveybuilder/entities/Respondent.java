package com.surveybuilder.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Respondent {
	@Id
	@Column(name="respondent_id")
	private int respondentId;
	@Column(name="respondent_name",length=20)
	@NotBlank(message="Respondent name is mandatory")
	private String respondentName;
	@Column(name="respondent_username",length=20)
	@NotBlank(message="Respondent Username is mandatory")
	private String respondentUsername;
	@Column(name="respondent_password",length=15)
	@NotBlank(message="Password is mandatory")
	private String respondentPassword;
	@Column(name="userType",length=15)
	@NotBlank(message="Usertype is mandatory")
	private String userType;
	
	@OneToMany(mappedBy="respondentId",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Responses>responses=new ArrayList<Responses>();
	
	@OneToOne(mappedBy="respondentId",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Feedback feedback1;
	
	
	public List<Responses> getResponses() {
		return responses;
	}
	public void setResponses(List<Responses> responses) {
		this.responses = responses;
	}
	public int getRespondentId() {
		return respondentId;
	}
	public void setRespondentId(int respondentId) {
		this.respondentId = respondentId;
	}
	public String getRespondentName() {
		return respondentName;
	}
	public void setRespondentName(String respondentName) {
		this.respondentName = respondentName;
	}
	public String getRespondentUsername() {
		return respondentUsername;
	}
	public void setRespondentUsername(String respondentUsername) {
		this.respondentUsername = respondentUsername;
	}
	public String getRespondentPassword() {
		return respondentPassword;
	}
	public void setRespondentPassword(String respondentPassword) {
		this.respondentPassword = respondentPassword;
	}
	
	
}
