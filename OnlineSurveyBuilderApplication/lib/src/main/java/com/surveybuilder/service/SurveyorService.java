package com.surveybuilder.service;

import com.surveybuilder.entities.Feedback;
import com.surveybuilder.entities.Questions;
import com.surveybuilder.entities.Responses;
import com.surveybuilder.entities.Survey;

public interface SurveyorService {

  public void addSurvey(Survey survey);
	public void addQuestion(Questions questions);
	public List<Questions> findAllSurvey();
	public Survey findSurveyById(int surveyId);
	public void updateQuestion(int questionId, Questions questions);
	public void removeQuestion(int questionId);
	public void removeSurvey(int surveyId);
	public List<Responses> findResponsesById(int respondentId);
	public List<Feedback> findAllFeedback();
}
