package org.codenova.talkhub.controller.post;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.codenova.talkhub.model.dao.PostDAO;
import org.codenova.talkhub.model.vo.User;

import java.io.IOException;

@WebServlet("/post/write-proceed")
public class WriteProceedServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String category = req.getParameter("category");
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        User user = (User) req.getSession().getAttribute("user");
        String writerId = user.getId();

        PostDAO postDAO = new PostDAO();
        boolean r = postDAO.create(writerId, category, title, content);

        if(r) {
            System.out.println("ok");
            resp.sendRedirect(req.getContextPath()+"/index");
        }else {
            System.out.println("fail");
        }


    }
}
