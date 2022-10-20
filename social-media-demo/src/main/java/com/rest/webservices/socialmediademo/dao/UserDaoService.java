package com.rest.webservices.socialmediademo.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rest.webservices.socialmediademo.models.User;

@Component
public class UserDaoService {
	
	private static Integer usersCount = 0;
	
	private static List<User> users = new ArrayList<User>();
	
	static {
		users.add(new User(usersCount++,"adam",LocalDate.of(1996,2,2),null));
		users.add(new User(usersCount++,"arik",LocalDate.of(1992,3,4),null));
		users.add(new User(usersCount++,"lina",LocalDate.of(1994,2,3),null));
	}
	
	public List<User> finalAll(){
		return users;
	}
	
	public User findById(int id) {
		 return users.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
	}
	
	public User createUser(User user) {
		user.setId(usersCount++);
		users.add(user);
		return user;
	}
	
	public void deleteById(int id) {
		users.removeIf(u -> u.getId() == id);
	}

}
