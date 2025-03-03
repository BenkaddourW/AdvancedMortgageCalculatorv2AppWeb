/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package edu.bdeb.controle;

import edu.bdeb.dal.IBanqueDAO;
import edu.bdeb.dal.InDBBanqueDAO;
import edu.bdeb.dal.InDBBanqueDAOJPA;
import edu.bdeb.dal.InMemoryBanqueDAO;
import edu.bdeb.modele.Banque;
import edu.bdeb.service.InterestRateService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author benka
 */
public class ChercherBanqueServlet extends HttpServlet {

    private IBanqueDAO dao;
    private InterestRateService service;

    @Override
    public void init() throws ServletException {
        super.init();
        //dao = new InMemoryBanqueDAO();

        dao = new InDBBanqueDAO();
        //dao = new InDBBanqueDAOJPA();
        service = new InterestRateService(dao);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        Banque banque = service.trouverTauxDInteretLePlusBas();

        // Vérifie si une banque a été trouvée
        if (banque != null) {
            req.setAttribute("nomBanque", banque.getNom());
            req.setAttribute("tauxInteretAnnuel", banque.getTauxInteretAnnuel());
            req.setAttribute("tauxAssuranceAnnuel", banque.getTauxAssuranceAnnuel());
        } else {
            req.setAttribute("nomBanque", "Aucune banque trouvée.");
            req.setAttribute("tauxInteretAnnuel", "N/A");
            req.setAttribute("tauxAssuranceAnnuel", "N/A");
        }

        req.getRequestDispatcher("/result2.jsp").forward(req, resp);
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
