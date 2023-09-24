package code_part2;
import java.util.Random;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Collection;


public class CollectionAnalysis {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Vector<Integer> vector = new Vector<>();
        
        fillCollection(list, "ArrayList");
        fillCollection(vector, "Vector");
    }

    public static void  fillCollection( Collection<Integer> collection, String collectionName) {
        Random rand = new Random();
        long startTime = System.currentTimeMillis();
        long endTime;
        do {
            collection.add(rand.nextInt(10)); 
            endTime = System.currentTimeMillis();
        } while (endTime - startTime < 10000); // Continue until at least 10 seconds have passed
        
        System.out.println("Execution time to fill " + collectionName + ": " + (endTime - startTime));
        System.out.println("Size of " + collectionName + ": " + collection.size());
    }
}
