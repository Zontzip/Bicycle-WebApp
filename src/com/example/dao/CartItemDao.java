package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.business.CartItem;
import com.example.exceptions.DaoException;

public class CartItemDao extends Dao {
	
	public List<CartItem> getAllCartItems() throws DaoException {
		
		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<CartItem> cartItems = new ArrayList<CartItem>();
        try {
        	con = this.getConnection();
        	
        	String query = "SELECT * FROM CartItems";
        	ps = con.prepareStatement(query);
        	
        	rs = ps.executeQuery();
        	while (rs.next()) {
        		int customerId = rs.getInt("CUSTOMER_ID");
        		int productCode = rs.getInt("PRODUCT_CODE");
        		int productQuantity = rs.getInt("PRODUCT_QUANTITY");
        		CartItem ci = new CartItem(customerId, productCode, productQuantity);
        		cartItems.add(ci);
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
                throw new DaoException("getAllCartItems" + e.getMessage());
            }
        }
        
		return cartItems;
	}
}
