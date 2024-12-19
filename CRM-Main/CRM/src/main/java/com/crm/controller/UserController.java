package com.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.crm.dto.ForgotPasswordRequest;
import com.crm.dto.LoginRequest;
import com.crm.dto.LoginResponse;
import com.crm.dto.RegistrationRequest;
import com.crm.service.UserService;

/**
 * REST controller for user management. Handles user registration, login, and
 * password management functionalities.
 */
@RestController
@RequestMapping("/crm.technothinksup.in/admin")
@CrossOrigin("*") // Allow cross-origin requests from all domains
public class UserController {

	@Autowired
	private UserService userService; // Service layer for handling user-related business logic

	/**
	 * Register a new user.
	 *
	 * @param request The registration request containing user details.
	 * @return A confirmation message for successful registration.
	 */
	@PostMapping("/register")
	public String register(@RequestBody RegistrationRequest request) {
		return userService.register(request);
	}

	/**
	 * Log in a user.
	 *
	 * @param request The login request containing username and password.
	 * @return A response containing user details and authentication information.
	 */
	@PostMapping("/login")
	public LoginResponse login(@RequestBody LoginRequest request) {
		return userService.login(request);
	}

	/**
	 * Handle the "forgot password" functionality.
	 *
	 * @param request The forgot password request containing the user's email.
	 * @return A confirmation message indicating that a password reset link has been
	 *         sent.
	 */
	@PostMapping("/forgot-password")
	public String forgotPassword(@RequestBody ForgotPasswordRequest request) {
		return userService.forgotPassword(request);
	}

	/**
	 * Reset the user's password.
	 *
	 * @param resetToken  The token sent to the user's email for password reset.
	 * @param newPassword The new password provided by the user.
	 * @return A confirmation message indicating whether the password reset was
	 *         successful.
	 */
	@PostMapping("/reset-password")
	public String resetPassword(@RequestParam String resetToken, @RequestParam String newPassword) {
		return userService.resetPassword(resetToken, newPassword);
	}
}
