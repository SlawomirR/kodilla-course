package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class EmployeesAndCompaniesFacadeTestSuite {
//    private int id_0;
//    private int id_1;

    @Autowired
    private EmployeesAndCompaniesFacade facade;

    @Autowired
    CompanyDao companyDao;

    @Autowired
    EmployeeDao employeeDao;

    @Before
    public void prepareTestData() {
        // Given
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("FirstName_1", "Last_1"));
        employees.add(new Employee("FirstName_2", "Lost_2"));
        employees.add(new Employee("FirstName_3", "Last_3"));
        employees.add(new Employee("FirstName_4", "Lost_4"));
        employees.add(new Employee("FirstName_5", "Last_5"));
        employees.add(new Employee("FirstName_6", "Lost_6"));

        List<Company> companies = new ArrayList<>();
        companies.add(new Company("Test company A"));
        companies.add(new Company("Test company B"));

        companies.get(0).setEmployees(employees.get(0));
        companies.get(0).setEmployees(employees.get(2));
        companies.get(0).setEmployees(employees.get(4));
        companies.get(1).setEmployees(employees.get(1));
        companies.get(1).setEmployees(employees.get(3));
        companies.get(1).setEmployees(employees.get(5));

        companyDao.save(companies);
//        id_0 = companies.get(0).getId();
//        id_1 = companies.get(1).getId();
    }

    @Test
    public void testFindEmployeesWithPartOfLastName() {
        // When
        String partOfLastName = "os";
        int numberOfEmployeesCompany = facade.findByEmployeesContainingPartOfLastName(partOfLastName).size();
        // Then
//        try {
            Assert.assertEquals(3, numberOfEmployeesCompany);
//        } finally {
//            companyDao.delete(id_0);
//            companyDao.delete(id_1);
//        }
    }

    @Test
    public void testFindCompaniesWithPartOfName() {
        // When
        String partOfName = "B";
        int numbersOfCompaniesFound = facade.findByCompaniesContainingName(partOfName).size();
        // Then
//        try {
            Assert.assertEquals(1, numbersOfCompaniesFound);
//        } finally {
//            companyDao.delete(id_0);
//            companyDao.delete(id_1);
//        }
    }
}

