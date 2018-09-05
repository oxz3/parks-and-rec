package edu.psu.sweng894.group7.datastore.service.controller;

import edu.psu.sweng894.group7.datastore.service.controller.model.TestModel;
import edu.psu.sweng894.group7.datastore.service.controller.model.UserModel;
import edu.psu.sweng894.group7.datastore.service.datastore.entity.AppUser;
import edu.psu.sweng894.group7.datastore.service.datastore.service.UserService;
import edu.psu.sweng894.group7.datastore.service.service.ParksRecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/services/v1")
public class ParksRecServiceImpl  implements ParksRecService{


    @Autowired
    private UserService userService;

    //start of example services
    @Override
    public String get() throws Exception {
        return "Example of get call";
    }

    @Override
    public TestModel put (@PathVariable("id") String id, @RequestParam(value="name", required=false) String name, @RequestBody TestModel model ) throws Exception{
        return  model;
    }

    @Override
    public String delete(@RequestParam(name="name", required=false, defaultValue="Have a nice Day") String name){
        return "deleted";
    }

    @Override
    public TestModel post(@PathVariable("id") String id,@RequestBody TestModel model ) {
       return model;

    }
    //End of example services


    @Override
    public UserModel getUser(String userName) throws Exception {
        UserModel user=null;
        try {
            List<AppUser> users=userService.findAll();
            for(AppUser tempuser: users){
                if(tempuser.getName().equalsIgnoreCase(userName)){
                    user= new UserModel();
                    user.setId(tempuser.getId());
                    user.setUsername(tempuser.getName());
                    String roleNames="";
                    user.setRoles(tempuser.getRoles());
                    break;
                }
            }
             System.out.println("Found user"+ user);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return user;
    }

    @RequestMapping(path="addUser", method=RequestMethod.POST,consumes= MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public UserModel addUser(@RequestBody UserModel userModel) throws Exception{
        AppUser user = new AppUser();
        user.setPassword(userModel.getPassword());
        user.setRoles(userModel.getRoles());
        user.setUsername(userModel.getUsername());
        userService.insert(user);
        return getUser(userModel.getUsername());

    }
   //start of project services


}