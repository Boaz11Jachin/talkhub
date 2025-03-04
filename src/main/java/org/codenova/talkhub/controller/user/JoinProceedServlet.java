package org.codenova.talkhub.controller.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.codenova.talkhub.model.dao.UserDAO;
import org.codenova.talkhub.model.vo.User;

import java.io.IOException;
import java.util.Date;

@WebServlet("/user/join-proceed")
public class JoinProceedServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String password = req.getParameter("password");
        String nickname = req.getParameter("nickname");
        String gender = req.getParameter("gender");
        int birth = Integer.parseInt(req.getParameter("birth"));

        UserDAO userDAO = new UserDAO();
        boolean s = userDAO.create(id, password, nickname, gender, birth);

        if(s) {
            resp.sendRedirect(req.getContextPath() + "/index");

        } else {
            req.getRequestDispatcher("/WEB-INF/views/user/join-fail.jsp").forward(req, resp);
        }









    }
}
