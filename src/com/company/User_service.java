package com.company;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class User_service implements UserService {

    @Override
    public User addUser(User user, Connection myConn) {
        Runnable runnable = () -> {
            PreparedStatement myStmt = null;
            try {
                myStmt = myConn.prepareStatement(" insert into `users`.`user`" +
                        " (`username`, `id`, `password`, `phone`, `birthDate`) " +
                        "VALUES " + "(?, ?, ?, ?, ?)");
                myStmt.setString(1, user.username);
                myStmt.setInt(2, user.id);
                myStmt.setString(3, user.password);
                myStmt.setInt(4, user.phone);
                myStmt.setString(5, String.valueOf(user.birthDate));
                myStmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        };
        return null;
    }

    @Override
    public User updateUser(int id, int phone, Connection myConn) throws SQLException {
        Runnable runnable = () -> {
            try {
                PreparedStatement myStmt = myConn.prepareStatement(" update `users`.`user`" + "set phone=?" + "where id=?");
                myStmt.setInt(1, phone);
                myStmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("update operation is done");

        };
        return null;
    }

    @Override
    public boolean deleteUser(int id, Connection myConn) throws SQLException {
        PreparedStatement myStmt = myConn.prepareStatement(" delete from `users`.`user`" + "where id=?");
        myStmt.setInt(1, id);
        myStmt.executeUpdate();
        System.out.println("delete operation is done");
        return false;
    }

    @Override
    public User getUser(int id, Connection myConn) throws SQLException {
        PreparedStatement myStmt = myConn.prepareStatement(" select * from `users`.`user`" + "where id=?");
        myStmt.setInt(1, id);
        ResultSet myRes = myStmt.executeQuery();
        System.out.println(myRes.getString("username") + " " + myRes.getInt(id) + " " + myRes.getString("password") + " " + myRes.getInt("phone") + "" + myRes.getString("birthDate"));
        System.out.println("delete operation is done");
        return null;
    }

    @Override
    public List<User> getAllUser(Connection myConn) throws SQLException {
        PreparedStatement myStmt = myConn.prepareStatement(" select * from `users`.`user`");
        ResultSet myRes = myStmt.executeQuery();
        while (myRes.next())
            System.out.println(myRes.getString("username") + " " + myRes.getInt("id") + " " + myRes.getString("password") + " " + myRes.getInt("phone") + "" + myRes.getString("birthDate"));
        System.out.println("delete operation is done");
        return null;
    }

    @Override
    public Optional<User> getUserByPhone(Connection myConn, int phone) throws SQLException {
        PreparedStatement myStmt = myConn.prepareStatement(" select * from `users`.`user`" + "where phone=?");
        myStmt.setInt(1, phone);
        ResultSet myRes = myStmt.executeQuery();
        System.out.println(myRes.getString("username") + " " + myRes.getInt("id") + " " + myRes.getString("password") + " " + myRes.getInt("phone") + "" + myRes.getString("birthDate"));
        System.out.println("delete operation is done");

        return Optional.empty();
    }
}
