package com.restaruant.app.controller;


import com.restaruant.app.entity.User;
import com.restaruant.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    UserRepository userRepository;


    @GetMapping("/user/{user_name}")
    public User getUserDetails(@PathVariable(value = "id") String user_name)
            throws Exception
    {

        return userRepository.findById(user_name).
                orElseThrow(() -> new Exception("User Details found for this username"));

    }

    @PostMapping("/signup")

    public  String saveUserDetails(@RequestBody User user)
    {
        if(userRepository.findById(user.getEmail()).isPresent())
        {
            return "User Already exists";
        }

        else{
            userRepository.save(user);

        return "User Added Sucessfully";
    }
    }

    @PostMapping("/login")
    public String checkLoginUser(@RequestBody User user)
    {

        if(userRepository.findById(user.getEmail()).isEmpty())
        {
            return "User is not Registered.";
        }
        else {
            String userid  = userRepository.findById(user.getEmail()).get().getEmail();
            String password  = userRepository.findById(userid).get().getPassword();

            System.out.println(password);
            System.out.println();

            if(password.equals(user.getPassword()))
            {
                return "Authorized";
            }
            else{
                return "Password is incorrect";
            }
        }


    }





}
