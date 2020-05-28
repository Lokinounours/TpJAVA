/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpjava;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author pierr
 */
public class TpJava {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Bonjour à tous");
        
        Scanner scanner = new Scanner(new File("nbr"));
        
        while(scanner.hasNextLine()){
            int a = scanner.nextInt();
            System.out.println(a);
        }
    }
    
}
