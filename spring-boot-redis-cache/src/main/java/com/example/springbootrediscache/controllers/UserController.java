package com.example.springbootrediscache.controllers;

import com.example.springbootrediscache.models.User;
import com.example.springbootrediscache.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/rest/user")
public class UserController {

    private UserRepository _userRepository;

    public UserController(UserRepository userRepository){
        _userRepository = userRepository;
    }

    @GetMapping("/all")
    public Map<String, User> GetAll(){
       return _userRepository.findAll();
    }

    @GetMapping("/all/{id}")
    public User GetAll(@PathVariable("id") final String id){
        return _userRepository.findById(id);
    }

    @GetMapping("/add/{id}/{name}")
    public User add(@PathVariable("id") final String id
                    ,@PathVariable("name") final String name){
        _userRepository.save(new User(id,name,80000L));
        return _userRepository.findById(id);

    }


    @GetMapping("/update/{id}/{name}")
    public User update(@PathVariable("id") final String id
            ,@PathVariable("name") final String name){
        _userRepository.update(new User(id,name,1000L));
        return _userRepository.findById(id);

    }


}
