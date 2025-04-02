package dev.aamgasi.JobAppREST.service;


import dev.aamgasi.JobAppREST.model.JobPost;
import dev.aamgasi.JobAppREST.repo.JobRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    @Autowired
    private MongoTemplate template;

    public void addJob(JobPost jobPost){
        repo.save(jobPost);
    }

    public List<JobPost> getAllJobs(){
        return repo.findAll();
    }
    public Optional<JobPost> getJob(ObjectId id){
        return repo.findById(id);
    }
    public void updatePost(JobPost job){
        Query query = new Query(Criteria.where("id").is(new ObjectId(job.getId())));
        Update update = new Update();
        update.set("postProfile",job.getPostProfile());
        update.set("postDesc",job.getPostDesc());
        update.set("reqExperience",job.getReqExperience());
        update.set("postTechStack",job.getPostTechStack());
        template.updateFirst(query,update,JobPost.class);
    }

    public void deletePost(ObjectId id) {
        Query query = new Query(Criteria.where("id").is(id));
        template.remove(query,JobPost.class);
    }
}
