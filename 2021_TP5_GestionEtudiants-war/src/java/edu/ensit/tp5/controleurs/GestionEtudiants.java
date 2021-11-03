
package edu.ensit.tp5.controleurs;

import edu.ensit.tp5.formulaires.FormulaireAjoutEtudiant;
import edu.ensit.tp5.modele.entities.Etudiant;

import edu.ensit.tp5.modele.entities.NiveauEtude;
import edu.ensit.tp5.modele.session.EtudiantFacade;
import java.io.IOException;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name = "GestionEtudiants", urlPatterns = {"/GestionEtudiants"})
public class GestionEtudiants extends HttpServlet {

   //Récupere l'EJB Session EtudiantFacade
    @EJB
    EtudiantFacade etudiantFacade;
    
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //envoyer la liste des etudiants
        request.setAttribute("listeEtudiants",etudiantFacade.findAll() );
        request.setAttribute("niveauEtude", NiveauEtude.getNiveauxEtude());
        //appeler la vue WEB-INF/gestionEtudiant.jsp
        request.getRequestDispatcher("WEB-INF/gestionEtudiant.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  //On va déléger la vérification des erreurs à un objet de type FormulaireAjoutEtudiant
  FormulaireAjoutEtudiant formulaireAjoutEtudiant=new FormulaireAjoutEtudiant(
          request.getParameter("nom"),
          request.getParameter("dateNaissance"),
          request.getParameter("niveauEtude"));
  if(formulaireAjoutEtudiant.getErreurs().isEmpty()){
      Etudiant etudiant=new Etudiant();
      etudiant.setNom(formulaireAjoutEtudiant.getNom());
      etudiant.setDatenaissance(new Date("01/01/2021"));
      etudiant.setNiveau(NiveauEtude.GInfo_3);
      etudiantFacade.create(etudiant);
  }
   
  request.setAttribute("formulaireAjoutEtudiant", formulaireAjoutEtudiant);
  //envoyer la liste des etudiants
  request.setAttribute("listeEtudiants", etudiantFacade.findAll());
  //envoyer la liste des niveaux d'étude
  request.setAttribute("niveauEtude", NiveauEtude.getNiveauxEtude());
  //appeler la vue
   request.getRequestDispatcher("WEB-INF/GestionEtudiants.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
  
    
