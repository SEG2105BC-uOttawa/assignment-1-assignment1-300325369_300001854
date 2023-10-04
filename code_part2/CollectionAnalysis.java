import java.util.*;

/*
 * This program compares the time taken to construct a list, iterate through the list and sum the elements
 * between ArrayList, Vector and ordinary array
 *
 * Part (a) compares the time taken to construct the list
 * Part (b) compares the time taken to iterate through the list and sum the elements
 */
public class CollectionAnalysis {

    /*
     * Populates the list with random integers from 0 to 9 (for ArrayList and Vector)
     * @param list to be populated
     * @param n the number of elements to be added to the list
     * @return the time taken to populate the list
     */
    private static long constructList (List<Integer> list, int n) { //method for both ArrayList and Vector
        Random random = new Random();
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            list.add(random.nextInt(10));
        }
        return System.currentTimeMillis() - start; //returns the time taken to populate the list
    }

    /*
     * Populates the array with random integers from 0 to 9
     * @param array to be populated
     * @param n the number of elements to be added to the array
     * @return the time taken to populate the array
     */
    private static long constructArray(int[] array, int n) { //Method for ordinary array
        Random random = new Random();
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(10);
        }
        return System.currentTimeMillis() - start; //returns the time taken to populate the array
    }

    /*
     * Iterates through ArrayList and sums the elements
     * @param list to be iterated through
     * @return the time taken to iterate through the ArrayList and sum the elements
     */
    private static long iterateAndSumArrayList(List<Integer> list) {
        long start = System.currentTimeMillis();
        long sum = 0;
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            sum += iterator.next();
        }
        System.out.println("ArrayList Sum: " + sum);
        return System.currentTimeMillis() - start;
    }

    /*
     * Iterates through Vector and sums the elements
     * @param vector to be iterated through
     * @return the time taken to iterate through the Vector and sum the elements
     */
    private static long iterateAndSumVector(List<Integer> vector) {
        long start = System.currentTimeMillis();
        long sum = 0;
        Iterator<Integer> iterator = vector.iterator();
        while (iterator.hasNext()) {
            sum += iterator.next();
        }
        System.out.println("Vector Sum: " + sum);
        return System.currentTimeMillis() - start;
    }

    /*
     * Loop through array and sums the elements
     * @param array to be iterated through
     * @return the time taken to loop through the array and sum the elements
     */
    private static long loopAndSumArray(int[] array) {
        long start = System.currentTimeMillis();
        long sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        System.out.println("Array Sum: " + sum);
        return System.currentTimeMillis() - start;
    }

    /*
     * Main method to run part a and b
     *
     */
    public static void main(String[] args) {
        int n = 100_000_000; //number of elements in the list (can affect the time taken to run the program)

        // (a)
        List<Integer> arrayList         = new ArrayList<>(); // instantiate ArrayList
        long arrayListConstructionTime  = constructList(arrayList, n); // call constructList method

        List<Integer> vector            = new Vector<>(); // instantiate Vector
        long vectorConstructionTime     = constructList(vector, n); // call constructList method

        int[] array                     = new int[n]; // instantiate ordinary array
        long arrayConstructionTime      = constructArray(array, n); // call constructArray method

        // Part (b)
        long arrayListIterationTime = iterateAndSumArrayList(arrayList);
        long vectorIterationTime    = iterateAndSumVector(vector);
        long arrayIterationTime     = loopAndSumArray(array);

        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("| Collection Type     | Construction Time (ms) | Iteration Time (ms) |     Sum     |");
        System.out.println("---------------------------------------------------------------------------------------");

        // Print ArrayList data
        System.out.printf("| %-19s | %21d | %19d | %11d |\n", "ArrayList", arrayListConstructionTime, arrayListIterationTime, iterateAndSumArrayList(arrayList));
        System.out.println("---------------------------------------------------------------------------------------");

        // Print Vector data
        System.out.printf("| %-19s | %21d | %19d | %11d |\n", "Vector", vectorConstructionTime, vectorIterationTime, iterateAndSumVector(vector));
        System.out.println("---------------------------------------------------------------------------------------");

        // Print Array data
        System.out.printf("| %-19s | %21d | %19d | %11d |\n", "Ordinary Array", arrayConstructionTime, arrayIterationTime, loopAndSumArray(array));
        System.out.println("---------------------------------------------------------------------------------------");
    }
}
