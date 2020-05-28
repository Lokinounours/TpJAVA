/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labyrinthe.modele;

/**
 *
 * @author paulc
 */
public interface Case {

    public int getPositionX(); // retourne la position en X (colonne) de la case : voir attribut  positionX ci-dessous

    public int getPositionY(); // retourne la position en Y (ligne) de la case : voir attribut  positionY ci-dessous

    public boolean canMoveToCase(); // retourne un booléen indiquant si on peut se déplacer dans la case : voir moved ci-dessous

    public boolean getVisited(); // retourne un booléen indiquant si la case est visitée ou non : voir visited ci-dessous

    public void setVisited(); // modifie la case pour qu’elle soit visitée : voir visited ci-dessous

    public Case getVoisin(int i); // retourne le voisin numero i de la case : voir attribut voisins ci-dessous 

    public int getNbVoisins(); // retourne le nombre de voisins de la case : voir attribut nb_voisins ci-dessous
}
