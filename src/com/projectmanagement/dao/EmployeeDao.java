package com.projectmanagement.dao;

import com.projectmanagement.db.DBconnection;
import com.projectmanagement.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class EmployeeDao implements EmployeeDaoInterface{

    @Override
    public boolean addEmployee(Employee e) {
        boolean flag = false;

        try{
            Connection connection = DBconnection.createConnection();
            String query = "insert into employee_details(sname, lastname, age, salary) value(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,e.getName());
            preparedStatement.setString(2, e.getLastName());
            preparedStatement.setInt(3,e.getAge());
            preparedStatement.setDouble(4,e.getSalary());
            preparedStatement.executeUpdate();
            flag = true;

        }catch(Exception ex){
            ex.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean update(int id, String update, int ch, Employee e) {
        return false;
    }

    @Override
    public void showAllEmployee() {

    }

    @Override
    public boolean showEmployeeById(int id) {
        return false;
    }
}
