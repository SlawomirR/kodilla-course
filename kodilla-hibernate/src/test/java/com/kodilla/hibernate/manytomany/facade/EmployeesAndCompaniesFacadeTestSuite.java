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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeesAndCompaniesFacadeTestSuite {
    private int id_0, id_1;
    private int id_emp0, id_emp1, id_emp2, id_emp3, id_emp4, id_emp5;

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

        companyDao.saveAll(companies);
        id_0 = companies.get(0).getId();
        id_1 = companies.get(1).getId();
        id_emp0 = companies.get(0).getEmployees().get(0).getId();
        id_emp2 = companies.get(0).getEmployees().get(1).getId();
        id_emp4 = companies.get(0).getEmployees().get(2).getId();
        id_emp1 = companies.get(1).getEmployees().get(0).getId();
        id_emp3 = companies.get(1).getEmployees().get(1).getId();
        id_emp5 = companies.get(1).getEmployees().get(2).getId();
    }

    @Test
    public void testFindEmployeesWithPartOfLastName() {
        // When
        String partOfLastName = "os";
        int numberOfEmployeesCompany = facade.findByEmployeesContainingPartOfLastName(partOfLastName).size();
        // Then
        try {
            Assert.assertEquals(3, numberOfEmployeesCompany);
        } finally {
            if (companyDao.existsById(id_0)) {
                System.out.println(companyDao.findById(id_0));
                companyDao.deleteById(id_0);
            }
            if (companyDao.existsById(id_1)) {
                System.out.println(companyDao.findById(id_1));
                companyDao.deleteById(id_1);
            }
            for (Integer id_emp : Arrays.asList(id_emp0, id_emp1, id_emp2, id_emp3, id_emp4, id_emp5)) {
                if (employeeDao.existsById(id_emp)) {
                    System.out.println(employeeDao.findById(id_emp));
                    employeeDao.deleteById(id_emp);
                }
            }
        }
    }

    @Test
    public void testFindCompaniesWithPartOfName() {
        // When
        String partOfName = "B";
        int numbersOfCompaniesFound = facade.findByCompaniesContainingName(partOfName).size();
        // Then
        try {
            Assert.assertEquals(1, numbersOfCompaniesFound);
        } finally {
            System.out.println(companyDao.findById(id_0));
            if (companyDao.existsById(id_0)) {
                companyDao.deleteById(id_0);
            }
            System.out.println(companyDao.findById(id_1));
            if (companyDao.existsById(id_1)) {
                companyDao.deleteById(id_1);
            }
            for (Integer id_emp : Arrays.asList(id_emp0, id_emp1, id_emp2, id_emp3, id_emp4, id_emp5)) {
                if (employeeDao.existsById(id_emp)) {
                    System.out.println(employeeDao.findById(id_emp));
                    employeeDao.deleteById(id_emp);
                }
            }
        }
    }
}
