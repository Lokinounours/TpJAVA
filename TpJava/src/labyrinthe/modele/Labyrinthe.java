/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labyrinthe.modele;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import labyrinthe.controleur.*;

/**
 *
 * @author pierr
 */
public class Labyrinthe {

    private int tailleX, tailleY; // largeur et hauteur
    private int departX, departY; // coordonnées de départ
    private int arriveeX, arriveeY; // coordonnées d'arrivée
    private int posX, posY; // coordonnées courantes
    private ArrayList<Case> grille; // liste des cases du labyrinthe

    /**
     * Constructeur qui initialise tous les attributs et crée tous les objets du
     * labyrinthe à partir du fichier lu fic en paramètre : instancier toutes
     * les cases soit de CaseMur, soit de CaseTrou en se servant de instanceof
     * pour les distinguer. Il génère et propage l’exception FileFormatException
     * en cas de problème de format du fichier : voir le format du fichier dans
     * Présentation du sujet Dans le cas où le fichier n’existe pas, cela génère
     * l’exception FileNotFoundException qu’il faut attraper pour générer
     * l’exception FileFormatException.
     *
     * @param fic
     * @throws java.io.FileNotFoundException
     */
    public Labyrinthe(File fic) throws FileNotFoundException {
        
        grille = new ArrayList<>();

        Scanner scanner = new Scanner(fic);

        int i = 0;

        while (scanner.hasNextLine()) {
            if (i == 0) {

                String line = scanner.nextLine();

                String[] result = line.split(" ");

                this.tailleX = Integer.parseInt(result[0]);
                this.tailleY = Integer.parseInt(result[1]);

                this.departX = Integer.parseInt(result[2]);
                this.departY = Integer.parseInt(result[3]);

                this.posX = this.departX;
                this.posY = this.departY;

                this.arriveeX = Integer.parseInt(result[4]);
                this.arriveeY = Integer.parseInt(result[5]);

            } else {

                String line = scanner.nextLine();

                for (int j = 0; j < this.tailleX; j++) {
                    if (line.charAt(j) == 'X') {
                        grille.add(new CaseMur(i - 1, j));
                    } else {
                        grille.add(new CaseTrou(i - 1, j));
                    }
                }
            }
            i++;
        }
        
        getCase(posX, posY).setVoisins();
    }

    public int getTailleX() {
        return this.tailleX;
    }

    public int getTailleY() {
        return this.tailleY;
    }
    
    public int getDepartX() {
        return this.departX;
    }

    public int getDepartY() {
        return this.departY;
    }

    public void setPosX(int x) {
        this.posX = x;
    }

    public void setPosY(int y) {
        this.posY = y;
    }

    public int getArriveeX() {
        return this.arriveeX;
    }

    public int getArriveeY() {
        return this.arriveeY;
    }

    public int getPosX() {
        return this.posX;
    }

    public int getPosY() {
        return this.posY;
    }

    /**
     * Tente de se déplacer dans la case ligne et colonne en paramètres du
     * labyrinthe et de la visiter. Il génère et propage l’exception
     * ImpossibleMoveException en cas d’impossibilité de déplacement : voir la
     * méthode canMoveToCase définie dans l’interface Case et implémentée dans
     * la classe CaseImplementee. S’il est possible de s’y déplacer, on la
     * visite grâce à la méthode setVisited de la classe CaseImplementee
     *
     * @param ligne
     * @param colonne
     * @throws labyrinthe.controleur.ImpossibleMoveException
     */
    public void move(int ligne, int colonne) throws ImpossibleMoveException {
        if (getCase(ligne, colonne).canMoveToCase() && ligne >= 0 && ligne < this.getTailleX() && colonne >= 0 && colonne < this.getTailleY() && !this.getCase(ligne, colonne).getVisited()) {
            getCase(ligne, colonne).setVisited();
            this.setPosX(ligne);
            this.setPosY(colonne);
        }
    }

    /**
     * Se déplace aléatoirement d’une case dans l’une des 4 directions possibles
     * (pas de diagonale) sans déborder du labyrinthe. Cette méthode appelle la
     * méthode move ci-dessus et propage l’exception ImpossibleMoveException en
     * cas d’impossibilité de déplacement.
     *
     * @throws ImpossibleMoveException : déplacement impossible
     */
    public void autoMove() throws ImpossibleMoveException {
        int nombreAleatoire = 1 + (int) (Math.random() * ((4 - 1) + 1));
        int newX = this.posX, newY = this.posY;
        switch (nombreAleatoire) {
            case 1:
                this.move(newX + 1, newY);
                break;
            case 2:
                this.move(newX - 1, newY);
                break;
            case 3:
                this.move(newX, newY + 1);
                break;
            default:
                this.move(newX, newY - 1);
                break;
        }
    }

    /**
     * Retourne l’objet de la Case de la grille (liste des cases) du labyrinthe
     * à partir de ses positions lig et col en paramètres
     *
     * @param lig
     * @param col
     * @return
     */
    public Case getCase(int lig, int col) {
        for (int i = 0; i < grille.size(); i++) {
            if (grille.get(i).getPositionX() == lig && grille.get(i).getPositionY() == col) {
                return grille.get(i);
            }
        }
        return null;
    }
}
