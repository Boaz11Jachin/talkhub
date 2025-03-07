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

    public Post findById(int postId) {
        Post one = null;
        try {
            Connection conn = ConnectionFactory.open();

            PreparedStatement ps = conn.prepareStatement("select * from posts where id = ?");
            ps.setInt(1, postId);


            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                one = new Post();

                one.setId(rs.getInt("id"));
                one.setWriterId(rs.getString("writer_id"));
                one.setCategory(rs.getString("category"));
                one.setTitle(rs.getString("title"));
                one.setContent(rs.getString("content"));
                one.setLikes(rs.getInt("likes"));
                one.setViews(rs.getInt("views"));
                one.setWritedAt(rs.getDate("writed_at"));
                one.setModifiedAt(rs.getDate("modified_at"));
            }

            conn.close();
        }catch(Exception e) {
            System.out.println("postDAO.findById : "+ e.toString() );
        }
        return one;
    }

    // 조회수 증가 (by Id)
    public boolean increaseViewsById(int postId) {
        boolean result = false;

        /* try with resources statement */
        try(Connection conn = ConnectionFactory.open()) {
            PreparedStatement ps = conn.prepareStatement("update posts set views = views + 1 where id = ?");
            ps.setInt(1, postId);

            int r = ps.executeUpdate();
            if(r > 0) {
                result = true;
            }
        }catch(Exception e) {
            System.out.println("PostDAO.create : "+ e.toString() );
        }
        return result;
    }

    public boolean increaseLikesById(int postId){
        boolean result = false;

        try(Connection conn = ConnectionFactory.open()){
            PreparedStatement ps = conn.prepareStatement("update posts set likes = likes + 1 where id = ?");
            ps.setInt(1, postId);

            int r = ps.executeUpdate();
            if(r > 0) {
                result = true;
            }
        }catch(Exception e) {
            System.out.println("PostDAO.create : "+ e.toString() );
        }
        return result;


    }



}
