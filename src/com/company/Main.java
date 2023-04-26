package com.company;

import java.sql.*;
import java.time.*;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {

        Statement myStmt = null;
        ResultSet myRs = null;
        Scanner sc = new Scanner(System.in);
        String durl = "jdbc:mysql://localhost:3306/users";
        String user = "root";
        String pass = "1234";
        try (Connection myConn = DriverManager.getConnection(durl, user, pass)) {

            User_service user_service = new User_service();
            System.out.println("\n**************************\npress 1 to add user \n" +
                    "press 2 to delete one user\n" +
                    "press 3 to get user \n" +
                    "press 4 to get all users " +
                    "press 5 to update one user ");
            int i = sc.nextInt();
            switch (i) {
                case 1:
                    System.out.println("adduser");
                    System.out.println("enter basic information about user:");
                    System.out.println("the id");
                    int id = sc.nextInt();
                    System.out.println("the user name number");
                    String username = sc.next();
                    System.out.println("the password number");
                    String password = sc.next();
                    System.out.println("the phone number");
                    int phone = sc.nextInt();
                    System.out.println("Enter the birth date");
                    String inputDate = sc.next();
                    LocalDate trueDate = LocalDate.parse(inputDate);
                    User newUser = new User(id, phone, username, password, trueDate);
                    user_service.addUser(newUser, myConn);
                    break;
                case 2:
                    System.out.println("removing a user");
                    System.out.println("enter id");
                    int idToRemove = sc.nextInt();
                    if (user_service.deleteUser(idToRemove, myConn) == false)
                        break;
                    System.out.println("invalid operation");
                    break;
                case 3:
                    System.out.println("enter id");
                    int idToFind = sc.nextInt();
                    user_service.getUser(idToFind, myConn);
                    break;
                case 4:
                    List<User> x = user_service.getAllUser(myConn);
                    break;
                case 5:
                    user_service.getAllUser(myConn);
                    System.out.println("enter id");
                    int idToUpdate = sc.nextInt();
                    System.out.println("enter id");
                    int phoneToUpdate = sc.nextInt();
                    user_service.updateUser(idToUpdate, phoneToUpdate, myConn);
                    break;
                default:
                    System.out.println("no operation had selected");

            }


        } catch (Exception e) {
            System.out.println(e);
        }
    }
}





