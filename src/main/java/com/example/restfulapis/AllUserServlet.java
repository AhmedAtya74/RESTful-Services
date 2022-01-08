package com.example.restfulapis;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "AllUserServlet", value = "/AllUserServlet")
public class AllUserServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
       response.sendRedirect(request.getContextPath()+"api/users/getAllUsers");
    }
}