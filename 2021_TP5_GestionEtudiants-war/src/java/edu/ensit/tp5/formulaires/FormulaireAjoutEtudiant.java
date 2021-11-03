package edu.ensit.tp5.formulaires;

import edu.ensit.tp5.modele.entities.NiveauEtude;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
public class FormulaireAjoutEtudiant {
   private String nom;
   private NiveauEtude niveauEtude;
   private Date dateNaissance ;
   private Map<String,String> erreurs=new HashMap<String,String>() ;

public FormulaireAjoutEtudiant(String nom, String dateNaissance, String niveauEtude){

  try{
    this.setNom(nom);
     } catch( EtudiantException e){
    erreurs.put("nom",e.getMessage());
     }
}

//Accesseur et mutateurs
public String getNom(){
return nom;
}
public void setNom(String nom) throws EtudiantException{
    if (nom==null || nom.trim().length()==0)
        throw new EtudiantException("Nom complet doit etre renseigné");
    this.nom=nom.trim();
}

  public Date getDateNaissance(){
      return dateNaissance;
  }  
  public void setDateNaissance(String dateNaissance) throws EtudiantException, ParseException {
        try {
        
        this.dateNaissance =new SimpleDateFormat("yyyy-MM-dd").parse(dateNaissance);  } 
        catch(ParseException ex){
        throw new EtudiantException("date de naissance doit etre renseigne sous forme yyyy-mm-dd");}
       
    }

  public NiveauEtude getNiveauEtude(){
      return niveauEtude;
  }  
  public void setNiveauEtude(NiveauEtude niveauEtude){
      this.niveauEtude=niveauEtude;
  }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public void setErreurs(Map<String, String> erreurs) {
        this.erreurs = erreurs;
    }
}
