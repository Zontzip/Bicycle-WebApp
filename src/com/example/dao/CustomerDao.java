package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.business.Customer;
import com.example.exceptions.DaoException;


public class CustomerDao extends Dao {

    public Customer findUserByUsernamePassword(String uname, String pword) throws DaoException {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Customer c = null;
        try {
            con = this.getConnection();
            
            String query = "SELECT * FROM CUSTOMERS WHERE USERNAME = ? AND PASSWORD = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, uname);
            ps.setString(2, pword);
            
            rs = ps.executeQuery();
            if (rs.next()) {
            	int userId = rs.getInt("Customer_ID");
                String username = rs.getString("USERNAME");
                String password = rs.getString("PASSWORD");
                String lastname = rs.getString("LAST_NAME");
                String firstname = rs.getString("FIRST_NAME");
                c = new Customer(userId, firstname, lastname, username, password);
            }
        } catch (SQLException e) {
            throw new DaoException("findUserByUsernamePassword " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                throw new DaoException("findUserByUsernamePassword" + e.getMessage());
            }
        }
        return c;     // u may be null 
    }
    
    public List<Customer> getAllUsers() throws DaoException {
    	Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Customer c = null;
        List<Customer> customers = new ArrayList<Customer>();
        try {
            con = this.getConnection();
            
            String query = "SELECT * FROM CUSTOMERS";
            ps = con.prepareStatement(query);
            
            rs = ps.executeQuery();
            while (rs.next()) {
            	int userId = rs.getInt("CUSTOMER_ID");
                String username = rs.getString("USERNAME");
                String password = rs.getString("PASSWORD");
                String lastname = rs.getString("LAST_NAME");
                String firstname = rs.getString("FIRST_NAME");
                c = new Customer(userId, firstname, lastname, username, password);
                customers.add(c);
            }
        } catch (SQLException e) {
            throw new DaoException("getAllUsers " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                throw new DaoException("getAllUsers" + e.getMessage());
            }
        }
        return customers;     // u may be null 
    }
   
}