/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labyrinthe.modele;

/**
 *
 * @author pierr
 */
public class CaseTrou extends CaseImplementee {

    public CaseTrou(int lig, int col) {
        super(lig, col);
        moved = true;
    }

}
