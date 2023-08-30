package com.techgenie.demo;

import com.techgenie.demo.dto.domain.User;
import com.techgenie.demo.dto.model.UserType;
import com.techgenie.demo.repository.UserRepository;
import com.techgenie.demo.repository.UserTypeRepository;
import com.techgenie.demo.service.inf.IUserService;
import com.techgenie.demo.service.inf.IUserTypeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VotelankaApplicationTests {
	@Autowired
	private IUserService userService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserTypeRepository userTypeRepository;

	@Autowired
	private IUserTypeService userTypeService;

	@Test
	void contextLoads() {
	}

	@Test
	void test(){
		userRepository.findAll().forEach(user -> {
			System.out.println(user.getTypes().getType());
		});}

	@Test
	void saveType() {
		userTypeService.saveTypes(UserType.builder()
				.type("admin")
				.build());
	}

	@Test
	void Display(){
//		userService.getAllDomains().forEach(user -> {
//			System.out.println(user.getName());
//		});
		userTypeRepository.findAll().forEach(userType -> {
			System.out.println(userType.getType());
		});
	}

	@Test
	void save(){
		userService.save(User.builder()
				.name("mushthak").password("45625").types(userTypeService.findById(1)).build());
	}
}
