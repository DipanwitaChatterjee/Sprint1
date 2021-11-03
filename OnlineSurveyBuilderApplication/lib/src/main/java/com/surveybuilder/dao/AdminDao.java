package com.surveybuilder.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.surveybuilder.entities.Admin;
import com.surveybuilder.entities.Surveyor;


@Repository
public interface AdminDao extends JpaRepository<Admin, Integer> {
	Surveyor save(Surveyor surveyor);
	
}
