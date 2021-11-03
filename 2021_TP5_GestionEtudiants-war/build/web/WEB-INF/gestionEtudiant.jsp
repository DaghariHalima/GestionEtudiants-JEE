<%-- 
    Document   : gestionEtudiant
    Created on : 07 May 2021, 1:03:33 AM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestion Etudiants</title>
    </head>
    <body>
        <div style="background-color: red;">
            <c:if test="${!empty formulaireAjoutEtudiant.erreurs}">
                <h2>Erreur d'ajout d'étudiant</h2>
            </c:if>
            <c:if test="${!empty formulaireAjoutEtudiant.erreurs['nom']}">
                Erreur Nom : ${formulaireAjoutEtudiant.erreurs['nom']}<br>
            </c:if>
            <c:if test="${!empty formulaireAjoutEtudiant.erreurs['dateNaissance']}">
                Erreur Date Naissance : ${formulaireAjoutEtudiant.erreurs['dateNaissance']}<br>
            </c:if>
            
        </div>
       
        <form action="GestionEtudiants" method="POST">
            <input type="text" name="nom" placeholder="Nom complet"/>
            <input type="date" name="datenaissance"/>
            <select name="niveauEtude">
                <c:forEach var="niveau" items="${niveauEtude}">
                    <option value="${niveau}">${niveau}</option>
                </c:forEach>
            </select>
            <input type="submit" value="Ajouter Etudiant"/>
        </form>
        <br>
        <table border="1">
            <tr>
                <th>Nom</th>
                <th>Date de naissance</th>
                <th>Niveau d'étude</th>
            </tr>
            <c:forEach var="etudiant" items="${listeEtudiants}">
                <tr>
                    <td>${etudiant.nom}</td>
                    <td>${etudiant.datenaissance}</td>
                    <td>${etudiant.niveau}</td>
                </tr>
            </c:forEach>
        </table>
        
    </body>
</html>