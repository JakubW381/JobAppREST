package dev.aamgasi.JobAppREST.service;

import dev.aamgasi.JobAppREST.model.User;
import dev.aamgasi.JobAppREST.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo repo;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);


    public User addUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }

}
