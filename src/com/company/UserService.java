package com.company;
import java.sql.*;
import java.util.List;
import java.util.Optional;
public interface UserService {
    User addUser(User user, Connection myConn) throws SQLException;

    User updateUser(int id, int phone ,Connection myConn) throws SQLException;

    boolean deleteUser(int id,Connection myConn) throws SQLException;

    User getUser(int id,Connection myConn) throws SQLException;

    List<User>  getAllUser(Connection myConn) throws SQLException;

    Optional<User> getUserByPhone(Connection myConn, int phone) throws SQLException;
}
