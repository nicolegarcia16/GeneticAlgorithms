/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticalgorithms;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author nicol
 */
public class InteractiveAlgorithm {
    
    public ArrayList<Chromosome> createColorChromosomes(int numChromosomes)
    {
        ArrayList<Chromosome> chromosomes = new ArrayList();
        for(int i = 0; i < numChromosomes; i++)
        {
            Chromosome newChromosome = new Chromosome(3);
            for(int j = 0; j < 3; j++)
            {
                newChromosome.N[j] = (int)((Math.random()*1000%254) + 1);
            }
            chromosomes.add(newChromosome);
        }
        return chromosomes;
    }
    
    public ArrayList<Chromosome> clearChromosomes(ArrayList colorsToRemove, ArrayList<Chromosome> chromosomes)
    {
        colorsToRemove.sort(Comparator.reverseOrder());
            for(int i = 0; i < colorsToRemove.size(); i++)
            {
                Chromosome chromosomeToRemove = chromosomes.get((int)(colorsToRemove.get(i)));
                chromosomes.remove(chromosomeToRemove);
            }
        return chromosomes;
    }
    
    public int search(int[] genes, int geneToFind)
    {
        int location = -1;
        for(int i  = 0; i < genes.length; i++)
        {
            if(genes[i] == geneToFind)
            {
                location = i;
            }
        }
        return location;
    }
    
    public ArrayList<Chromosome> pairChromosomes(ArrayList<Chromosome> chromosomes)
    {
        for(int i = 0; i < (chromosomes.size()/2); i++)
        {
            int mateChromosomeIndex = chromosomes.size() - (i + 1);
            Chromosome thisChromosome = chromosomes.get(i);
            Chromosome mateChromosome = chromosomes.get(mateChromosomeIndex);
            thisChromosome.mate = mateChromosome;
            mateChromosome.mate = thisChromosome;
            chromosomes.set(i, thisChromosome);
            chromosomes.set(mateChromosomeIndex, mateChromosome); 
        }
        
        return chromosomes;
    }
    
    public ArrayList<Chromosome> crossoverChromosomes(ArrayList<Chromosome> chromosomes)
    {
        int maxToCrossover = chromosomes.size();
        for(int i = 0; i < maxToCrossover; i++)
        {
            Chromosome thisChromosome = chromosomes.get(i);
            
            //Figure out why this is spazzing
            Chromosome mateChromosome = 
                    chromosomes.get(chromosomes.indexOf(thisChromosome.mate));
            Chromosome newChromosome = new Chromosome(thisChromosome.N.length);
            
            for(int j = 0; j < thisChromosome.N.length; j++)
            {
                int doCrossover = (int)((Math.random()*10)%2);
                if(doCrossover == 0)
                    newChromosome.N[j] = thisChromosome.N[j];
                else
                    newChromosome.N[j] = mateChromosome.N[j];
            }
            chromosomes.add(newChromosome);
        }
        return chromosomes;
    }
    
    public ArrayList<Chromosome> mutateChromosomes(ArrayList<Chromosome> chromosomes)
    {
        int totalNumberOfGenes = chromosomes.size()*3;
        int numberToMutate = (int)(totalNumberOfGenes * .1);
        if(numberToMutate < 1)
            numberToMutate = 1;
        int[] genesToMutate = new int[numberToMutate];
        for(int i = 0; i < numberToMutate; i++)
        {
            int selectedGene = (int)((Math.random()*100)%(totalNumberOfGenes));
                while(search(genesToMutate, selectedGene) > -1)
                {
                    selectedGene = (int)((Math.random()*100)%(totalNumberOfGenes));
                }
                genesToMutate[i] = selectedGene;
                int posOrNeg = (int)(Math.random()*10%2);
                Chromosome chromosomeToMutate 
                        = chromosomes.get(selectedGene/chromosomes.get(0).N.length + 1);
                if(posOrNeg == 0)
                    chromosomeToMutate.N[selectedGene%chromosomeToMutate.N.length] 
                            = chromosomeToMutate.N[selectedGene%chromosomeToMutate.N.length] - 10;
                else
                    chromosomeToMutate.N[selectedGene%chromosomeToMutate.N.length] 
                            = chromosomeToMutate.N[selectedGene%chromosomeToMutate.N.length] + 10;
                chromosomes.set(selectedGene/chromosomes.get(0).N.length + 1, chromosomeToMutate);
        }
        return chromosomes;
    }
}
