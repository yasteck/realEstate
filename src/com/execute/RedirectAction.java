package com.execute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.beans.client;
import com.dao.clientDao;

public class RedirectAction extends Action {

    public static final String PAGE_ACCUEIL = "index.do";

    @Override
    public ActionForward execute( ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response ) throws Exception
    {
        // On rend le formulaire
        DynaActionForm formulaire = (DynaActionForm) form;

        // On récupère les valeurs des champs
        String nom = (String) formulaire.get( "nom" );
        String prenom = (String) formulaire.get( "prenom" );
        String pseudo = (String) formulaire.get( "pseudo" );
        String password = (String) formulaire.get( "password" );

        // La persistence dans la BD
        client clt = new client();
        clt.setNom( nom );
        clt.setPrenom( prenom );
        clt.setPseudo( pseudo );
        clt.setPass( password );

        clientDao dao = new clientDao();
        dao.ajouter( clt );

        // On forward vers la page d'accueil
        // return mapping.findForward( "accueil" );
        response.sendRedirect( PAGE_ACCUEIL );
        return null;

    }

}
