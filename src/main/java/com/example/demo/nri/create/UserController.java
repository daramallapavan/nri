package com.example.demo.nri.create;

import com.example.demo.nri.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/add")
    public ResponseEntity<User> createUser(@RequestBody User user){

        return new ResponseEntity<>(service.addUser(user), HttpStatus.CREATED);
    }

    @GetMapping("getAllUsers")
    public List<User> getAllUsers(){
        return service.findAllUsersData();
    }

    @GetMapping("getUser/{id}")
    public User getParticularUserById(@PathVariable int id){
       return  service.collectUserById(id);


    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable  int id){
        service.remove(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("edit")
    public String updateUser(@RequestBody User user){
         service.editUser(user);
        return "Updated";
    }
}
