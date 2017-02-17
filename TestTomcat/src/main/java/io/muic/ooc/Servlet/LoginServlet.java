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





@WebServlet("/login")
public class LoginServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getSession().getAttribute("currentUser") != null){
            System.out.println("enter in not null");
            System.out.println(req.getSession().getAttribute("currentUser"));
            resp.sendRedirect("/userslists");
        }else {
            req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, resp);
            System.out.println("Enter Get in Login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Enter Post in HomeServlet");
        String UserUsername = req.getParameter("username");
        String UserPassword = req.getParameter("password");


        MySQLJava database = new MySQLJava();
        Encode encode = new Encode();
        encode.hash(UserPassword);
        System.out.println("Enter in Login: ");


        try {
            database.connectDatabase();
            database.queryData("SELECT * FROM ooc_webapp.accessTable WHERE USERNAME='" + UserUsername+"'");

            User resultUser = database.isValidUser(UserUsername,encode.hash(UserPassword));
            if (resultUser != null){
                System.out.println("Valid username: "+resultUser.getUsername());
                req.getSession().setAttribute("currentUser", resultUser);
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
        }


    }
}
