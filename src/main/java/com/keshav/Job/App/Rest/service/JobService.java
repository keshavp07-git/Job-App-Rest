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

        //This logic is created to add data to repo with class JobPost and object of its jobPost
        // then logic called and perform activity

    }
    public List<JobPost> getAllJob (){
        return repo.getAllJobs();

        //This logic created to get all jobs from List that JobPost
    }

    public JobPost getPost(int postId){
        return repo.getJob(postId);
    } // This logic is created to return a single post means a single data
    // from data model but it accepts int value which we will pass in path

    public void updateJob(JobPost jobPost) {
        repo.updateJob(jobPost);
    }
    //This logic is created to update repo with class JobPost and object of its jobPost
    // then logic called and perform activity

    public void deleteJob(int postId) {
        repo.deleteJob(postId);
        //This logic is created to delete data from  repo with class JobPost and object of its jobPost
        // then logic called and perform activity
    }
}
