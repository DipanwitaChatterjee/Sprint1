package com.surveybuilder.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="SURVEY")
public class Survey {
	@Id
	@Column(name="survey_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int surveyId;
	@Column(name="survey_title")
	@NotBlank(message="Survey Title is required")
	private String surveyTitle;
	@Column(name="survey_date")
	@NotBlank(message="Survey Date is required")
	private Date surveyDate;
	@Column(name="survey_last_date")
	@NotBlank(message="Survey Lastdate is required")
	private Date surveyLastDate;
	@Column(name="survey_feedback")
	private String surveyFeedback;
	
	@OneToMany(mappedBy="survey",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Questions>question=new ArrayList<Questions>();
	
	@ManyToOne
	@JoinColumn(name="surveyor_id")
	private Surveyor surveyor;
	
	@OneToOne(mappedBy="surveyId",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Feedback feedback;
	
	
	public List<Questions> getQuestion() {
		return question;
	}
	public void setQuestion(List<Questions> question) {
		this.question = question;
	}
	public int getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}
	public String getSurveyTitle() {
		return surveyTitle;
	}
	public void setSurveyTitle(String surveyTitle) {
		this.surveyTitle = surveyTitle;
	}
	
	public Date getSurveyDate() {
		return surveyDate;
	}
	public void setSurveyDate(Date surveyDate) {
		this.surveyDate = surveyDate;
	}
	public Date getSurveyLastDate() {
		return surveyLastDate;
	}
	public void setSurveyLastDate(Date surveyLastDate) {
		this.surveyLastDate = surveyLastDate;
	}
	public String getSurveyFeedback() {
		return surveyFeedback;
	}
	public void setSurveyFeedback(String surveyFeedback) {
		this.surveyFeedback = surveyFeedback;
	}
	
	

}
