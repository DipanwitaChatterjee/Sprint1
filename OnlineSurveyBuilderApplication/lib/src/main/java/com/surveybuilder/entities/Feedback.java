package com.surveybuilder.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class Feedback {
	@Id
	@Column(name="feedback_id")
	private int feedbackId;
	@Column(name="feedback")
	private String feedback;
	
	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Survey getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Survey surveyId) {
		this.surveyId = surveyId;
	}

	public Respondent getRespondentId() {
		return respondentId;
	}

	public void setRespondentId(Respondent respondentId) {
		this.respondentId = respondentId;
	}

	@OneToOne
	@JoinColumn(name="survey_id")
	private Survey surveyId;
	
	@OneToOne
	@JoinColumn(name="respondent_id")
	private Respondent respondentId;
	

}
