package com.projectmanagement.dao;

import com.projectmanagement.model.Employee;

 public interface EmployeeDaoInterface {
    public boolean addEmployee(Employee e);
    public boolean delete(int id);
    public boolean update(int id, String update, int ch, Employee e);
    public void showAllEmployee();
    public boolean showEmployeeById(int id);
}
