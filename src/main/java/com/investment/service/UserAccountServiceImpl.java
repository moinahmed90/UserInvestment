package com.investment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.investment.entity.UserAccount;
import com.investment.repository.UserAccountRepository;

@Service
public class UserAccountServiceImpl {

	@Autowired
	UserAccountRepository userAccountRepository;
	
	public List<UserAccount> getUserAccountDetails(Integer userId){
		List<UserAccount> userAccount = userAccountRepository.findByUserId(userId);
		return userAccount;
	}

	public void addUserAccountDetails(UserAccount userAccount) {
		userAccountRepository.save(userAccount);
		
	} 
}
