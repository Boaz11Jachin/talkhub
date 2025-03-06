package org.codenova.talkhub.model.dao;

import org.codenova.talkhub.model.vo.Post;
import org.codenova.talkhub.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostDAO {

    public boolean create(String writerId, String category, String title, String content) {
        boolean result = false;

        try {
            Connection conn = ConnectionFactory.open();
            PreparedStatement ps = conn.prepareStatement("insert into posts values(null, ?, ?, ?, ?, 0, 0, now(), now() )");
            ps.setString(1, writerId);
            ps.setString(2, category);
            ps.setString(3, title);
            ps.setString(4, content);

            int r = ps.executeUpdate();
            result = true;

            conn.close();

        } catch (Exception e) {
            System.out.println("PostDAO.create : " + e.toString());
        }

        return result;
    }

    public List<Post> selectAll(){
        List<Post> list = new ArrayList<>();

        try{
            Connection conn = ConnectionFactory.open();
            PreparedStatement ps = conn.prepareStatement("select * from posts order by id desc");

            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String writerId = rs.getString("writer_id");
                String category = rs.getString("category");
                String title = rs.getString("title");
                String content = rs.getString("content");
                int views = rs.getInt("views");
                int likes = rs.getInt("likes");
                Date writedAt = rs.getDate("writed_at");
                Date modifiedAt = rs.getDate("modified_at");

                Post p = new Post(id, writerId, category, title, content, views, likes, writedAt, modifiedAt);
                list.add(p);
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("error "+ e.toString());
        }
        return list;
    }



}
