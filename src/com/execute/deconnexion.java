package com.execute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class deconnexion extends Action {

    public static final String PAGE_ACCUEIL = "index.do";

    @Override
    public ActionForward execute( ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response ) throws Exception
    {
        // On récupère la session en cours
        HttpSession session = request.getSession();

        // On la détruit
        session.invalidate();

        // On redirege vers la page d'accueil
        response.sendRedirect( PAGE_ACCUEIL );

        return null;

    }

}
