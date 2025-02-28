/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package edu.bdeb.controle;

import edu.bdeb.dal.IBanqueDAO;
import edu.bdeb.dal.InMemoryBanqueDAO;
import edu.bdeb.service.InsuranceRateService;
import edu.bdeb.service.InterestRateService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author benka
 */
public class InsuranceRateServlet extends HttpServlet {

    private IBanqueDAO dao;
    private InsuranceRateService service;

    @Override
    public void init() throws ServletException {
        super.init();
        dao = new InMemoryBanqueDAO();

        //dao = new InDBBanqueDAO();
        // dao = new InDBBanqueDAOJPA();
        service = new InsuranceRateService(dao);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

String montantPretStr = request.getParameter("montantPret");
    String nombrePaiementsStr = request.getParameter("nombrePaiements");
    String errorMessage = null;

    double montantPret = 0.0;
    int nombrePaiements = 0;
    List<String> resultats = new ArrayList<>();

    try {
        montantPret = Double.parseDouble(montantPretStr);
        nombrePaiements = Integer.parseInt(nombrePaiementsStr);

        if (montantPret <= 0 || nombrePaiements <= 0) {
            errorMessage = "Le montant du prêt et le nombre de paiements doivent être des valeurs positives.";
        } else {
            resultats = service.calculerTauxPourChaqueBanque(montantPret, nombrePaiements);
        }

    } catch (NumberFormatException e) {
        errorMessage = "Entrée invalide. Veuillez entrer des valeurs numériques.";
    }

    // Ajouter les résultats à l'attribut de requête
    request.setAttribute("resultats", resultats);
    request.setAttribute("errorMessage", errorMessage);

    // Rediriger vers la page JSP
    request.getRequestDispatcher("result4.jsp").forward(request, response);
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
