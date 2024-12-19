package com.crm.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.dto.ForgotPasswordRequest;
import com.crm.dto.LoginRequest;
import com.crm.dto.LoginResponse;
import com.crm.dto.RegistrationRequest;
import com.crm.entities.Role;
import com.crm.entities.User;
import com.crm.repository.RoleRepository;
import com.crm.repository.UserRepository;

/**
 * Service class for user management including registration, login, password reset, and handling roles.
 * Contains methods for user registration, login, password recovery, and reset.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository; // Repository for accessing user data in the database

    @Autowired
    private RoleRepository roleRepository; // Repository for accessing role data

    /**
     * Register a new user with the provided details.
     *
     * @param request The registration request containing user details (email, password, role).
     * @return A message indicating whether the registration was successful or not.
     */
    public String register(RegistrationRequest request) {
        // Check if the role exists in the database
        Optional<Role> role = roleRepository.findByName(request.getRole());

        if (role.isEmpty()) {
            return "Role Not Found Kindly Check..!"; // Return if role is not found
        }

        // Check if the email is already registered
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return "Email Has Already Registered..!"; // Return if email is already registered
        }

        // Create and save the new user
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword()); // Set user password (consider encrypting it)
        user.setRole(role.get()); // Set the user role

        userRepository.save(user); // Save the new user to the database
        return "Registration Successful...! You Can Login Now.."; // Return success message
    }

    /**
     * Log in an existing user.
     *
     * @param request The login request containing the user's email and password.
     * @return A response indicating login success or failure with role if successful.
     */
    public LoginResponse login(LoginRequest request) {
        // Find the user by email
        Optional<User> user = userRepository.findByEmail(request.getEmail());

        // If user not found or password mismatch, return failure message
        if (user.isEmpty() || !user.get().getPassword().equals(request.getPassword())) {
            return new LoginResponse("Invalid Email Or Password", null);
        }

        // Return success response with user's role if login is successful
        return new LoginResponse("Login Successful...", user.get().getRole().getName());
    }

    /**
     * Generate a password reset token and send it to the user.
     *
     * @param request The request containing the user's email to send a reset token.
     * @return A message indicating whether the reset token was generated successfully or not.
     */
    public String forgotPassword(ForgotPasswordRequest request) {
        // Find the user by email
        Optional<User> user = userRepository.findByEmail(request.getEmail());

        if (user.isPresent()) {
            // Generate a unique reset token
            String resetToken = UUID.randomUUID().toString();
            User existingUser = user.get();
            existingUser.setResetToken(resetToken); // Set the generated token for the user

            userRepository.save(existingUser); // Save the user with the reset token

            return "Reset token generated. Use this token to reset your password: " + resetToken; // Return the token
        } else {
            return "Email not registered!"; // Return if email is not found
        }
    }

    /**
     * Reset the user's password using the reset token.
     *
     * @param resetToken The token used to validate the password reset request.
     * @param newPassword The new password to set for the user.
     * @return A message indicating whether the password was successfully reset or not.
     */
    public String resetPassword(String resetToken, String newPassword) {
        // Find the user by the reset token
        Optional<User> user = userRepository.findByResetToken(resetToken);

        if (user.isPresent()) {
            // Reset the user's password and clear the reset token
            User existingUser = user.get();
            existingUser.setPassword(newPassword); // Set the new password
            existingUser.setResetToken(null); // Clear the reset token

            userRepository.save(existingUser); // Save the updated user
            return "Password Reset Successful!"; // Return success message
        } else {
            return "Token Is Expired Or Invalid Please Check...!"; // Return error if token is invalid or expired
        }
    }
}
