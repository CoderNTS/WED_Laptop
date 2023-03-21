/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import entity.Cart;
import entity.Item;
import entity.Order;
import entity.OrderDetail;
import entity.Purchase;
import entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Southern Alula
 */
public class OrderDAO extends DBContext {

    public void addOrder(User c, Cart cart) {
        LocalDate curDate = LocalDate.now();
        String date = curDate.toString();
        try {
            //add order
            String sql = "insert into Orders values(?,?,?,?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, c.getId());
            st.setString(2, date);
            st.setDouble(3, cart.getTotalMoney());
            st.setInt(4, 0);
            st.executeUpdate();
            //lay id cua order vua add
            String sql1 = "select top 1 id from Orders order by id desc";
            PreparedStatement st1 = connection.prepareStatement(sql1);
            ResultSet rs = st1.executeQuery();
            //add bang OrderDetail
            if (rs.next()) {
                int oid = rs.getInt("id");
                for (Item i : cart.getItems()) {
                    String sql2 = "insert into [OrderDetail] values(?,?,?,?,?)";
                    PreparedStatement st2 = connection.prepareStatement(sql2);
                    st2.setInt(1, oid);
                    st2.setInt(2, i.getProduct().getId());
                    st2.setDouble(3, i.getProduct().getPrice() - i.getProduct().getPrice() * i.getProduct().getDiscount() / 100);
                    st2.setInt(4, i.getQuantity());
                    st2.setDouble(5, (i.getProduct().getPrice() - i.getProduct().getPrice() * i.getProduct().getDiscount() / 100) * i.getQuantity());
                    st2.executeUpdate();
                }
            }
            //cap nhat lai so luong san pham
            String sql3 = "update Product set quantity=quantity-? where id=?";
            PreparedStatement st3 = connection.prepareStatement(sql3);
            for (Item i : cart.getItems()) {
                st3.setInt(1, i.getQuantity());
                st3.setInt(2, i.getProduct().getId());
                st3.executeUpdate();
            }
        } catch (SQLException e) {

        }
    }

    public List<Order> listOrder() {
        String sql = "SELECT * FROM [Orders]";
        List<Order> lod = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order od = new Order();
                od.setId(rs.getInt(1));
                od.setUser_id(rs.getInt(2));
                od.setOrder_date(rs.getString(3));
                od.setTotal_money(rs.getDouble(4));
                od.setStatus(rs.getInt(5));
                lod.add(od);
            }
        } catch (Exception e) {
        }
        return lod;
    }

    public void acceptOrderById(int id) {
        String sql = "UPDATE [Orders] "
                + "SET status = 1"
                + "WHERE id = " + id;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<OrderDetail> listOrderByID(int id) {
        String sql = "SELECT p.title, od.price, od.quantity, od.total_money FROM OrderDetail od\n"
                + "JOIN Product p \n"
                + "ON od.product_id = p.id\n"
                + "WHERE od.order_id = " + id;
        List<OrderDetail> lod = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OrderDetail od = new OrderDetail();
                od.setProduct_tite(rs.getString(1));
                od.setPrice(rs.getDouble(2));
                od.setQuantity(rs.getInt(3));
                od.setTotal_money(rs.getDouble(4));
                lod.add(od);
            }
        } catch (Exception e) {
        }
        return lod;
    }

    public List<Purchase> myPurchase(int id) {
        String sql = "SELECT o.order_date, p.title, od.price, od.quantity, od.total_money,o.status FROM OrderDetail od\n"
                + "JOIN Orders o ON o.id = od.order_id\n"
                + "JOIN Product p ON od.product_id = p.id\n"
                + "WHERE o.user_id =" + id;
        List<Purchase> lp = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Purchase p = new Purchase(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getDouble(5), rs.getInt(6));
                lp.add(p);
            }
        } catch (Exception e) {
        }
        return lp;
    }

    public static void main(String[] args) {
        OrderDAO dao = new OrderDAO();
        System.out.println(dao.myPurchase(2).size());
//        dao.acceptOrderById(4);

    }
}
