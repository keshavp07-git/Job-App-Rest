package com.keshav.Job.App.Rest;
import com.keshav.Job.App.Rest.model.JobPost;
import com.keshav.Job.App.Rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("jobPosts/{postId}") // Here we wrote the path in different style to accept value from link and
    // give the data according to it , "jobPosts/{postId}" means in jobPosts where postId is something which we give on browser this will fetch that particular data.
    public JobPost getJob(@PathVariable("postId")int postId){ //@PathVariable will help to accept value which we define in path and then service/repo(data)/return (Postman).
        return service.getPost(postId);
    }
}
