/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticalgorithms;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nicol
 */
public class InteractiveAlgorithmTest {
    
    public InteractiveAlgorithmTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCreateColorChromosomes() {
        System.out.println("Test Create Colors");
        int numChromosomes = 4;
        InteractiveAlgorithm testColorAlgorithm = new InteractiveAlgorithm();
        ArrayList<Chromosome> result = testColorAlgorithm.createColorChromosomes(numChromosomes);
        assertEquals(4, result.size());
        System.out.println("Test Create Colors Passed");
    }

    @Test
    public void testClearChromosomes() {
        System.out.println("Test Clear Chromosomes");
        ArrayList selectedChromosomesToDelete = new ArrayList();
        selectedChromosomesToDelete.add(0);
        selectedChromosomesToDelete.add(1);
        InteractiveAlgorithm testColorAlgorithm = new InteractiveAlgorithm();
        ArrayList<Chromosome> chromosomes = testColorAlgorithm.createColorChromosomes(4);
        ArrayList<Chromosome> result = 
                testColorAlgorithm.clearChromosomes(selectedChromosomesToDelete, chromosomes);
        assertEquals(2, result.size());
        System.out.println("Test Clear Chromosomes Passed");
    }

    @Test
    public void testSearch() {
        int[] values = {0, 2, 3, 5};
        int valueToFind = 3;
        InteractiveAlgorithm testColorAlgorithm = new InteractiveAlgorithm();
        int expectedIndex = 2;
        int result = testColorAlgorithm.search(values, valueToFind);
        assertEquals(expectedIndex, result);
    }


    @Test
    public void testPairChromosomes() {
        System.out.println("Test Pair Chromosomes");
        InteractiveAlgorithm testColorAlgorithm = new InteractiveAlgorithm();
        ArrayList<Chromosome> chromosomes = 
                testColorAlgorithm.createColorChromosomes(4);
        chromosomes = 
                testColorAlgorithm.pairChromosomes(chromosomes);
        assertTrue(chromosomes.get(0).mate != null);
        System.out.println("Test Pair Chromosomes Passed");
    }


    @Test
    public void testCrossoverChromosomes() {
        System.out.println("Test Crossover Chromosomes");
        InteractiveAlgorithm testColorAlgorithm = new InteractiveAlgorithm();
        ArrayList<Chromosome> chromosomes = 
                testColorAlgorithm.createColorChromosomes(4);
        chromosomes = 
                testColorAlgorithm.pairChromosomes(chromosomes);
        ArrayList<Chromosome> crossedOverChromosomes = 
                testColorAlgorithm.crossoverChromosomes(chromosomes);
        assertTrue(crossedOverChromosomes.size() == 8);
        System.out.println("Test Crossover Chromosomes Passed");
    }

    /**
     * Test of mutateChromosomes method, of class InteractiveAlgorithm.
     */
    @Test
    public void testMutateChromosomes() {
        System.out.println("Test Mutate Chromosomes");
        InteractiveAlgorithm testColorAlgorithm = new InteractiveAlgorithm();
        ArrayList<Chromosome> chromosomes = 
            testColorAlgorithm.createColorChromosomes(4);
        ArrayList<Chromosome> mutatedChromosomes = 
                testColorAlgorithm.mutateChromosomes(chromosomes);
        Assert.assertFalse(mutatedChromosomes == chromosomes);
    }
    
}
