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
import edu.bdeb.service.InsuranceRateService;
import edu.bdeb.service.InterestRateService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author benka
 */
@WebServlet("/BanqueServlet")
public class BanqueServlet extends HttpServlet {
//    private InterestRateService service;
//
//    @Override
//    public void init() throws ServletException {
//        super.init();
//        this.service = new InterestRateService(new InMemoryBanqueDAO());
//    }

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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String nomBanque = req.getParameter("nomBanque");

        if (nomBanque != null && !nomBanque.isEmpty()) {
            System.out.println("Nom de la banque reçu : " + nomBanque);
            double taux = service.trouverTauxParBanque(nomBanque); // Utilisation de la variable nomBanque
            session.setAttribute("taux", taux);
            session.setAttribute("nomBanque", nomBanque);
        } else {
            session.setAttribute("taux", 0.0);
            session.setAttribute("nomBanque", "Inconnue");
        }

        req.getRequestDispatcher("/result.jsp").forward(req, resp);
    }
}
