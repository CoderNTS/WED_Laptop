/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import entity.Category;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author black
 */
public class CategoryDAO extends DBContext {

    public List<Category> getAll() {
        String sql = "select * from Category";
        List<Category> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category cate = new Category();
                cate.setId(rs.getInt("id"));
                cate.setName(rs.getString("name"));
                cate.setImage(rs.getString("image"));
                list.add(cate);
            }
//            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public Category getCategoryById(int id) {
        String sql = "select * from Category where id=" + id;
        List<Category> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            Category cate = new Category();
            if (rs.next()) {
                cate.setId(rs.getInt("id"));
                cate.setName(rs.getString("name"));
                cate.setImage(rs.getString("image"));
            }
            return cate;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void delete(int id) {
        String sql = "delete from Category where id=" + id;
        ProductDAO pro = new ProductDAO();
        pro.deleteByCategoryId(id);
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void insert(String name, String image) {
        String sql = "INSERT INTO [Category] VALUES (?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, image);
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void update(String id, String name, String image) {
        String sql = "UPDATE [dbo].[Category]\n"
                + "   SET [name] = ?\n"
                + "      ,[image] = ?\n"
                + " WHERE id=" + id;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, image);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        CategoryDAO dao = new CategoryDAO();
        dao.insert("Watch", "nothing");
    }
}
