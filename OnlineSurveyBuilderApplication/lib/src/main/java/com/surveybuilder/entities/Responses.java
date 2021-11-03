package com.surveybuilder.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Responses {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="answer_id")
	private int answerId;
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId=answerId;
	}
	@Column(name="answer")
	private String answer;
	@ManyToOne
	@JoinColumn(name="question_id")
	private Questions que=new Questions();
	public Questions getQue() {
		return que;
	}
	public void setQue(Questions que) {
		this.que=que;
	}
	@ManyToOne
	@JoinColumn(name="respondent_id")
	private Respondent respondentId;
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer=answer;
	}
	public Respondent getRespondentId() {
		return respondentId;
	}
	public void setRespondentId(Respondent respondentId) {
		this.respondentId=respondentId;
	}
	

}
