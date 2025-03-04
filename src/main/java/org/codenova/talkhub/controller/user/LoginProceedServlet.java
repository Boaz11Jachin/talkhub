package org.codenova.talkhub.controller.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.codenova.talkhub.model.dao.UserDAO;
import org.codenova.talkhub.model.vo.User;

import java.io.IOException;

@WebServlet("/user/login-proceed")
public class LoginProceedServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String password = req.getParameter("password");

        UserDAO userDAO = new UserDAO();
        User found = userDAO.findById(id);

        if (found == null){
            req.getRequestDispatcher("/WEB-INF/views/user/login-fail.jsp").forward(req, resp);
        }else {
            if(found.getPassword().equals(password)){
                resp.sendRedirect(req.getContextPath()+"/index");
            }else{
                req.getRequestDispatcher("/WEB-INF/views/user/login-fail.jsp").forward(req, resp);
            }
        }
    }
}
