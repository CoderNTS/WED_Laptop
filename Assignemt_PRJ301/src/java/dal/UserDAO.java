package dal;

import entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DBContext {

    public User checkAuth(String username, String password) throws SQLException {
        String sql = "SELECT [id]\n"
                + "      ,[username]\n"
                + "      ,[password]\n"
                + "      ,[nickname]\n"
                + "      ,[email]\n"
                + "      ,[phone_number]\n"
                + "      ,[address]\n"
                + "      ,[roleId]\n"
                + "  FROM [dbo].[Users] where [username] = '" + username + "' and [password] = '" + password + "'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(username);
                user.setAddress(rs.getString("address"));
                user.setPhone_number(rs.getString("phone_number"));
                user.setNickname(rs.getString("nickname"));
                user.setEmail(rs.getString("email"));
                user.setPassword(password);
                user.setRoleId(rs.getInt("roleId"));

                return user;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }

    public User getUser(String username) {
        String sql = "SELECT * FROM Users WHERE username = '" + username + "'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(username);
                user.setAddress(rs.getString("address"));
                user.setPhone_number(rs.getString("phone_number"));
                user.setNickname(rs.getString("nickname"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRoleId(rs.getInt("roleId"));
                return user;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }

    public List<User> getAll() {
        List<User> lu = new ArrayList<>();
        String sql = "SELECT * FROM Users";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setNickname(rs.getString(4));
                user.setEmail(rs.getString(5));
                user.setPhone_number(rs.getString(6));
                user.setAddress(rs.getString(7));
                user.setRoleId(rs.getInt(8));
                lu.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return lu;
    }
//    	id INT IDENTITY (1,1) PRIMARY KEY,
//	username VARCHAR(50),
//	password VARCHAR(30),
//	nickname VARCHAR(50),
//	email VARCHAR(40),
//	phone_number NUMERIC(10,0),
//	address VARCHAR(50),
//	roleId INT,

    public void insert(String username, String password, String nickname, String email, String phone, String address, int roleId) {
        String sql = "INSERT INTO Users VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            st.setString(3, nickname);
            st.setString(4, email);
            st.setString(5, phone);
            st.setString(6, address);
            st.setInt(7, roleId);
            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public int insert(User a) {
        String sql = "INSERT INTO Users VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, a.getUsername());
            st.setString(2, a.getPassword());
            st.setString(3, a.getNickname());
            st.setString(4, a.getEmail());
            st.setString(5, a.getPhone_number());
            st.setString(6, a.getAddress());
            st.setInt(7, 2);

            return st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

        return 0;
    }

    public User getUserById(int id) {
        String sql = "SELECT [id]\n"
                + "      ,[username]\n"
                + "      ,[password]\n"
                + "      ,[nickname]\n"
                + "      ,[email]\n"
                + "      ,[phone_number]\n"
                + "      ,[address]\n"
                + "      ,[roleId]\n"
                + "  FROM [dbo].[Users] where [id] = '" + id + "'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setAddress(rs.getString("address"));
                user.setPhone_number(rs.getString("phone_number"));
                user.setNickname(rs.getString("nickname"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRoleId(rs.getInt("roleId"));

                return user;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }

    public void updateUser(int id, String username, String password, String nickname, String email, String phone_number, String address, int roleId) {
        String sql = "UPDATE [dbo].[Users]\n"
                + "   SET [username] = ?\n"
                + "      ,[password] = ?\n"
                + "      ,[nickname] = ?\n"
                + "      ,[email] = ?\n"
                + "      ,[phone_number] = ?\n"
                + "      ,[address] = ?\n"
                + "      ,[roleId] = ?\n"
                + " WHERE id = " + id;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            st.setString(3, nickname);
            st.setString(4, email);
            st.setString(5, phone_number);
            st.setString(6, address);
            st.setInt(7, roleId);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM [dbo].[Users]\n"
                + "      WHERE id=" + id;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        User u = new User();
//        System.out.println(dao.getAll().size());
////        System.out.println(dao.getUserById(1).getUsername());
//         dao.insert(u);
//        dao.updateUser(2, "admin1", "123", "123", "ad", "123123", "ad", 1);
        System.out.println(dao.getAll().get(1).getPhone_number());

    }
}
