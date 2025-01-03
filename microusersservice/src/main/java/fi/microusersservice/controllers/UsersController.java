package fi.microusersservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fi.microusersservice.dto.UsersDTO;
import fi.microusersservice.services.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController 
{
	@Autowired//(required = false)
	//@Qualifier("y")
	UsersService usersService;

	@GetMapping("/allUsers")
	public List<UsersDTO> allUsers()
	{
		return usersService.allUsers();
	}
	
	@GetMapping("/getUserDetails")
	public UsersDTO getUserDetails(@RequestParam("uName") String uName)
	{
		return usersService.getUserDetails(uName);
	}
	
	
}











