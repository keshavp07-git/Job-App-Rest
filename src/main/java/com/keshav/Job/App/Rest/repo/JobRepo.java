package com.keshav.Job.App.Rest.repo;
import com.keshav.Job.App.Rest.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepo extends JpaRepository <JobPost , Integer> {
    // Using Spring Data JPA for JobPost , it's type be Integer
    //changes happened belong to Spring_Data_JPA  everything described there .
    List<JobPost> findByPostProfileContainingIgnoreCaseOrPostDescContainingIgnoreCase(String postProfile, String postDesc);

    // We create a method to find post profile and description with containing any letter
    // Also it perform 2 search and pass parameter from our post in post it is postProfile and postDesc
    // Both are String in JobPost so we declare as String both
    //As it is done in Spring DQL
 }



