package com.rest.webservices.socialmediademo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.webservices.socialmediademo.dao.UserDaoService;
import com.rest.webservices.socialmediademo.models.User;

@RestController
@RequestMapping("/users")
public class UserResource {
	
	@Autowired
	private UserDaoService userDao;
	
	@GetMapping()
	public List<User> retriveAllUsers(){
		return userDao.finalAll();
	}
	
	@GetMapping("/{id}")
	public User getUser(@PathVariable int id){
		return userDao.findById(id);
	}
	
	@PostMapping()
	public void createUser(@RequestBody User user) {
		userDao.createUser(user);
	}

}
