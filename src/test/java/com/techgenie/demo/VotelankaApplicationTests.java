package com.techgenie.demo;

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
	void test(){userService.getAll();}
}
