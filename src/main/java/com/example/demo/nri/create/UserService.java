package com.example.demo.nri.create;

import com.example.demo.nri.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User addUser(User user){

        return repo.save(user);
    }

    public List<User> findAllUsersData() {
       return  repo.findAll();
    }

    public User collectUserById(int id) {

        return repo.findById(id).orElseThrow(
                ()-> new UserNotFoundException("NO USER PRESENT WITH ID = "+id));
    }

    public void remove(int id) {
         repo.deleteById(id);
    }

    public User editUser(User user) {
     return   repo.save(user);
    }
}
