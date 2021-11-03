package com.surveybuilder.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.surveybuilder.entities.Feedback;

public interface FeedbackDao extends JpaRepository<Feedback,Integer>{

}
