package com.smsapi.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.smsapi.model.AccountDetails;
import com.smsapi.model.entities.Account;
import com.smsapi.repository.AccountRepository;

@Service
public class AccountDetailsService implements UserDetailsService{
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account=accountRepository.findByUsername(username);
		if (account==null) {
			throw new UsernameNotFoundException("Username not found");
		}
		
		return new AccountDetails(account);
	}

}
