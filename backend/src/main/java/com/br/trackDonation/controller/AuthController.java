package com.br.trackDonation.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AuthController {


	@CrossOrigin
	@GetMapping("login")
	public String authentication(@RequestParam(required=false) String username, @RequestParam(required=false) String password){
		String envVarUser = System.getenv("TRACK_USER");
		String envVarPass = System.getenv("TRACK_PASS");
		
		if(username.equals(envVarUser) && password.equals(envVarPass)){
				return "true";
			}else {
				return "false";
			}
			
		}
	}

