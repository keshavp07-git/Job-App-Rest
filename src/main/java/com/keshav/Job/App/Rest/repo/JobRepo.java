package com.keshav.Job.App.Rest.repo;
import com.keshav.Job.App.Rest.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class JobRepo {
    List<JobPost> jobs = new ArrayList<>(Arrays.asList(
            new JobPost(1, "Java Dev", "Good", 2, convertStringToList("Java, Spring, Hibernate")),
            new JobPost(2, "Go Dev", "Good", 3, convertStringToList("Go, Docker")),
            new JobPost(3, "Kotlin Dev", "Good", 5, convertStringToList("Kotlin, Android"))
    ));


    public List<JobPost> getAllJobs() {
        return jobs;
    }

    public void addJob(JobPost job) {
        jobs.add(job);
        System.out.println(jobs);
    }

    private List<String> convertStringToList(String techStack) {
        return Arrays.asList(techStack.split("//s*,//s*"));
    }
    // This logic created to accept request service and as per service
    // a loop run and it get path passed value in repo or data model it will give data .

    public JobPost getJob(int postId) {
        for (JobPost job : jobs){
            if (job.getPostId() == postId)
                return job;
        }
        return null;
    }

    public void updateJob(JobPost jobPost) {
        for (JobPost jobPost1 : jobs){ // iterate the Job from Jobs if both are equal then set another value
            // which we will pass through JSON file from Postman
            // iterated variable jobPost1 PostId and JobPost PostId equal then do operations
            if(jobPost1.getPostId()==jobPost.getPostId()){
                jobPost1.setPostDesc(jobPost.getPostDesc());
                jobPost1.setPostProfile(jobPost.getPostProfile());
                jobPost1.setPostTechStack(jobPost.getPostTechStack());
                jobPost1.setReqExperience(jobPost.getReqExperience());
            }
        }
    }

    public void deleteJob(int postId) { //Here method create which take int value which will postId
        // We iterate in a variable if postId from repo and that we entered in postman is same then remove
        // that job using the postId which we entered in URL
        for (JobPost job : jobs){
            if(job.getPostId() == postId){
                jobs.remove(postId);
            }
        }
    }
}



