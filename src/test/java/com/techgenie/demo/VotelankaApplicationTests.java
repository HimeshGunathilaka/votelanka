package com.techgenie.demo;

import com.techgenie.demo.dto.model.UserType;
import com.techgenie.demo.repository.AreaRepository;
import com.techgenie.demo.repository.PartyRepository;
import com.techgenie.demo.repository.UserRepository;
import com.techgenie.demo.repository.UserTypeRepository;
import com.techgenie.demo.service.inf.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class VotelankaApplicationTests {
    List<String> list = new ArrayList<>();
    @Autowired
    private IUserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AreaRepository areaRepository;
    @Autowired
    private UserTypeRepository userTypeRepository;
    @Autowired
    private IUserTypeService userTypeService;
    @Autowired
    private IPartyService partyService;
    @Autowired
    private IAreaService areaService;
    @Autowired
    private PartyRepository partyRepository;
    @Autowired
    private IImageService imageService;

    @Test
    void displayAreas() {
//        areaService.findAreaByName("Galle");
        areaService.findAllAreas().forEach(area -> {
//            System.out.println(area.getAreaName());
        });
    }

    @Test
    void contextLoads() {
        imageService.findAllImages().forEach(imageData -> {
            System.out.println(Arrays.toString(imageData));
        });
    }


    @Test
    void displayListElements() {
        this.validateList("user1");
        this.validateList("user2");
        this.validateList("user3");
        this.validateList("user4");
        this.validateList("user5");
        this.validateList("user6");
        this.validateList("user7");
        this.validateList("user8");
        this.validateList("user9");
        this.validateList("user10");
        this.validateList("user11");
        this.validateList("user12");
    }

    @Test
    void validateList(String data) {
        if (list.size() < 10) {
            list.add(data);
            System.out.println(list);
        } else {
            System.out.println("### list is cleared here ! ###");
            //push data to database before clearing the list.
            list.clear();
            list.add(data);
        }
    }

    @Test
    void test() {
//        partyService.findAllParties().forEach(party -> {
//            System.out.println(party.getId());
//            System.out.println(party.getNo());
//            System.out.println(party.getName());
//            System.out.println(party.getImage());
//        });
//        System.out.println(areaService.findAreaByName("Colombo").getName());
    }

    @Test
    void saveType() {
        userTypeService.saveTypes(UserType.builder()
                .type("admin")
                .build());
    }

    @Test
    void Display() {
        userService.findAllUsers().forEach(user -> {
            System.out.println(user.getId());
            System.out.println(user.getName());
            System.out.println(user.getTypes());
            System.out.println(user.getArea());
            System.out.println(user.getPhone());
        });
    }

    @Test
    void save() {
//		userService.save(User.builder()
//				.name("mushthak").password("45625").types(userTypeService.findById(1)).build());
    }
}
