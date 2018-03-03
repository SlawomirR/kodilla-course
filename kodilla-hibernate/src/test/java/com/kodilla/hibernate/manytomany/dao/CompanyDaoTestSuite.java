package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTestSuite {
    @Autowired
    CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void testSaveManyToMany(){
        // Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");
        Employee michaelKovalsky = new Employee("Michael", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company softwareGarbage = new Company("Software Garbage");
        Company dataMasters = new Company("Data Masters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        softwareMachine.getEmployees().add(michaelKovalsky);
        dataMasters.getEmployees().add(stephanieClarckson);
        dataMasters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMasters);
        lindaKovalsky.getCompanies().add(dataMasters);
        lindaKovalsky.getCompanies().add(greyMatter);
        michaelKovalsky.getCompanies().add(softwareMachine);
        // When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(softwareGarbage);
        int softwareGarbageId = softwareGarbage.getId();
        companyDao.save(dataMasters);
        int dataMaestersId = dataMasters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();
        List<Employee> findingKovalsky = employeeDao.retrieveEmployeesWithName("Kovalsky");
        List<Company> findPartialCompanyName = companyDao.findPartialCompanyName("Sof%");
        // Then
        Assert.assertNotEquals(0, softwareMachineId);
        Assert.assertNotEquals(0, dataMaestersId);
        Assert.assertNotEquals(0, greyMatterId);
        Assert.assertEquals(2, findingKovalsky.size());
        Assert.assertEquals(2, findPartialCompanyName.size());
        findingKovalsky.stream().forEach(s -> System.out.println(s.getLastname() + " " + s.getFirstname()));
        findPartialCompanyName.stream().forEach(s -> System.out.println(s.getName()));

        // CleanUp
        try {
        	companyDao.delete(softwareMachineId);
        	companyDao.delete(softwareGarbageId);
        	companyDao.delete(dataMaestersId);
        	companyDao.delete(greyMatterId);
        } catch (Exception e) {
        	//do nothing
        }
    }
}
