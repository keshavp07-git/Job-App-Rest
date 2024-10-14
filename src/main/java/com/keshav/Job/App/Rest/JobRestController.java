package com.keshav.Job.App.Rest;
import com.keshav.Job.App.Rest.model.JobPost;
import com.keshav.Job.App.Rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
//@Controller
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping(path = "jobPosts" , produces = {"application/json"})


    public List<JobPost> getAllJobs(){
        return service.getAllJob();
    }


    @GetMapping("jobPosts/{postId}")
    public JobPost getJob(@PathVariable("postId")int postId){
        return service.getPost(postId);
    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword){
        return service.search(keyword);
    }
    // Here we created a controller which works with keywords
    // And it calls service with search method also take parameter which is keyword which we want to search.


    @PostMapping(path="jobPosts",consumes = {"application/json"})
    public JobPost addPost(@RequestBody JobPost jobPost ){
        service.addJob(jobPost);
        return service.getPost(jobPost.getPostId());
    }

    @PutMapping("jobPosts") // PutMapping for update
    public JobPost updateJob(@RequestBody JobPost jobPost){
      service.updateJob(jobPost);
      return service.getPost(jobPost.getPostId());
    };
    @DeleteMapping("jobPosts/{postId}")
    public String deleteJob(@PathVariable int postId){
        service.deleteJob(postId);
        return "Deleted";
    }
    @GetMapping("load") //create a controller to call load data service
    // When we hit url localhost:8080/load in postman it will insert the data in database.
    // otherwise we will see blank table in pg Admin
    public String loadData(){
        service.load();
        return "Success";
    }

}
