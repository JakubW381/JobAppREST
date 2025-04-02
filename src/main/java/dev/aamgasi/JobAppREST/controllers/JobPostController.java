package dev.aamgasi.JobAppREST.controllers;

import dev.aamgasi.JobAppREST.model.JobPost;
import dev.aamgasi.JobAppREST.service.JobService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class JobPostController {

    @Autowired
    JobService service;

    @GetMapping("/jobPosts")
    public ResponseEntity<List<JobPost>> getAllJobs(){
        return new ResponseEntity<>(service.getAllJobs(), HttpStatus.OK);
    }
    @GetMapping("/job/{id}")
    public ResponseEntity<Optional<JobPost>> getJob(@PathVariable ObjectId id){
        return new ResponseEntity<>(service.getJob(id), HttpStatus.OK);
    }
    @PostMapping("/add-post")
    public void addJob(@RequestBody JobPost job){
        service.addJob(job);
    }
    @PutMapping("/edit-post")
    public void updateJob(@RequestBody JobPost job){
        service.updatePost(job);
    }
    @DeleteMapping("/delete-post/{id}")
    public void deleteJob(@PathVariable ObjectId id){
        service.deletePost(id);
    }



}
