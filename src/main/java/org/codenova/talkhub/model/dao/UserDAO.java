package org.codenova.talkhub.model.dao;

import org.codenova.talkhub.model.vo.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class UserDAO {

    public boolean create(String id, String password, String nickname, String gender, int birth) {
        boolean result = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://database.cf84ew84e9uc.ap-northeast-2.rds.amazonaws.com:3306/talkhub",
                    "admin", "1q2w3e4r");

            PreparedStatement ps = conn.prepareStatement("insert into users values (?, ?, ?, ?, ?, now())");
            ps.setString(1, id);
            ps.setString(2, password);
            ps.setString(3, nickname);
            ps.setString(4, gender);
            ps.setInt(5, birth);

            int r = ps.executeUpdate();
            result = true;

            conn.close();

        } catch (Exception e) {
            System.out.println("UserDAO.create : " + e.toString());
        }
        return result;
    }

    public User findById(String specificId) {
        User one = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://database.cf84ew84e9uc.ap-northeast-2.rds.amazonaws.com:3306/talkhub",
                    "admin", "1q2w3e4r");

            PreparedStatement ps = conn.prepareStatement("select * from users where id = ?");
            ps.setString(1, specificId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String id = rs.getString("id");
                String password = rs.getString("password");
                String nickname = rs.getString("nickname");
                String gender = rs.getString("gender");
                int birth = rs.getInt("birth");
                Date createdAt = rs.getDate("created_at");
                one = new User(id, password, nickname, gender, birth, createdAt);
            }

            conn.close();
        } catch (Exception e) {
            System.out.println("error : " + e.toString());
        }
        return one;
    }



}
