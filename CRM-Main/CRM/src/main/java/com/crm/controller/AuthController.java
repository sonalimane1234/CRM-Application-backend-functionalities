//package com.crm.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.crm.dto.LoginRequest;
//import com.crm.service.AuthService;
//
//@RestController
//@RequestMapping("/crm.technothinksup.in/admin")//crm.technothinksup.in/admin/authentication
//@CrossOrigin("*")
//public class AuthController {
//
//	@Autowired
//	private AuthService authService;
//
//	// http://localhost:8080/crm.technothinksup.in/admin/authentication
//	@PostMapping("/authentication")
//	public String login(@RequestBody LoginRequest request) {
//		return authService.login(request);
//	}
//	
//	
//}
