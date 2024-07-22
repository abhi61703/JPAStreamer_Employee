package com.ust.Employee_JPAStreamer.Service;


import com.ust.Employee_JPAStreamer.Model.Employee;
import com.ust.Employee_JPAStreamer.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.speedment.jpastreamer.application.JPAStreamer;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    private final JPAStreamer jpaStreamer;

    @Autowired
    public EmployeeService(final JPAStreamer jpaStreamer) {
        this.jpaStreamer = jpaStreamer;
    }


    public Map<String, List<Employee>> groupbyEmployeeByCity() {
        return jpaStreamer.stream(Employee.class)
                .collect(Collectors.groupingBy(Employee::getCity));
    }

    public List<Employee> groupbyEmployeeByPaymentTier() {
        return employeeRepository.findAll() ;
    }

    public List<Employee> saveEmployee(List<Employee> employee) {
        return employeeRepository.saveAll(employee);
    }

    public Optional<Employee> filterEmployee(String education, String gender, int experience) {
        String lowerEducation = education.toLowerCase();
        String lowerGender = gender.toLowerCase();

        return jpaStreamer.stream(Employee.class)
                .filter(employee -> employee.getEducation().toLowerCase().equals(lowerEducation) &&
                        employee.getGender().toLowerCase().equals(lowerGender) &&
                        employee.getExperienceInCurrentDomain() == experience)
                .findFirst();
    }


    public Map<String, List<Employee>> groupByEducation() {
        return jpaStreamer.stream(Employee.class)
                .collect(Collectors.groupingBy(Employee::getEducation));
    }

    public List<Employee> findEmployeesByJoiningYear(int year) {
        return jpaStreamer.stream(Employee.class)
                .filter(employee -> employee.getJoiningYear() == year)
                .collect(Collectors.toList());
    }



    public List<Employee> findEmployeesByAgeRange(Optional<Integer> minAge, Optional<Integer> maxAge) {
        return jpaStreamer.stream(Employee.class)
                .filter(employee -> minAge.map(age -> employee.getAge() >= age).orElse(true) &&
                        maxAge.map(age -> employee.getAge() <= age).orElse(true))
                .collect(Collectors.toList());
    }

    public long countByGender(String gender) {
        return jpaStreamer.stream(Employee.class)
                .filter(employee -> employee.getGender().equalsIgnoreCase(gender))
                .count();
    }

    public long countByGenderAndJoiningYear(int year, String gender) {
        return jpaStreamer.stream(Employee.class)
                .filter(employee -> employee.getJoiningYear() == year && employee.getGender().equalsIgnoreCase(gender))
                .count();
    }


}
