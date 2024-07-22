package com.ust.Employee_JPAStreamer.Controller;

import com.ust.Employee_JPAStreamer.Model.Employee;
import com.ust.Employee_JPAStreamer.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/save")
    public List<Employee> saveEmployee(@RequestBody List<Employee> employee){
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/groupByCity")
    public Map<String, List<Employee>> groupbyEmployeeByCity(){
        return employeeService.groupbyEmployeeByCity();
    }
    @GetMapping("/findall")
    public List<Employee> groupbyEmployeeByPaymentTier(){
        return employeeService.groupbyEmployeeByPaymentTier();
    }

    @GetMapping("/filterEmployee")
    public Optional<Employee> filterEmployee(@RequestParam String education,
                                             @RequestParam String gender,
                                             @RequestParam int experience) {
        return employeeService.filterEmployee(education, gender, experience);
    }

    @GetMapping("/groupByEducation")
    public Map<String, List<Employee>> groupByEducation() {
        return employeeService.groupByEducation();
    }

    @GetMapping("/findByJoiningYear/{year}")
    public List<Employee> findEmployeesByJoiningYear(@PathVariable int year) {
        return employeeService.findEmployeesByJoiningYear(year);
    }



    @GetMapping("/findByAgeRange")
    public List<Employee> findByAgeRange(@RequestParam Optional<Integer> minAge,
                                         @RequestParam Optional<Integer> maxAge) {
        return employeeService.findEmployeesByAgeRange(minAge, maxAge);
    }

    @GetMapping("/countByGender")
    public long countByGender(@RequestParam String gender) {
        return employeeService.countByGender(gender);
    }

    @GetMapping("/countByGenderAndJoiningYear")
    public long countByGenderAndJoiningYear(@RequestParam int year, @RequestParam String gender) {
        return employeeService.countByGenderAndJoiningYear(year, gender);
    }

}
