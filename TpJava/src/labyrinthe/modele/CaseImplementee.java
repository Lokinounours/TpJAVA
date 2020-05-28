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
        this.positionX = lig;
        this.positionY = col;
    }

    @Override
    public int getPositionX() {
        return this.positionX;
    }

    @Override
    public int getPositionY() {
        return this.positionY;
    }

    @Override
    public boolean canMoveToCase() {
        return this.moved;
    }

    @Override
    public boolean getVisited() {
        return this.visited;
    }

    @Override
    // If true go to false, if false go to true
    public void setVisited() {
        this.visited = !this.visited;
    }

    @Override
    public Case getVoisin(int i) {
        return this.voisins.get(i);
    }

    @Override
    public int getNbVoisins() {
        return this.voisins.size();
    }

}
