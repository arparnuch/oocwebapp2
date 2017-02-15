package io.muic.ooc.Servlet;

import io.muic.ooc.MySQLJava;
import io.muic.ooc.User;
import org.apache.commons.lang.StringUtils;
//import org.apache.tomcat.util.codec.binary.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by arparnuch on 2/13/2017 AD.
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("currentUser") == null){
            resp.sendRedirect("/login"); // login page
        }
        req.getRequestDispatcher("jsp/register.jsp").forward(req, resp);
        System.out.println("Enter Get in RegisterServlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String UserUsername = req.getParameter("username");
        String UserPassword = req.getParameter("password");
        String UserFirstname = req.getParameter("firstname");
        String UserLastname = req.getParameter("lastname");
        String UserEmail = req.getParameter("email");
        System.out.println("INFO SEND");
        MySQLJava mySQLJava = new MySQLJava();
        mySQLJava.connectDatabase();

        boolean flag = false;
        if (StringUtils.isBlank(UserUsername) && StringUtils.isBlank(UserPassword)) {
            resp.sendRedirect("/login");
        }
        try {
            flag = mySQLJava.readData("register",new User(UserUsername,UserPassword,null,UserFirstname, UserLastname,UserEmail));
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            mySQLJava.close();
        }




        if (flag){
            System.out.println("Update auto");
            resp.sendRedirect("/userslists");
        }
        else System.out.println("Fail");



    }
}
