package com.bounce.springtest.jpa;

import com.bounce.springtest.jpa.domain.JobPosting;
import com.bounce.springtest.jpa.repository.JobPostingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/jpa/jobPosting")
@Controller
public class JobPostingController {

    @Autowired
    private JobPostingRepository jobPostingRepository;

    @ResponseBody
    @GetMapping("/find")
    public List<JobPosting> findJob() {

    List<JobPosting> jobList = null;

//    jobList = jobPostingRepository.findAll();
//    jobList = jobPostingRepository.findById(8);
//    jobList = jobPostingRepository.findByCompanyId(1);
    jobList = jobPostingRepository.findByPositionAndType("웹 back-end 개발자", "정규직");
//    jobList = jobPostingRepository.findByTypeOrSalary("정규직", 9000);
//    jobList = jobPostingRepository.findTop3ByTypeOrderBySalaryDesc("계약직");
//        int minSalary = 7000;
//        int maxSalary = 8500;
//    jobList = jobPostingRepository.findBySalaryBetween(minSalary, maxSalary);
//    jobList = jobPostingRepository.findByDeadlineAndSalaryAndTypeOrderBySalaryDesc("2026-04-10", 8100, "정규직");

        return jobList;

    }



}
