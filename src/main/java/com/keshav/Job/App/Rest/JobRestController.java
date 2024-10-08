package com.keshav.Job.App.Rest;

import com.keshav.Job.App.Rest.model.JobPost;
import com.keshav.Job.App.Rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@Controller
@RestController
@CrossOrigin(origins = "http://localhost:3000") //This helps to connect React UI with our API and solve problem of Cross Origin.
public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping("jobPosts")
   // @ResponseBody // When we use Controller we have to use @Response body to solve view-resolver problem ,
   //Because @Controller work with view we use @Controller alone when we have views if not we ,
   //use ResponseBody and if we want to only data then use @RestController instead of @Controller.
    public List<JobPost> getAllJobs(){
        return service.getAllJob();
    }
}
