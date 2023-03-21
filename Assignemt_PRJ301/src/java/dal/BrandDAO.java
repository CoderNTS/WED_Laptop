/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import entity.Brand;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Southern Alula
 */
public class BrandDAO extends DBContext {

    public List<Brand> getAll() {
        String sql = "select * from Brands";
        List<Brand> list = new ArrayList<>();
        
        try {   
            PreparedStatement st = connection.prepareStatement(sql);           
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                Brand a = new Brand();
                a.setId(rs.getInt(1));
                a.setName(rs.getString(2));
                a.setImage(rs.getString(3));
                list.add(a);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
}
