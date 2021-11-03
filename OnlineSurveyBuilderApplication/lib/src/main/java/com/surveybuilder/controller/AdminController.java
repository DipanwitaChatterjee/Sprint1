package com.surveybuilder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.surveybuilder.entities.Admin;
import com.surveybuilder.entities.Feedback;
import com.surveybuilder.entities.Responses;
import com.surveybuilder.entities.Surveyor;
import com.surveybuilder.service.AdminService;

@RestController
@RequestMapping(path = "admin")
public class AdminController {
	@Autowired
	private AdminService service = null;

	@PostMapping(path = "{admin")
	public void createAdminController(@RequestBody Admin admin) {
		service.createAdmin(admin);
	}
	@PostMapping(path="surveyor")
	public void createSurveyor(@RequestBody Surveyor surveyor) {
		service.createSurveyor(surveyor);
	}
	
}