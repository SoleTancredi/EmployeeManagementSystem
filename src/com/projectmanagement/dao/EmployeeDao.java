package com.projectmanagement.dao;

import com.projectmanagement.db.DBconnection;
import com.projectmanagement.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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
        try{
            Connection connection = DBconnection.createConnection();
            String query = "select * from employee_details";
            //Statement is used to process a static SQL statement and obtain the results produced by it.
            Statement statement = connection.createStatement();
            //Interface ResultSet
            //Used to store the data that is returned from the database table after the execution of SQL statements.
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                System.out.println("ID: " + resultSet.getInt(1) +"\n" + "Name: " + resultSet.getString(2) + "\n" +
                        "Last Name: " + resultSet.getString(3) + "\n" +
                        "Age: " + resultSet.getInt(4) + "\n" +
                        "Salary: " + resultSet.getDouble(5));
                System.out.println("--------------------------------------------------------");
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public boolean showEmployeeById(int id) {
        boolean flag = false;
        try{
            Connection connection = DBconnection.createConnection();
            String query = "select * from employee_details where id="+id;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                System.out.println("ID: " + resultSet.getInt(1) +"\n" + "Name: " + resultSet.getString(2) + "\n" +
                        "Last Name: " + resultSet.getString(3) + "\n" +
                        "Age: " + resultSet.getInt(4) + "\n" +
                        "Salary: " + resultSet.getDouble(5));
                flag = true;
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }

        return flag;
    }
}
