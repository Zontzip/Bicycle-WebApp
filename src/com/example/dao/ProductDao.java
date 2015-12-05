package com.example.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.business.Product;
import com.example.exceptions.DaoException;

public class ProductDao extends Dao {
	
	public List<Product> getAllProducts() throws DaoException {
		
		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Product> products = new ArrayList<Product>();
        try {
        	con = this.getConnection();
        	
        	String query = "SELECT * FROM products";
        	ps = con.prepareStatement(query);
        	
        	rs = ps.executeQuery();
        	while (rs.next()) {
        		int productId = rs.getInt("PRODUCT_CODE");
        		String productName = rs.getString("PRODUCT_NAME");
        		String productDescription = rs.getString("PRODUCT_DESCRIPTION");
        		int productPrice = rs.getInt("PRODUCT_PRICE");
        		Product p = new Product(productId, productName, productDescription, productPrice);
        		products.add(p);
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
                throw new DaoException("getAllProducts" + e.getMessage());
            }
        }
        
		return products;
	}
}
