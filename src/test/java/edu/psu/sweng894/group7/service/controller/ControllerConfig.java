package edu.psu.sweng894.group7.service.controller;

import edu.psu.sweng894.group7.datastore.entity.AppUser;
import edu.psu.sweng894.group7.datastore.entity.UserRoleMap;
import edu.psu.sweng894.group7.datastore.service.UserService;
import edu.psu.sweng894.group7.service.controller.model.UserModel;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

public class ControllerConfig {


    @MockBean
    UserService userService;

    @Bean
    public ParksRecServiceImpl parksRecServiceImpl()  {
        ParksRecServiceImpl parksRecServiceImpl = new ParksRecServiceImpl();
        parksRecServiceImpl.userService=userService;
        return parksRecServiceImpl;
    }

    @Bean
    public UserModel userModel() {
        UserModel userModel = new UserModel();
        userModel.setUserId(0l);
        userModel.setUsername("TestUser");
        userModel.setPassword("TestPassword");
        List<UserRoleMap> roles = new ArrayList<>();
        UserRoleMap role = new UserRoleMap();
        //role.setDescription("Test Role Description");
        role.setRoleId(0l);
        //role.setRolename("TestRole");
        roles.add(role);
        userModel.setRoles(roles);
        return userModel;
    }

    @Bean
    public AppUser appUsers() {
        AppUser appUser = new AppUser();
        appUser.setUserId(0l);
        appUser.setUsername("TestUser");
        appUser.setPassword("TestPassword");
        List<UserRoleMap> roles = new ArrayList<>();
        UserRoleMap role = new UserRoleMap();
        //role.setDescription("Test Role Description");
        role.setRoleId(0l);
        //role.setRolename("TestRole");
        roles.add(role);
        appUser.setRoles(roles);
        return appUser;
    }

}