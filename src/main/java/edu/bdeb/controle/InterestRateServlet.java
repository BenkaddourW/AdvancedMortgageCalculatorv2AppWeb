/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package edu.bdeb.controle;

import edu.bdeb.dal.IBanqueDAO;
import edu.bdeb.dal.InMemoryBanqueDAO;
import edu.bdeb.modele.Banque;
import edu.bdeb.service.InterestRateService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author benka
 */
public class InterestRateServlet extends HttpServlet {

 private IBanqueDAO dao;
    private InterestRateService service;

    @Override
    public void init() throws ServletException {
        super.init();
        dao = new InMemoryBanqueDAO();

        //dao = new InDBBanqueDAO();

        // dao = new InDBBanqueDAOJPA();
        service = new InterestRateService(dao);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
       String typeBanque = request.getParameter("typeBanque");

        List<Banque> banques = service.trouverToutBanqueParType(typeBanque);

        request.setAttribute("banques", banques);
        request.getRequestDispatcher("result3.jsp").forward(request, response);

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
