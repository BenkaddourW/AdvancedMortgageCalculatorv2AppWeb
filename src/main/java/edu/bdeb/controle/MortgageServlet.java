/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package edu.bdeb.controle;

import edu.bdeb.dal.IBanqueDAO;
import edu.bdeb.dal.InDBBanqueDAO;
import edu.bdeb.dal.InDBBanqueDAOJPA;
import edu.bdeb.dal.InMemoryBanqueDAO;
import edu.bdeb.service.InterestRateService;
import edu.bdeb.service.MortageAmortizationService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author benka
 */
public class MortgageServlet extends HttpServlet {

    private IBanqueDAO dao;
    private MortageAmortizationService service;

    @Override
    public void init() throws ServletException {
        super.init();
        //dao = new InMemoryBanqueDAO();

        dao = new InDBBanqueDAO();

        // dao = new InDBBanqueDAOJPA();
        service = new MortageAmortizationService(dao);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

 double prixMaison = Double.parseDouble(request.getParameter("prixMaison"));
        double apportInitial = Double.parseDouble(request.getParameter("apportInitial"));
        int nombrePaiements = Integer.parseInt(request.getParameter("nombrePaiements"));

        // Call the service to get results
        List<String> resultats = service.MeilleurOffre(prixMaison, apportInitial, nombrePaiements);

        // Set results as request attributes
        request.setAttribute("resultats", resultats);

        // Forward to JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("result5.jsp");
        dispatcher.forward(request, response);
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
