/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tpqualimetrie;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
 

public class TpQualimetrie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
       int nb1= 0;
       int nb2= 0;
       int nb3= 0;
        
       String order ="";
       Scanner sc = new Scanner(System.in);
        
       // Traitement
       try {
            System.out.println("Veuillez saisir le 1er nombre :");
            nb1 = sc.nextInt();
             
            System.out.println("Veuillez saisir le 2eme nombre :");
            nb2 = sc.nextInt();
             
            System.out.println("Veuillez saisir le 3eme nombre :");
            nb3 = sc.nextInt();
             
            Scanner sc2 = new Scanner(System.in);
            System.out.println("Veuillez choisir l'ordre de l'affichage (D : Décroissant) / (C : Croissant)");
            order = sc2.nextLine();
            if(order.equals("D")) {
                System.out.println("Vous avez saisi : Décroissant");
            } else if(order.equals("C")) {
                System.out.println("Vous avez saisi : Croissant");
            }
       } catch(InputMismatchException ex) {
           System.out.println("Erreur lors de l'entree clavier");
        }
        // class ordre décroissant
       class ItemDesc implements Comparable<ItemDesc> {
 
        int value;
 
        ItemDesc(int value) {
            this.value = value;
        }
        public int getValue() {
        return value;
    }
        // ordre décroissant
        @Override
        public int compareTo(ItemDesc other) {
            return (this.value < other.value) ? 1 : ((this.value == other.value) ? 0 : -1); 
        }
}         
      
        List<ItemDesc> items = Arrays.asList(new ItemDesc(nb1), new ItemDesc(nb2), new ItemDesc(nb3));
        if(order.equals("D")) {
             // Décroissant
            Collections.sort(items);
        } else if (order.equals("C")) {
             // Croissant
            Collections.sort(items, new Comparator<ItemDesc>() {
             public int compare(ItemDesc item1, ItemDesc item2) {           
            return Integer.compare(item1.getValue(), item2.getValue());
        }
          });
             
        } else {
            System.out.println("-ERROR- :  L'ordre choisi doit être 'D' ou 'C'");
        }
 
        items.forEach(item -> System.out.println(item.value));
         
        sc.close();
    }
    }
    
    

