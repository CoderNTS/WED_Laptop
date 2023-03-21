/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import entity.Category;
import entity.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author black
 */
public class ProductDAO extends DBContext {

    public List<Product> getAll() {
        String sql = "SELECT * FROM Product";
        List<Product> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setId(rs.getInt("id"));
                pro.setCategory(rs.getInt("category_id"));
                pro.setTitle(rs.getString("title"));
                pro.setPrice(rs.getDouble("price"));
                pro.setQuantity(rs.getInt("quantity"));
                pro.setDiscount(rs.getInt("discount"));
                pro.setDescription(rs.getString("description"));
                pro.setStatus(rs.getInt("status"));
                pro.setBrand_id(rs.getInt("brand_id"));
                pro.setImage(rs.getString("image"));
                list.add(pro);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Product> getProductByDiscount() {
        String sql = "select top 5 * from Product order by discount";
        List<Product> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setId(rs.getInt("id"));
                pro.setCategory(rs.getInt("category_id"));
                pro.setTitle(rs.getString("title"));
                pro.setPrice(rs.getDouble("price"));
                pro.setQuantity(rs.getInt("quantity"));
                pro.setDiscount(rs.getInt("discount"));
                pro.setDescription(rs.getString("description"));
                pro.setStatus(rs.getInt("status"));
                pro.setBrand_id(rs.getInt("brand_id"));
                pro.setImage(rs.getString("image"));
                list.add(pro);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Product> getProductByCateId(int id) {
        String sql = "select * from Product where category_id = " + id;
        List<Product> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setId(rs.getInt("id"));
                pro.setCategory(rs.getInt("category_id"));
                pro.setTitle(rs.getString("title"));
                pro.setPrice(rs.getDouble("price"));
                pro.setQuantity(rs.getInt("quantity"));
                pro.setDiscount(rs.getInt("discount"));
                pro.setDescription(rs.getString("description"));
                pro.setStatus(rs.getInt("status"));
                pro.setBrand_id(rs.getInt("brand_id"));
                pro.setImage(rs.getString("image"));
                list.add(pro);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public Product getProductById(int id) {
        String sql = "select * from Product where id = " + id;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Product pro = new Product();
                pro.setId(rs.getInt("id"));
                pro.setCategory(rs.getInt("category_id"));
                pro.setTitle(rs.getString("title"));
                pro.setPrice(rs.getDouble("price"));
                pro.setQuantity(rs.getInt("quantity"));
                pro.setDiscount(rs.getInt("discount"));
                pro.setDescription(rs.getString("description"));
                pro.setStatus(rs.getInt("status"));
                pro.setBrand_id(rs.getInt("brand_id"));
                pro.setImage(rs.getString("image"));
                return pro;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Product> getProductByBrandId(int brandId) {
        String sql = "select * from Product where brand_id = " + brandId;
        List<Product> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setId(rs.getInt("id"));
                pro.setCategory(rs.getInt("category_id"));
                pro.setTitle(rs.getString("title"));
                pro.setPrice(rs.getDouble("price"));
                pro.setQuantity(rs.getInt("quantity"));
                pro.setDiscount(rs.getInt("discount"));
                pro.setDescription(rs.getString("description"));
                pro.setStatus(rs.getInt("status"));
                pro.setBrand_id(rs.getInt("brand_id"));
                pro.setImage(rs.getString("image"));
                list.add(pro);
            }
//            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public void updateProduct(int id, int cid, String title, double price, int quantity, int discount, String description, int status, int brand_id, String image) {
        String sql = "UPDATE [dbo].[Product]\n"
                + "   SET [category_id] = ?\n"
                + "      ,[title] = ?\n"
                + "      ,[price] = ?\n"
                + "      ,[quantity] = ?\n"
                + "      ,[discount] = ?\n"
                + "      ,[description] = ?\n"
                + "      ,[status] = ?\n"
                + "      ,[brand_id] = ?\n"
                + "      ,[image] = ?\n"
                + " WHERE id = " + id;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, cid);
            st.setString(2, title);
            st.setDouble(3, price);
            st.setInt(4, quantity);
            st.setInt(5, discount);
            st.setString(6, description);
            st.setInt(7, status);
            st.setInt(8, brand_id);
            st.setString(9, image);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void insert(int cid, String title, double price, int quantity, int discount, String description, int status, int brand_id, String image) {
        String sql = "insert into [dbo].[Product]\n"
                + "   values( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, cid);
            st.setString(2, title);
            st.setDouble(3, price);
            st.setInt(4, quantity);
            st.setInt(5, discount);
            st.setString(6, description);
            st.setInt(7, status);
            st.setInt(8, brand_id);
            st.setString(9, image);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM [dbo].[Product]\n"
                + "      WHERE id=" + id;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
    public List<Product> searchByKey(String key) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from Product\n"
                + " where title like '%" + key + "%' or description like '%" + key + "%'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                CategoryDAO cd = new CategoryDAO();
                Category c = cd.getCategoryById(rs.getInt("category_id"));
                p.setCategory(c.getId());
                p.setTitle(rs.getString("title"));
                p.setPrice(rs.getDouble("price"));
                p.setQuantity(rs.getInt("quantity"));
                p.setDiscount(rs.getInt("discount"));
                p.setDescription(rs.getString("description"));
                p.setStatus(rs.getInt("status"));
                p.setBrand_id(rs.getInt("brand_id"));
                p.setImage(rs.getString("image"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    
    public void deleteByCategoryId(int id) {
        String sql = "delete from Product where category_id = " + id;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public List<Product> getListByPage(List<Product> list, int start, int end) {
        List<Product> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(list.get(i));
        }
        return arr;
    }

    
    public List<Product> getTopSale3() {
        List<Product> list = new ArrayList<>();
        String sql = "select top 3 * from Product order by discount desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setCategory(rs.getInt("category_id"));
                p.setTitle(rs.getString("title"));
                p.setPrice(rs.getDouble("price"));
                p.setQuantity(rs.getInt("quantity"));
                p.setDiscount(rs.getInt("discount"));
                p.setDescription(rs.getString("description"));
                p.setStatus(rs.getInt("status"));
                p.setBrand_id(rs.getInt("brand_id"));
                p.setImage(rs.getString("image"));
                list.add(p);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public List<Product> searchProduct(int[] cid, double from, double to) {
        List<Product> list = new ArrayList<>();
        if (from == 0 && to == 0) {
            from = 0;
            to = 99999;
        }
        String sql = "select * from Product\n"
                + "where 1=1\n"
                + "and price between " + from + " and " + to;
        if (cid != null && cid[0] != 0) {
            sql += " and category_id in(";
            for (int i = 0; i < cid.length; i++) {
                sql += cid[i] + ",";
            }
            if (sql.endsWith(",")) {
                sql = sql.substring(0, sql.length() - 1);
            }
            sql += ")";
        }
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setCategory(rs.getInt("category_id"));
                p.setTitle(rs.getString("title"));
                p.setPrice(rs.getDouble("price"));
                p.setQuantity(rs.getInt("quantity"));
                p.setDiscount(rs.getInt("discount"));
                p.setDescription(rs.getString("description"));
                p.setStatus(rs.getInt("status"));
                p.setBrand_id(rs.getInt("brand_id"));
                p.setImage(rs.getString("image"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    
    
    public List<Product> searchProductBybrandID(int[] brand_id) {
        List<Product> list = new ArrayList<>();
        String sql = "select *  from Product\n"
                + "where 1=1 ";
        if (brand_id != null && brand_id[0] != 0) {
            sql += " and brand_id in(";
            for (int i = 0; i < brand_id.length; i++) {
                sql += brand_id[i] + ",";
            }
            if (sql.endsWith(",")) {
                sql = sql.substring(0, sql.length() - 1);
            }
            sql += ")";
        }
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                CategoryDAO cd = new CategoryDAO();
                p.setCategory(rs.getInt("category_id"));
                p.setTitle(rs.getString("title"));
                p.setPrice(rs.getDouble("price"));
                p.setQuantity(rs.getInt("quantity"));
                p.setDiscount(rs.getInt("discount"));
                p.setDescription(rs.getString("description"));
                p.setStatus(rs.getInt("status"));
                p.setBrand_id(rs.getInt("brand_id"));
                p.setImage(rs.getString("image"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
//    public static void main(String[] args) {
//        ProductDAO pro = new ProductDAO();
//        pro.insert(1, "Apple", 100, 0, 1, "description", 2, 1, "image");
//    }
}
