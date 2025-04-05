package dev.aamgasi.JobAppREST.repo;


import dev.aamgasi.JobAppREST.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
