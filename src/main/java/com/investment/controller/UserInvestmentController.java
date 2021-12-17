package com.investment.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.investment.entity.UserAccount;
import com.investment.service.UserAccountServiceImpl;

@RestController
@RequestMapping("/api")
public class UserInvestmentController {

	@Autowired
	UserAccountServiceImpl userAccountService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserInvestmentController.class);
	

	@GetMapping("/users/{userid}/accounts")
	public List<UserAccount> getUserInestmentDetails(@PathVariable(name = "userid") Integer userId) {
		List<UserAccount> userAccountDetails = userAccountService.getUserAccountDetails(userId);
		return userAccountDetails;
	}
	
	@PostMapping("/users/accounts")
	public String addUserInestmentDetails(@RequestBody UserAccount userAccount) {
		userAccountService.addUserAccountDetails(userAccount);
		return "User added Successfully";
	}
}
