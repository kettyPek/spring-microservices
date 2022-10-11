package com.rest.webservices.socialmediademo.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rest.webservices.socialmediademo.models.User;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<User>();
	
	static {
		users.add(new User(1,"adam",LocalDate.of(1996,2,2)));
		users.add(new User(2,"arik",LocalDate.of(1992,3,4)));
		users.add(new User(3,"lina",LocalDate.of(1994,2,3)));
	}
	
	public List<User> finalAll(){
		return users;
	}
	
	public User findById(int id) {
		 return users.stream().filter(u -> u.getId() == id).findFirst().get();
	}

}
