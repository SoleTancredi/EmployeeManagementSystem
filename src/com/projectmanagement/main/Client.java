package com.projectmanagement.main;

import java.util.Scanner;

public class Client {

    public static void main(String[] args){

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
                    System.out.println("add employee");
                    break;
                case 2:
                    System.out.println("show all");
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
