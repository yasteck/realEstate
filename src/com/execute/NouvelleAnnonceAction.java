package com.execute;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.beans.Logement;
import com.beans.Ville;
import com.beans.bien;
import com.beans.client;
import com.dao.bienDao;

public class NouvelleAnnonceAction extends Action {

    public static final String TABLE_DE_BORD = "table_bord.do";
    public static final String LISTE_ANNONCE = "liste_annonce";
    public bienDao             dao           = new bienDao();
    // Emplacement des images
    public static final String emplacement   = "E:/JEE_Work_Place/realestate1/WebContent/upload_images/";

    @Override
    public ActionForward execute( ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response ) throws Exception
    {
        // On rend le formulaire
        envoieImage formulaire = (envoieImage) form;

        // On récupère les champs
        String titre = formulaire.getTitre();
        String nature = formulaire.getNature();
        String etat = formulaire.getEtat();
        double prix = formulaire.getPrix();
        String date_creation = formulaire.getDate_creation();
        String description = formulaire.getDescription();
        double surface = formulaire.getSurface();
        String adersse = formulaire.getAdresse();
        String ville = formulaire.getVille();
        int nbr_piece = formulaire.getNbr_piece();
        String etat_logement = formulaire.getEtat_logement();
        String type_logement = formulaire.getType_logement();

        // On encapluse dans le bean dédié
        Logement bi = new Logement();
        bi.setTitre( titre );
        bi.setNature( nature );
        bi.setEtat( etat );
        bi.setPrix( prix );
        bi.setDate_creation( date_creation );
        bi.setDescription( description );
        bi.setSurface( surface );
        bi.setAdresse( adersse );
        bi.setNbr_pieces( nbr_piece );
        bi.setEtat_appart( etat_logement );
        bi.setType( type_logement );

        // On encapsule la ville
        Ville v = new Ville();
        int indice_ville = dao.get_exist_ville( ville );
        if ( indice_ville == 0 )
        {
            v.setNom( ville );
            bi.setVille( v );
        }
        else
        {
            v.setId( indice_ville );
            v.setNom( ville );
            bi.setVille( v );
        }
        // --------------------
        // On encapsule le client-------------------------------
        HttpSession session = request.getSession();
        client session_clt = (client) session.getAttribute( "obj_clt" );

        client ct = new client();
        ct.setId( session_clt.getId() );
        ct.setNom( session_clt.getNom() );
        ct.setPrenom( session_clt.getPrenom() );
        ct.setPseudo( session_clt.getPseudo() );
        ct.setPass( session_clt.getPass() );

        bi.setClt( ct );

        // ------------------------------------------------------

        // --------------------------Envoie des images
        // ----------------------------------------
        FormFile yassine = formulaire.getYassine_file();
        FormFile img1 = formulaire.getImg1();
        FormFile img2 = formulaire.getImg2();
        FormFile img3 = formulaire.getImg3();
        // formulaire.setSrc( yassine.getFileName() );
        // String filePath = request.getRealPath( "/" ).toString();

        File newUploadFile = new File( emplacement, yassine.getFileName() );
        File uploadFile1 = new File( emplacement, img1.getFileName() );
        File uploadFile2 = new File( emplacement, img2.getFileName() );
        File uploadFile3 = new File( emplacement, img3.getFileName() );

        if ( !newUploadFile.exists() || !uploadFile1.exists() || !uploadFile2.exists() || !uploadFile3.exists() )
        {
            newUploadFile.createNewFile();
            uploadFile1.createNewFile();
            uploadFile2.createNewFile();
            uploadFile3.createNewFile();

            FileOutputStream fos = new FileOutputStream( newUploadFile );
            FileOutputStream fos1 = new FileOutputStream( uploadFile1 );
            FileOutputStream fos2 = new FileOutputStream( uploadFile2 );
            FileOutputStream fos3 = new FileOutputStream( uploadFile3 );

            fos.write( yassine.getFileData() );
            fos1.write( img1.getFileData() );
            fos2.write( img2.getFileData() );
            fos3.write( img3.getFileData() );

            fos.flush();
            fos1.flush();
            fos2.flush();
            fos3.flush();

            fos.close();
            fos1.close();
            fos2.close();
            fos3.close();
        }
        yassine.destroy();
        img1.destroy();
        img2.destroy();
        img3.destroy();

        bi.setImg_principal( yassine.getFileName() );
        bi.setImg1( img1.getFileName() );
        bi.setImg2( img2.getFileName() );
        bi.setImg3( img3.getFileName() );
        // --------------------------------

        // ------------------------------------------------------------------------------------

        // On persiste dans la BD

        dao.ajouter( bi );

        // On récupère la session en cours
        // HttpSession session = request.getSession();

        List<bien> liste = dao.get_liste_bien();

        session.setAttribute( "liste", liste );

        // request.setAttribute( LISTE_ANNONCE, liste_bien );

        response.sendRedirect( TABLE_DE_BORD );

        return null;

    }

}
