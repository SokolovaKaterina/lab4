package com.university;

import com.university.application.AppConfig;
import com.university.application.ApplicationService;
import com.university.domain.Department;
import com.university.domain.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;

public class Main implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    @Override
    public void run(String... args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        ApplicationService service = applicationContext.getBean(ApplicationService.class);

        ArrayList<String> dep_technic_rooms = new ArrayList<>();
        dep_technic_rooms.add("Room_1");
        dep_technic_rooms.add("Room_2");

        Department dep = new Department("Technic", 5, dep_technic_rooms);
        Department dep2 = new Department("Medic", 2, dep_technic_rooms);
        Employee emp = new Employee("Sokolova Ekaterina Evgenievna", "Minina, 27", "Technic", "13.06.2003", "Programmer");
        Employee emp2 = new Employee("Ivanov Ivan Ivanovich", "Belinskovo, 103", "Medic", "08.07.1996", "Doctor");

        service.addRecordDepartment(dep);
        service.addRecordDepartment(dep2);
        service.addRecordEmployee(emp);
        service.addRecordEmployee(emp2);

        myPrint(service);
        System.out.println("-----------------------------------------");
        System.out.println(" ");
        System.out.println("-----------------------------------------");

        String searchDepartmentName = "Technic";
        Department foundDepartment = service.getDepartmentByName(searchDepartmentName);

        if (foundDepartment != null) {
            System.out.println("Department with name '" + searchDepartmentName + "': " + foundDepartment);
        } else {
            System.out.println("No department found with name '" + searchDepartmentName + "'.");
        }

        System.out.println("-----------------------------------------");

        String searchLastName = "Ivanov Ivan Ivanovich";
        Employee foundEmployee = service.getEmployeeByFIO(searchLastName);

        if (foundEmployee != null) {
            System.out.println("Employee with last name '" + searchLastName + "': " + foundEmployee);
        } else {
            System.out.println("No employee found with last name '" + searchLastName + "'.");
        }

        System.out.println("-----------------------------------------");

        emp.setAddress("Gorkogo, 67");

        service.editEmployee(emp);

        service.deleteRecordDepartments(dep2);
        myPrint(service);
    }
    public void myPrint(ApplicationService service) {
        System.out.println("Departments: " + service.getRecordsDepartments());
        System.out.println("-----------------------------------------");
        System.out.println("Employees: " + service.getRecordsEmployees());
    }
}

