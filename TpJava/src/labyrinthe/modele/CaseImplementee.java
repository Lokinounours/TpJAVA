/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labyrinthe.modele;

import java.util.ArrayList;

/**
 *
 * @author pierr
 */
public class CaseImplementee implements Case {

    protected int positionX, positionY; // position courante dans la case
    protected boolean visited, moved; // booléens de visite visited et d’accès moved à la case
    protected ArrayList<Case> voisins; // Liste des cases voisines
    protected int nb_voisins; // nombre de cases voisines

    /**
     * Constructeur qui initialise respectivement les attributs positionX et
     * positionY avec les paramètres lig et col. Par défaut, les booléens
     * visited et moved sont false, la liste des voisins est vide et nb_voisins
     * est nul.
     */
    public CaseImplementee(int lig, int col) {

    }

    @Override
    public int getPositionX() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getPositionY() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean canMoveToCase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean getVisited() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setVisited() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Case getVoisin(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNbVoisins() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
