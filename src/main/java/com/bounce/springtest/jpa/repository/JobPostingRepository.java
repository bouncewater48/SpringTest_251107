package com.bounce.springtest.jpa.repository;

import com.bounce.springtest.jpa.domain.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobPostingRepository extends JpaRepository<JobPosting, Integer> {

    public List<JobPosting> findById(int id);

    public List<JobPosting> findByCompanyId(int companyId);

    public List<JobPosting> findByPositionAndType(String position, String type);

//    @Query(value="SELECT * FROM `job_posting` WHERE `type` = '정규직' OR `salary` >= 9000", nativeQuery=true)
    public List<JobPosting> findByTypeOrSalary(String type, int salary);

    public List<JobPosting> findTop3ByTypeOrderBySalaryDesc(String type);

    @Query(value="SELECT * FROM `job_posting` WHERE `salary` BETWEEN 7000 AND 8500", nativeQuery=true)
    public List<JobPosting> findBySalaryBetween(@Param("minSalary")int minSalary,@Param("maxSalary") int maxSalary);

    @Query(value="SELECT * FROM `job_posting` WHERE `deadline` > '2026-04-10' AND `salary` >= 8100 AND `type` = '정규직'", nativeQuery=true)
    public List<JobPosting> findByDeadlineAndSalaryAndTypeOrderBySalaryDesc(String deadline, int salary, String type);

}
