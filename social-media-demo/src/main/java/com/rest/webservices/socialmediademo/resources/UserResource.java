package com.rest.webservices.socialmediademo.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rest.webservices.socialmediademo.dao.UserDaoService;
import com.rest.webservices.socialmediademo.exceptions.UserNotFoundException;
import com.rest.webservices.socialmediademo.models.User;

@RestController
@RequestMapping("/users")
public class UserResource {

	@Autowired
	private UserDaoService userDao;

	@GetMapping()
	public List<User> retriveAllUsers() {
		return userDao.finalAll();
	}

	@GetMapping("/{id}")
	public EntityModel<User> getUser(@PathVariable int id) {
		User user = userDao.findById(id);

		if (user == null)
			throw new UserNotFoundException("id:" + id);

		EntityModel<User> entityModel = EntityModel.of(user);

		// Creating link to specific method
		WebMvcLinkBuilder link = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retriveAllUsers());
		
		// Adding the link to entity model
		entityModel.add(link.withRel("all-users"));
		
		return entityModel;
	}

	@PostMapping()
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = userDao.createUser(user);
		// creating Location header
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();

	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable int id) {
		userDao.deleteById(id);

	}

}
