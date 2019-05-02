package com.example.simpleatm;

import com.example.simpleatm.entity.Account;
import com.example.simpleatm.entity.Atm;
import com.example.simpleatm.entity.User;
import com.example.simpleatm.repository.AtmRepository;
import com.example.simpleatm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
public class BootSimpleAtmApplication {
	@Autowired
	UserRepository userRepository;

	@Autowired
	AtmRepository atmRepository;

	public static void main(String[] args) {
		SpringApplication.run(BootSimpleAtmApplication.class, args);
	}

	@PostConstruct
	public void setupDbWithData(){
		User user = new User("ATMuser", null);
		Account account = new Account("main account");
		Float balance = 9999F;
		account.setBalance(balance);
		user.setAccounts(Arrays.asList(account));
		user = userRepository.save(user);

		Atm atm = new Atm("Awesome ATM", 500,200,100,50,20,10);
		atm = atmRepository.save(atm);
	}
}
