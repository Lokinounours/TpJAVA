/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labyrinthe.controleur;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import labyrinthe.modele.*;
import labyrinthe.vue.*;

/**
 *
 * @author jules
 */
public class TestLaby {

    private static Labyrinthe laby;
    private static LabyConsole labyConsole;

    /**
     * Constructeur qui instancie l’objet en attribut de la classe Labyrinthe
     * avec le fichier fic de type File en paramètre. Cette méthode propage
     * l’exception FileFormatException en cas de problème de format du fichier.
     *
     * @param fic : fichier du labyrinthe
     * @throws labyrinthe.controleur.FileFormatException
     * @throws java.io.FileNotFoundException
     * @throws labyrinthe.controleur.FileFormatException
     * @throws labyrinthe.controleur.FileFormatException
     */
    public TestLaby(File fic) throws FileFormatException, FileNotFoundException {

        laby = new Labyrinthe(fic);

    }

    /**
     * Déplacement récursif en profondeur dans le labyrinthe à partir des
     * positions ligne et colonne en paramètres. A chaque case visitée (voir la
     * méthode getCase de la classe Labyrinthe) dans cette ligne et colonne, pas
     * encore visitée (voir la méthode getVisited implémentée dans la classe
     * CaseImplementee), on indique qu’on la visite (voir la méthode setVisited
     * implémentée dans la classe CaseImplementee) et on affiche les coordonnées
     * de la case visitée et le labyrinthe (voir les 2 méthodes surchargées
     * affiche et affiche de LabyConsole). Cette méthode retourne un booléen
     * indiquant l’arrêt de déplacement : true si la sortie est atteinte (voir
     * les positions private dans la classe Labyrinthe), false sinon.
     *
     * @param ligne de la case
     * @param colonne de la case
     * @return d'un booléen d'arrêt du déplacement
     */
    public static boolean deplacerDFS(int ligne, int colonne) {
        //BUG Potentiel
        if (ligne == laby.getArriveeX() && colonne == laby.getArriveeY()) {
            return true;
        }
        else if (ligne >= 0 && ligne < laby.getTailleX() && colonne >= 0 && colonne < laby.getTailleY() && !laby.getCase(ligne, colonne).getVisited()) {
            laby.getCase(ligne, colonne).setVisited();
            
            System.out.println("Debug");
            System.out.println(ligne);
            System.out.println(colonne);
            System.out.println(laby.getCase(ligne, colonne).getNbVoisins());
            
            labyConsole.affiche(laby.getCase(ligne, colonne));
            labyConsole.affiche(laby);
            for (int i = 0; i < laby.getCase(ligne, colonne).getNbVoisins(); i++) {
                int x = laby.getCase(ligne, colonne).getVoisin(i).getPositionX();
                int y = laby.getCase(ligne, colonne).getVoisin(i).getPositionY();
                deplacerDFS(x, y);
            }
        }
        return false;
    }

    /**
     * Déplacement aléatoire dans le labyrinthe : cette méthode utilise la
     * méthodes autoMove de Labyrinthe qui peut déclencher l’exception
     * ImpossibleMoveException à attraper. A chaque case visitée, on applique
     * les mêmes instructions que celles commentées dans la méthode deplacerDFS.
     * Cette méthode retourne un booléen indiquant l’arrêt de déplacement : true
     * si la sortie est atteinte (voir les positions private dans la classe
     * Labyrinthe), false sinon.
     *
     * @return d'un booléen d'arrêt du déplacement
     */
    public static boolean deplacerAuto() {
        try {
            while (laby.getArriveeX() != laby.getPosX() && laby.getArriveeY() != laby.getPosY()) {
                laby.autoMove();
                labyConsole.affiche(laby.getCase(laby.getPosX(), laby.getPosY()));
                labyConsole.affiche(laby);
            }
            return true;
        } catch (ImpossibleMoveException e) {
            System.out.println(e);
            return false;
        }
    }

    /**
     * Le main instancie l’objet du LabyConsole en attribut. Il saisit le nom du
     * fichier du labyrinthe. Puis il instancie un objet de la classe TestLaby
     * avec en paramètre le fichier, ce qui peut déclencher l’exception
     * FileFormatException à attraper en affichant un message d’erreur sur un
     * problème de format du fichier. Il affiche ensuite le labyrinthe avec la
     * bonne méthode affiche de LabyConsole. Il affiche le menu avec la méthode
     * menu de LabyConsole. Selon le choix retourné par le menu, soit il se
     * déplace en profondeur avec deplacerDFS (à partir de la position de départ
     * définie dans la classe Labyrinthe), soit aléatoirement avec deplacerAuto,
     * soit il quitte le programme.
     * @param args
     * @throws labyrinthe.controleur.FileFormatException
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileFormatException, FileNotFoundException{
        
        LabyConsole LC = new LabyConsole();
        
        File f = new File("labyrinthe.txt");
        
        TestLaby TL = new TestLaby(f);
        
        LC.affiche(laby);
        
        switch(LC.menu()){
            case 1:
                //Alea
                if(deplacerAuto()){
                    System.out.println("Réussi");
                }else{
                    System.out.println("Pas Réussi");
                }
                break;
            case 2:
                //DFS
                if(deplacerDFS(laby.getDepartX(), laby.getDepartY())){
                    System.out.println("Réussi");
                }else{
                    System.out.println("Pas Réussi");
                }
                break;
            case 3:
                System.exit(0);
                break;
        }  
    }

}
