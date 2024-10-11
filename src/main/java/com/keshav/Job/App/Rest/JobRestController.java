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

    @GetMapping(path = "jobPosts" , produces = {"application/json"})
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

    @PostMapping(path="jobPosts",consumes = {"application/xml"}) // We use @PostMapping to get data from client
    public JobPost addPost(@RequestBody JobPost jobPost ){ // Create controller for addJob method
        // with @RequestBody it stores client data into object that we created here JobPost and object jobPost.
        service.addJob(jobPost); // Here we call service with addJob method and pass that object which all client data (jobPost).
        return service.getPost(jobPost.getPostId()); // here we also return service with getPost method which use jobPost method to give job and also
        // use getPostId method to get proper input in Postman console that what we input.
    }

    @PutMapping("jobPosts") // PutMapping for update
    public JobPost updateJob(@RequestBody JobPost jobPost){ // Method created and store value as object.
      service.updateJob(jobPost); // now call update method to insert data as object. in repo
      return service.getPost(jobPost.getPostId()); //return the values which we changed with method it will show on console of postman
    };
    @DeleteMapping("jobPosts/{postId}")// Delete mapping is for accept delete request
    public String deleteJob(@PathVariable int postId){ //created a String method which return string if our service or repo method work properly,
        service.deleteJob(postId); //it calls the service with of postID which will be integer.
        return "Deleted"; //here the message return.
    }
}
