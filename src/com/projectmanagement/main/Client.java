package com.projectmanagement.main;

import com.projectmanagement.dao.EmployeeDao;
import com.projectmanagement.dao.EmployeeDaoInterface;
import com.projectmanagement.model.Employee;

import java.util.Scanner;

public class Client {

    public static void main(String[] args){

        EmployeeDaoInterface dao = new EmployeeDao();
        //Scanner -> allows to obtain primitive data input.
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Employee Management Application");

        while(true){
            System.out.println("\n1.Add Employee" +
                    "\n2.Show All Employees" +
                    "\n3.Get Employee by Id" +
                    "\n4.Delete Employee by Id" +
                    "\n5.Update Employee by Id" +
                    "\n6.Exit Application");

            System.out.println("Enter choice: ");
            int ch = sc.nextInt(); // method to read data of type integer.

            switch (ch){
                case 1:
                    System.out.println("Add an Employee.");
                    System.out.println("Enter name: ");
                    String name = sc.next();
                    System.out.println("Enter last name: ");
                    String lastName = sc.next();
                    System.out.println("Enter age: ");
                    int age = sc.nextInt();
                    System.out.println("Enter salary: ");
                    double salary = sc.nextDouble();
                    Employee e = new Employee(name, lastName, age, salary);
                    boolean answerDao = dao.addEmployee(e);

                    if(!answerDao){
                        System.out.println("Something went wrong! Please try again!");
                    }

                    System.out.println("Employee inserted successfully!!");
                    break;
                case 2:
                    System.out.println("show all");
                    dao.showAllEmployee();
                    break;
                case 3:
                    System.out.println("get emp by id");
                    break;
                case 4:
                    System.out.println("delete");
                    break;
                case 5:
                    System.out.println("update");
                    break;
                case 6:
                    System.out.println("exit");
                    System.exit(0);
                default:
                    System.out.println("Error! Enter the correct option");
                    break;
            }
        }
    }
}
