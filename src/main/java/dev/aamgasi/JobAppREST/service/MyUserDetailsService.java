package dev.aamgasi.JobAppREST.service;


import dev.aamgasi.JobAppREST.model.MyUserDetails;
import dev.aamgasi.JobAppREST.model.User;
import dev.aamgasi.JobAppREST.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = repo.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("Username Not Found");
        }

        return new MyUserDetails(user);
    }


}
