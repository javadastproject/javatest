/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webproject.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.persistence.*;

/**
 *
 * @author glajaja
 */
public class AddCategoryServlet9 extends HttpServlet {

    private boolean condition = true;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            EntityManagerFactory emf
                    = Persistence.createEntityManagerFactory("com.mycompany_WebProject_war_1.0-SNAPSHOTPU");
            EntityManager em = emf.createEntityManager(); 
            String category = request.getParameter("category");

            String encodedCategory = URLEncoder.encode(category, "UTF-8");
            String decodedCategory = URLDecoder.decode(encodedCategory, "UTF-8");

            byte[] byteArray = decodedCategory.getBytes();
            char[] charArray = new char[byteArray.length];
            for (int i = 0; i < byteArray.length; i++){
                charArray[i] = (char) byteArray[i];
            }
            String newCategory = new String(charArray);

            em.getTransaction().begin();
            em.createNativeQuery("insert into category (category) values ('"+newCategory+"')").executeUpdate();
            em.getTransaction().commit();
            em.close();
            request.setAttribute("message", "Add Category successfully");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("message", "Category Duplicate");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
        }
    }

    
	
	

    protected void processRequest_fix(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_WebProject_war_1.0-SNAPSHOTPU");
            EntityManager em = emf.createEntityManager();
            String category = request.getParameter("category");
    
            String encodedCategory = URLEncoder.encode(category, "UTF-8");
            String decodedCategory = URLDecoder.decode(encodedCategory, "UTF-8");
    
            byte[] byteArray = decodedCategory.getBytes();
            char[] charArray = new char[byteArray.length];
            for (int i = 0; i < byteArray.length; i++) {
                charArray[i] = (char) byteArray[i];
            }
            String newCategory = new String(charArray);
    
            em.getTransaction().begin();
    
            Query query = em.createNativeQuery("INSERT INTO category (category) VALUES (:category)");
            query.setParameter("category", newCategory);
            query.executeUpdate();
    
            em.getTransaction().commit();
            em.close();
            request.setAttribute("message", "Add Category successfully");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("message", "Category Duplicate");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
        }
    }
    

    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
