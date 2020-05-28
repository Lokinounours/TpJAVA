/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labyrinthe.vue;

import java.util.Scanner;
import labyrinthe.modele.*;
import labyrinthe.controleur.*;

/**
 *
 * @author paulc
 */
public class LabyConsole {
    /**
     * Affiche le menu composé de 3 choix : déplacement aléatoire, en profondeur DFS ou quitter le programme.
     * L’utilisateur doit saisir un choix de type int et recommencer tant qu’aucun des 3 choix proposés n’est valide,
     *  y compris si l’utilisateur saisit des caractères au lieu d’un nombre entier.
     * Il faut donc pouvoir convertir la saisie, y compris avec des caractères, en entier.
     * Dans le cas où l’utilisateur saisit des caractères autres que des chiffres, cette conversion génère
     * l’exception  NumberFormatException qu’il faut attraper pour afficher un message d’erreur,
     * tout en pouvant recommencer la saisie.
     *
     * Cette méthode retourne le choix saisi.
     *
     * @return choix
     */
    public int menu() {
        
        int choix = -1;
        
        Scanner keyboard = new Scanner(System.in);
        
        while(choix!=1 || choix!=2 || choix!=3){
            
            System.out.println("Veuillez entrer le nombre correspondant à votre choix.\n");

            System.out.println("1.Déplacement aléatoire.");
            System.out.println("2.Déplacement en profondeur DFS.");
            System.out.println("3.Quitter.");
            
            choix = keyboard.nextInt();
        }
        return choix;
    }

    /**
     * Affiche les coordonnées positionX et positionY protected de la Case c en paramètre
     *
     * @param c 
     */
    public void affiche(Case c) { 
        
        System.out.println("Position en X : "+c.getPositionX());
        
        System.out.println("Position en Y : "+c.getPositionY());
        
    }

    /**
     * Affiche un labyrinthe en mode console en se servant des méthodes du Labyrinthe laby en paramètre :
     * afficher toutes les cases soit de CaseMur avec le caractère ‘X’, soit de CaseTrou avec le caractère ’_’
     * en se servant de instanceof pour les distinguer, soit le caractère ‘V’ si la case est visitée (voir  la méthode
     *  getVisited définie dans l’interface Case et implémentée dans la classe CaseImplementee).
     *
     * @param laby
     */
    public void affiche(Labyrinthe laby) { 
        for(int i=0; i<laby.getTailleX; i++){
            for(int j=0; j<laby.getTailleY; j++){
                if(laby.getCase(i, j).canMoveToCase()){
                    System.out.print("_");
                }else{
                    System.out.print("X");
                }
                if(laby.getCase(i, j).getVisited()){
                    System.out.print("V");
                }
            }
            System.out.print("\n");
        } 
    }
}
