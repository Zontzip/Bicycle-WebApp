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
}
