package io.muic.ooc.Servlet;

import io.muic.ooc.MySQLJava;
import io.muic.ooc.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;



/**
 * Created by arparnuch on 2/13/2017 AD.
 */



@WebServlet("/login")
public class LoginServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("jsp/index.jsp").forward(req, resp);
        System.out.println("Enter Get in Login");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Enter Post in HomeServlet");
        String UserUsername = req.getParameter("username");
        String UserPassword = req.getParameter("password");


        MySQLJava database = new MySQLJava();
        User user = new User(UserUsername,UserPassword,null);
        try {
            database.connectDatabase();
            database.queryData("SELECT * FROM ooc_webapp.accessTable");

            boolean isIn = database.readData("login", user);
            if (isIn){
                user.setAuthen(true);
                req.getSession().setAttribute("currentUser", user);
                resp.sendRedirect("/userslists");//
            }
            else{
                JOptionPane.showMessageDialog(null, "Fail to Login!");
                resp.sendRedirect("/login"); // login page
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println("After Login");
//            database.close();
        }


    }
}
