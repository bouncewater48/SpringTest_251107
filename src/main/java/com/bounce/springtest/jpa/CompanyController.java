package com.bounce.springtest.jpa;

import com.bounce.springtest.jpa.domain.Company;
import com.bounce.springtest.jpa.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

@RequestMapping("/jpa/company")
@Controller
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @ResponseBody
    @GetMapping("/create")
    public Company addCompany() {
        Company company1 = companyService.createCompany(
                "넥손"
                , "컨텐츠 게임"
                , "대기업"
                , 3585
                , "성남시 분당구");

        Company company2 = companyService.createCompany(
                "버블팡"
                , "여신 금융업"
                , "대기업"
                , 6834
                , "서울시 송파구");

        return company1;
    }

    @ResponseBody
    @GetMapping("/update")
    public Company modifyCompany() {

        Company company = companyService.updateCompany(8,"중소기업", 34);

        return company;

    }

    @ResponseBody
    @GetMapping("/remove")
    public String removeCompany() {
        companyService.deleteCompany(10);

        return "수행 완료";
    }

}
