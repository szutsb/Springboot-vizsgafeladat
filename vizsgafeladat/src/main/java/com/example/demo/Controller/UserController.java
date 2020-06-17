package com.example.demo.Controller;

import com.example.demo.Modell.Game;
import com.example.demo.Modell.User;
import com.example.demo.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping( path = "/addUser")
    public User create(@RequestBody User u){
        return userService.create(u);
    }

    @GetMapping( path = "/getAllUsers")
    public List<User> getAll(){
        return userService.getAll();
    }

    @RequestMapping( method = RequestMethod.GET, value = "/getUser/{id}")
    public User findById(@PathVariable("id") Long userID){
        return userService.getById(userID);
    }

    @PostMapping( path = "/updateUser")
    public User update(@RequestBody User u){
        return userService.update(u);
    }

    @RequestMapping( method = RequestMethod.DELETE, value = "/deleteUser/{id}")
    public void delete(@PathVariable("id") Long userID){userService.delete(userID);
    }

    @GetMapping(value = "/getUsers/regularCustomers")
    public List<User> getRegularCustomers() {
        return userService.getRegularCustomers();
    }
}
