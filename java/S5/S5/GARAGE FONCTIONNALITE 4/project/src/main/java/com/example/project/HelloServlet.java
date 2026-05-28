package com.example.project;

import java.io.*;
import java.util.ArrayList;

import entity.Service;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    Fonction f = new Fonction();
    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        try{
            ArrayList<Service> services = f.getAllService();
            for(int i=0; i<services.size(); i++){
                out.println(services.get(i).getId());
                out.println(services.get(i).getNom());
                out.println(services.get(i).getMontant());
            }
            request.setAttribute("listeservice",services);
            RequestDispatcher rd = request.getRequestDispatcher("liste.jsp");
            rd.forward(request,response);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void destroy() {
    }
}