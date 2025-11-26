package com.bounce.springtest.jpa.repository;

import com.bounce.springtest.jpa.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
    List<Company> name(String name);
}
