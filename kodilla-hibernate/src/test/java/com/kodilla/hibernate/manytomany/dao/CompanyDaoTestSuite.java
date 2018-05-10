package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTestSuite {
    @Autowired
    CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Transactional
    @Test
    public void testSaveManyToMany(){
        // Given
        long companyDaoInitial = companyDao.count();
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
        int dataMastersId = dataMasters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();
        List<Employee> findingKovalsky = employeeDao.retrieveEmployeesWithName("Kovalsky");
        List<Company> findPartialCompanyName = companyDao.findPartialCompanyName("Sof%");
        // Then
        try {
            Assert.assertNotEquals(0, softwareMachineId);
            Assert.assertNotEquals(0, dataMastersId);
            Assert.assertNotEquals(0, softwareGarbageId);
            Assert.assertNotEquals(0, greyMatterId);
            Assert.assertEquals(2, findingKovalsky.size());
            Assert.assertEquals(2, findPartialCompanyName.size());
            findingKovalsky.forEach(s -> System.out.println(s.getLastName() + " " + s.getFirstName()));
            findPartialCompanyName.forEach(s -> System.out.println(s.getName()));

        /*} catch (Exception e) {
            // do nothing*/
        } finally {
            // CleanUp
            if (companyDao.existsById(softwareMachineId)) {
                System.out.println(companyDao.findById(softwareMachineId));
                companyDao.deleteById(softwareMachineId);
            }
            if (companyDao.existsById(softwareGarbageId)) {
                System.out.println(companyDao.findById(dataMastersId));
                companyDao.deleteById(softwareGarbageId);
            }
            if (companyDao.existsById(dataMastersId)) {
                System.out.println(companyDao.findById(softwareGarbageId));
                companyDao.deleteById(dataMastersId);
            }
            if (companyDao.existsById(greyMatterId)) {
                System.out.println(companyDao.findById(greyMatterId));
                companyDao.deleteById(greyMatterId);
            }
            companyDao.findAll().forEach(System.out::println);
            long companyDaoEnd = companyDao.count();
            Assert.assertEquals(companyDaoInitial, companyDaoEnd);
        }
    }
}
