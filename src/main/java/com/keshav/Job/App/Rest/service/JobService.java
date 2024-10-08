package com.keshav.Job.App.Rest.service;

import com.keshav.Job.App.Rest.model.JobPost;
import com.keshav.Job.App.Rest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class JobService {

    @Autowired
    private JobRepo repo;
    public void addJob(JobPost jobPost){
        repo.addJob(jobPost);


    }
    public List<JobPost> getAllJob (){
        return repo.getAllJobs();
    }

    public JobPost getPost(int postId){
        return repo.getJob(postId);
    } // This logic is created to return a single post means a single data
    // from data model but it accepts int value which we will pass in path
}
