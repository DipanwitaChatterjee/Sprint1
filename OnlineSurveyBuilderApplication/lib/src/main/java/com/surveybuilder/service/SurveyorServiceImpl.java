package com.surveyBuilder.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.surveybuilder.Dao.FeedbackDao;
import com.surveybuilder.Dao.QuestionsDao;
import com.surveybuilder.Dao.ResponsesDao;
import com.surveybuilder.Dao.SurveyDao;
import com.surveybuilder.entities.Feedback;
import com.surveybuilder.entities.Questions;
import com.surveybuilder.entities.Responses;
import com.surveybuilder.entities.Survey;

@Service
@Scope(scopeName="singleton")

public class SurveyorServiceImpl implements SurveyorService {
	@Autowired
	private SurveyDao surveydao=null;
	@Autowired
	private QuestionsDao questiondao=null;
	@Autowired
	private ResponsesDao responsesdao=null;
	@Autowired
	private FeedbackDao feedbackdao=null;

	@Override
	
	public void addSurvey(Survey survey) {
		surveydao.save(survey);
		
	}

	@Override
	
	public void addQuestion(Questions questions) {
		questiondao.save(questions);
		
	}

	@Override
	public List<Questions> findAllSurvey() {
		
		return questiondao.findAll();
	}

	@Override
	public Survey findSurveyById(int surveyId) {
		Survey x=null;
		if(surveydao.existsById(surveyId)) {
			x= surveydao.findById(surveyId).get();
		}
		return x;
		
	}

	@Override
	public void updateQuestion(int questionId, Questions questions) {
		if(questiondao.existsById(questionId)) {
			questiondao.save(questions);
		}
		
	}

	@Override
	public void removeQuestion(int questionId) {
		questiondao.deleteQuestionById(questionId);
		
	}

	@Override
	public void removeSurvey(int surveyId) {
		if(!questiondao.existsById(surveyId)) {
		surveydao.deleteSurveyById(surveyId);
		}
		
	}

	@Override
	public List<Responses> findResponsesById(int respondentId) {
		
		return responsesdao.findResponsesById(respondentId);
	}

	@Override
	public List<Feedback> findAllFeedback() {
		
		return feedbackdao.findAll();
	}

	/*
	 * @Override public Questions modifyQuestionById(int questionId, int
	 * surveyId,Questions questions) {
	 * 
	 * return questiondao.findQuestionById(questionId,surveyId); }
	 */
	
	
}
