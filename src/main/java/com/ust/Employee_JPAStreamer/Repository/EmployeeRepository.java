package com.ust.Employee_JPAStreamer.Repository;

import com.ust.Employee_JPAStreamer.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
