/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticalgorithms;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;

/**
 *
 * @author nicol
 */
public class GeneticAlgorithms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome! \n Please select the number of colors that you would like to see.");
        System.out.println("Would you like to see 4, 8, 12, 16, or 20 colors?");
        int numberOfChromosomes = in.nextInt();
        while(numberOfChromosomes%4 != 0 || numberOfChromosomes > 20 || numberOfChromosomes < 4)
        {
            if(numberOfChromosomes%2 != 0)
            {
                System.out.println("That is an odd number, you fool!");
            }
            System.out.println("Please enter a valid number.\nValid numbers are 4, 8, 12, 16, and 20.");
            numberOfChromosomes = in.nextInt();
        }
        InteractiveAlgorithm colorAlgorithm = new InteractiveAlgorithm();
        ArrayList<Chromosome> myColors = colorAlgorithm.createColorChromosomes(numberOfChromosomes);
        System.out.println("  \tRed \tGreen \tBlue");
        for(int i = 0; i < myColors.size(); i++)
        {
            System.out.print(i);
            for(int j = 0; j < myColors.get(i).N.length; j++)
            {
                System.out.print("\t" + myColors.get(i).N[j]);
            }
            System.out.println();
        }

        System.out.println("Would you like to select a winning color or see more colors?");
        System.out.println("To select a winning color, enter 'W'. To see more colors, enter 'M'.");
        String selection = in.next();
        while(!selection.equals("W") && !selection.equals("M"))
        {
            System.out.println("Please enter a valid selection. /n"
                    + "Select a winning color: W /nSee more colors: M");
            selection = in.next();
        }
        while(selection.equals("M"))
        {

            System.out.println("Please select " + myColors.size()/2 + " colors to remove. Indicate your choices by entering "
                    + "the numerical label for each color, followed by a space.");
            int count = 0;
            ArrayList colorsToRemove = new ArrayList();
            while(count < myColors.size()/2)
            {
                colorsToRemove.add(in.nextInt());
                count++;
            }
            myColors = colorAlgorithm.clearChromosomes(colorsToRemove, myColors);
            myColors = colorAlgorithm.pairChromosomes(myColors);
            myColors = colorAlgorithm.crossoverChromosomes(myColors);
            myColors = colorAlgorithm.mutateChromosomes(myColors);

            System.out.println("  \tRed \tGreen \tBlue");
            for(int i = 0; i < myColors.size(); i++)
            {
                System.out.print(i);
                for(int j = 0; j < myColors.get(i).N.length; j++)
                {
                    System.out.print("\t" + myColors.get(i).N[j]);
                }
                System.out.println();
            }

            System.out.println("Would you like to select a winning color or see more colors?");


            selection = in.nextLine();
            while(!selection.equals("W") && !selection.equals("M"))
            {
                System.out.println("Select a winning color: W \nSee more colors: M");
                selection = in.nextLine();
            }
        }
        System.out.println("Which color is the winner?");
        int winningColor = in.nextInt();
        System.out.println("WE HAVE A WINNER!!!!!");
        System.out.print("Winning color: ");
        for(int i = 0; i < myColors.get(i).N.length; i++)
        {
            System.out.print("\t" + myColors.get(winningColor).N[i]);
        }
    }
}
