package org.codenova.talkhub.model.dao;

import org.codenova.talkhub.model.vo.PostLike;
import org.codenova.talkhub.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostLikeDAO {

    public boolean create(PostLike one) {
        boolean result = false;


        try (Connection conn = ConnectionFactory.open()) {
            PreparedStatement ps = conn.prepareStatement("insert into post_likes values(null, ?, ?, now())");

            ps.setString(1, one.getUserId());
            ps.setInt(2, one.getPostId());

            int r = ps.executeUpdate();
            result = true;


        } catch (Exception e) {
            System.out.println("error " + e.toString());
        }
        return result;

    }

    public List<PostLike> findByUserId(String userId) {
        List<PostLike> result = new ArrayList<>();
        try(Connection conn = ConnectionFactory.open()) {
            PreparedStatement ps = conn.prepareStatement("select * from post_likes where user_id = ? order by created_at desc");
            ps.setString(1, userId);

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                PostLike one = new PostLike();
                one.setPostId(rs.getInt("post_id"));
                one.setUserId(rs.getString("user_id"));
                one.setCreatedAt(rs.getDate("created_at"));
                one.setId(rs.getInt("id"));

                result.add(one);
            }
        }catch(Exception e) {
            System.out.println("PostLikeDao.findByUserId : "+ e.toString() );
        }
        return result;
    }


}