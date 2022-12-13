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
                    System.out.println("<<< Add an Employee >>>");
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
                        System.out.println(" -> Something went wrong! Please try again!");
                    }

                    System.out.println(" -> Employee inserted successfully!!");
                    break;
                case 2:
                    System.out.println("<<< List of Employees >>>");
                    dao.showAllEmployee();
                    break;
                case 3:
                    System.out.println("<<< Find by Id >>>");
                    System.out.println("Enter Employee ID:");
                    int idFind = sc.nextInt();
                    boolean findId = dao.showEmployeeById(idFind);
                    if(!findId){
                        System.out.println(" -> The id it doesn´t exist.");
                    }
                    break;
                case 4:
                    System.out.println("<<< Delete >>>");
                    System.out.println("Enter Employee ID: ");
                    int idDelete = sc.nextInt();
                    boolean deleteId = dao.delete(idDelete);
                    if(!deleteId){
                        System.out.println(" -> The id it doesn´t exist. ");
                    }else{
                        System.out.println(" -> Employee delete successfully!");
                    }
                    break;
                case 5:
                    System.out.println("<<< Update >>>");
                    System.out.println("<<< Enter one option: >>>");
                    System.out.println("\n1.Name\n2.Salary");
                    int choiceUpdate = sc.nextInt();

                        if(choiceUpdate == 1) {
                            System.out.println("Enter Employee ID: ");
                            int idUpdate = sc.nextInt();
                            System.out.println("Enter new name: ");
                            String sname = sc.next();
                            Employee employee = new Employee();
                            employee.setName(sname);
                            boolean flag = dao.update(idUpdate, sname, choiceUpdate, employee);
                            if (!flag) {
                                System.out.println("Something went wrong, try again!");

                            } else {
                                System.out.println("Last name updated successfully!!");
                            }
                        }
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
