package dev.aamgasi.JobAppREST.controllers;

import dev.aamgasi.JobAppREST.model.JobPost;
import dev.aamgasi.JobAppREST.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JobPostController {

    @Autowired
    JobService service;

    @GetMapping("/jobPosts")
    public ResponseEntity<List<JobPost>> getAllJobs(){
        return new ResponseEntity<>(service.getAllJobs(), HttpStatus.OK);
    }





}
