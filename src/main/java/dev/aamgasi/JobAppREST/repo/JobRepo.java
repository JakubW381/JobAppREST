package dev.aamgasi.JobAppREST.repo;

import dev.aamgasi.JobAppREST.model.JobPost;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepo extends MongoRepository<JobPost, ObjectId> {
    List<JobPost> findAll();
}
