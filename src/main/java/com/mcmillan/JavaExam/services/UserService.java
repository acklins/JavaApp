
package com.mcmillan.JavaExam.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.mcmillan.JavaExam.models.User;
import com.mcmillan.JavaExam.repositories.UserRepository;

	@Service
	public class UserService {
		private final UserRepository userRepository;
		
		public UserService(UserRepository userRepository) {
			this.userRepository = userRepository;
		}
		
		//--------------create---------------------
		public User createUser(User u) {
			String hashed = BCrypt.hashpw(u.getPassword(), BCrypt.gensalt());
			u.setPassword(hashed);
			return userRepository.save(u);
		}

	//------------------Read------------------------------
		public List<User> findAllUsers(){
			return userRepository.findAll();
		}
		
		public User findById(Long id) {
			return userRepository.findById(id).get();
//			Optional <User> optionalUser = userRepository.findById(id);
//			
//			if (optionalUser.isPresent()) {
//				return optionalUser.get();
//			} else {
//				return null;
//			}
			
		}
		public User findByEmail(String email) {
			return userRepository.findByEmail(email);
		}
	//-------------------Update------------------------
		public User updateUser(User u) {
			return userRepository.save(u);
		}
	//----------------------------Destroy--------------------
		public void deleteUser(User u) {
			userRepository.delete(u);
		}
	//-------------------User Authentication--------------------
		public boolean authenticateUser(String email, String password) {
			User u = userRepository.findByEmail(email);
			if(u == null) {
				return false;
			}
			else {
				if(BCrypt.checkpw(password, u.getPassword())) {
					return true;
				}
				else {
					return false;
				}
			}
		}
		
	}



