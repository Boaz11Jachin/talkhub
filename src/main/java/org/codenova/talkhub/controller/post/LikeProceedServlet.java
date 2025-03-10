package org.codenova.talkhub.controller.post;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.codenova.talkhub.model.dao.PostDAO;
import org.codenova.talkhub.model.dao.PostLikeDAO;
import org.codenova.talkhub.model.vo.PostLike;
import org.codenova.talkhub.model.vo.User;

import java.io.IOException;
import java.util.List;

@WebServlet("/post/like-proceed")
public class LikeProceedServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        PostLikeDAO postLikeDAO = new PostLikeDAO();

        User requester = (User)req.getSession().getAttribute("user");
        List<PostLike> likes = postLikeDAO.findByUserId(requester.getId());



        boolean alreadyLiked =false;

        for(PostLike like : likes){
            if(like.getPostId() == id){
                alreadyLiked = true;
            }
        }

        if(!alreadyLiked){
            PostDAO postDAO = new PostDAO();
            postDAO.increaseLikesById(id);

            PostLike log = PostLike.builder().userId(requester.getId()).postId(id).build();
            postLikeDAO.create(log);
        }


        // 내가만들어서필요없는? req.getSession().setAttribute("alreadyLiked", alreadyLiked);

        resp.sendRedirect(req.getContextPath()+"/post/view?id="+id);
        //req.getRequestDispatcher("/post/view?id=" + id).forward(req, resp);
    }
}
