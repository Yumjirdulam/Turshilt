package com.resource.user.controller;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.resource.user.dao.UserDao;
import com.resource.user.model.User;

@RestController
@RequestMapping("/user")
public class UserController {

	
	@Autowired
	UserDao userDao;
	
	@RequestMapping(value="/list")
	public List<User> getAll(){
		return userDao.getAll();
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ResponseEntity<String> save(@RequestBody User user){
		long id = userDao.save(user);
	    return new ResponseEntity<String>("New has been saved with ID:" + id,HttpStatus.OK);
	}
	
	@RequestMapping(value="/update/{id}",method=RequestMethod.PUT)
	public ResponseEntity<String> update(@PathVariable("id") long id,@RequestBody User user){
		userDao.update(user);
		return new ResponseEntity<String>("Updated:" + id,HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("id") long id){
		User user = new User();
		user.setId(id);
		userDao.delete(user);
		return new ResponseEntity<String>("Updated:" + id,HttpStatus.OK);
	}
}
