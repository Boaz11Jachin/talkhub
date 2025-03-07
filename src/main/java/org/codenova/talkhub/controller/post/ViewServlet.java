package org.codenova.talkhub.controller.post;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.codenova.talkhub.model.dao.PostDAO;
import org.codenova.talkhub.model.vo.Post;

import java.io.IOException;

@WebServlet("/post/view")
public class ViewServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        PostDAO postDAO = new PostDAO();
        boolean r = postDAO.increaseViewsById(id);

        Post post = postDAO.findById(id);


        // DB와의 통신이 끝났으면 응답관련 작업을 추가로 해보자.
//        if (post != null) {   // 데이터를 찾은상황
//            req.setAttribute("post", post);
//            req.getRequestDispatcher("/WEB-INF/views/post/view.jsp").forward(req, resp);
//        }

        if(req.getSession().getAttribute("user") == null) {
            req.getSession().setAttribute("callback", req.getContextPath()+"/post/view?id="+id);
            resp.sendRedirect(req.getContextPath()+"/user/login");
            return;
        }

        if(post == null) {
            resp.sendRedirect(req.getContextPath()+"/post/list");
        }else {
            req.setAttribute("post", post);
            req.getRequestDispatcher("/WEB-INF/views/post/view.jsp").forward(req, resp);
        }


    }
}
