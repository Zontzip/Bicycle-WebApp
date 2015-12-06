package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.business.Order;
import com.example.exceptions.DaoException;

public class OrderDao extends Dao {
	public List<Order> getAllOrders() throws DaoException {
		
		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Order> orders = new ArrayList<Order>();
        try {
        	con = this.getConnection();
        	
        	String query = "SELECT * FROM orders";
        	ps = con.prepareStatement(query);
        	
        	rs = ps.executeQuery();
        	while (rs.next()) {
        		int orderId = rs.getInt("ORDER_ID");
        		int customerId = rs.getInt("CUSTOMER_ID");
        		String orderDate = rs.getString("ORDER_DATE");
        		String orderStatus = rs.getString("ORDER_STATUS");
        		Order o = new Order(orderId, customerId, orderDate, orderStatus);
        		orders.add(o);
        	}
        } catch (SQLException e) {
        	throw new DaoException();
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
                throw new DaoException("getAllOrders" + e.getMessage());
            }
        }
        
		return orders;
	}
	
	public void insertOrder(Order order) throws DaoException {

		Connection con = null;
        PreparedStatement ps = null;
        
        int orderId = order.getOrderId();
        int customerId = order.getCustomerId();
        String orderDate = order.getOrderDate();
        String orderStatus = order.getOrderStatus();
       
        try {
        	con = this.getConnection();
        	
        	String query = "INSERT INTO ORDERS VALUES (?, ?, ?, ?)";
        	ps = con.prepareStatement(query);
        	ps.setInt(1, orderId);
            ps.setInt(2, customerId);
            ps.setString(3, orderDate);
            ps.setString(4, orderStatus);
        	
        	ps.executeUpdate();
        } catch (SQLException e) {
        	throw new DaoException();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                throw new DaoException("InsertOrder" + e.getMessage());
            }
        }
	}
}