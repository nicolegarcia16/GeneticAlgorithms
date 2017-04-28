package geneticalgorithms;
/**
 *
 * @author nicole
 */
public class Chromosome {
    int[] N;
    Chromosome mate;
    
    Chromosome(int size)
    {
        N = new int[size];
    }

    Chromosome() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}


