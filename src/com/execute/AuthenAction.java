package com.execute;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.beans.bien;
import com.beans.client;
import com.dao.bienDao;
import com.dao.clientDao;

public class AuthenAction extends Action {

    public static final String PAGE_ACCUEIL = "index.do";
    public static final String TABLE_BORD   = "table_bord.do";

    @Override
    public ActionForward execute( ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response ) throws Exception
    {
        // On rend le formulaire
        DynaActionForm formulaire = (DynaActionForm) form;

        String pseudo = (String) formulaire.get( "pseudo" );
        String pass = (String) formulaire.get( "pass" );

        clientDao dao = new clientDao();

        // On récupère id
        int id = dao.getIdClt( pseudo, pass );

        if ( id == 0 )
        {
            // On redigère vers la page d'accueil
            try
            {
                response.sendRedirect( PAGE_ACCUEIL );
            } catch ( IOException e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else
        {
            // On verifie l'existence du client
            client clt = new client();
            clt = dao.consulter( clt, id );

            // On récupère la sesssion en cours
            HttpSession session = request.getSession();
            bienDao biDao = new bienDao();
            List<bien> liste = biDao.get_liste_bien();

            session.setAttribute( "liste", liste );
            session.setAttribute( "obj_clt", clt );
            // On accède au tableau de bord
            try
            {
                response.sendRedirect( TABLE_BORD );
            } catch ( IOException e )
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return null;
    }
}
