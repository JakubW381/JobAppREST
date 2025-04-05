package dev.aamgasi.JobAppREST.service;


import dev.aamgasi.JobAppREST.model.JobPost;
import dev.aamgasi.JobAppREST.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    public void addJob(JobPost jobPost){
        repo.save(jobPost);
    }

    public List<JobPost> getAllJobs(){
        return repo.findAll();
    }
    public Optional<JobPost> getJob(int id){
        return repo.findById(id);
    }
    public void updatePost(JobPost job){
        repo.save(job);
    }

    public void deletePost(int id) {
        repo.deleteById(id);
    }
    public List<JobPost> search(String keyword) {
        return repo.findByPostProfileContainingOrPostDescContaining(keyword,keyword);
    }
}
