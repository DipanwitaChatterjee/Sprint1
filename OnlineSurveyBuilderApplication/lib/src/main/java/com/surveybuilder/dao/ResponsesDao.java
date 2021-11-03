package com.surveybuilder.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.surveybuilder.entities.Responses;

public interface ResponsesDao extends JpaRepository<Responses,Integer>{

}
