/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jawad;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Jawad Khan
 */
public class AAYCNGKotoNibenGambling {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        

        Scanner k = new Scanner(System.in);
        System.out.println("Please enter your bhaggo value from -5 to +5 ");
        int bhaggo = k.nextInt();
        
        Random rand = new Random();
        
        int ar[] = new int[]{150,150,200,200,200,200,200,200,250,250,250,250,300,300,350,350,400,400,450,500};
        for(int i=0;i<ar.length;i++)
        {
            System.out.println("cell " + i + " = "+ ar[i] + "TK");
        }
        int randNum = 0;
        
        if(bhaggo == 0)
        {
            randNum = rand.nextInt(ar.length-1) + 0;
            System.out.println("Your min range is : " + "0" + " and max range is " + (ar.length-1));
            System.out.println("Random number is = " + (randNum) + " Your fare is = " + ar[randNum]);
        }
        else if(bhaggo >=1)
        {
            randNum = rand.nextInt(((ar.length-1) - (bhaggo*2)) + 1) + (bhaggo*2);
            System.out.println("Your min range is : " + (bhaggo*2) + " and max range is " + (ar.length-1));
            System.out.println("Random number is = " + (randNum) + " Your fare is = "+ ar[randNum]); 
        }
        else
        {
            randNum = rand.nextInt(ar.length+bhaggo*2-1) + 0;
            System.out.println("Your min range is : " + "0" + " and max range is " + (ar.length+bhaggo*2-1));
            System.out.println("Random number is = " + (randNum) + " Your fare is = " + ar[randNum]); 
        }
        k.close();
    }
    
}
