package com.surveybuilder.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Respondent {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="respondent_Id")
	
	private int respondentId;
	@Column(name="respondent_name")
	@NotBlank(message="mandatory")
	private String respondentName;
	
	@Column(name="respondent_username",length=20)
	@NotBlank(message="mandatory")
	private String respondentUsername;
	
	@Column(name="respondent_password")
	@NotBlank(message="mandatory")
	private String respondentPassword;
	@Column(name="userType")
	private String userType;
	
	@OneToMany(mappedBy="respondentId",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Responses> resp =new ArrayList<Responses>();
	
	@OneToOne(mappedBy="respondentId",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Feedback feedback1;
	
	
	
	public Respondent() {
		super();
	}
	public List<Responses> getResponses() {
		return resp;
	}
	public void setResponses(List<Responses> responses) {
		this.resp = responses;
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
	
	public Respondent(int respondentId, String respondentName, String respondentUsername, String respondentPassword,
			String userType, List<Responses> responses, Feedback feedback1) {
		super();
		this.respondentId = respondentId;
		this.respondentName = respondentName;
		this.respondentUsername = respondentUsername;
		this.respondentPassword = respondentPassword;
		this.userType = userType;
		this.resp = responses;
		this.feedback1 = feedback1;
	}
	@Override
	public String toString() {
		return "Respondent [respondentId=" + respondentId + ", respondentName=" + respondentName
				+ ", respondentUsername=" + respondentUsername + ", respondentPassword=" + respondentPassword
				+ ", userType=" + userType + ", responses=" + resp + ", feedback1=" + feedback1 + "]";
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	
}
