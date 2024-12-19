//package com.crm.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.crm.dto.LoginRequest;
//import com.crm.entities.User;
//
//import com.crm.repository.UserRepository;
//
//
//
//@Service
//public class AuthService {
//
//    @Autowired
//    private UserRepository userRepository;
//    
//   
//    public String login(LoginRequest request) {
//        Optional<User> user = userRepository.findByEmail(request.getEmail());
//
//        if (user.isPresent() && user.get().getPassword().equals(request.getPassword())) {
//            return "Login Successfull";
//        } else if (user.isPresent()) {
//            return "Invalid Password";
//        } else {  
//            return "Email Is Not Registered";
//        }
//    }
//    
//    public List<User>getAllUsers(){
//    	return userRepository.findAll();
//    }
//    
//    
//}
