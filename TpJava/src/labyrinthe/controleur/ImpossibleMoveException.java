/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labyrinthe.controleur;

/**
 *
 * @author jules
 */
public class ImpossibleMoveException extends Exception {
    public ImpossibleMoveException(){
        System.out.println("Mouvement impossible.");
    }
}
