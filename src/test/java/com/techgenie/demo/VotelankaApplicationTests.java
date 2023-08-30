package com.techgenie.demo;

import com.techgenie.demo.dto.domain.User;
import com.techgenie.demo.service.inf.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VotelankaApplicationTests {
	@Autowired
	private IUserService userService;

	@Test
	void contextLoads() {
	}

	@Test
	void test(){
		userService.getAll().forEach(user -> {
			System.out.println(user.getUserName());
		});}

	@Test
	void Display(){
		userService.getAllDomains().forEach(user -> {
			System.out.println(user.getName());
		});
	}

	@Test
	void save(){
		userService.save(User.builder()
				.name("dinesha").password("45625").type(8).build());
	}
}
