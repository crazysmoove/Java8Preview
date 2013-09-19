import java.util.Arrays;
import java.util.Random;
import java.util.StringJoiner;

public class ParallelArraySort {

    public static void main(String[] args) {

        int numCores = Runtime.getRuntime().availableProcessors();
        System.out.println("Num cores: " + numCores);

        int[] intArray = createIntArray(25_000_000);
        long seqStart = System.currentTimeMillis();
        Arrays.sort(intArray);
        long seqEnd = System.currentTimeMillis();
        System.out.println( (seqEnd - seqStart) );

        int[] intArray2 = createIntArray(25_000_000);
        long parStart = System.currentTimeMillis();
        Arrays.parallelSort(intArray2);
        long parEnd = System.currentTimeMillis();
        System.out.println( (parEnd - parStart) );

    }

    private static void printArray(int[] intArray) {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        for (int i : intArray) {
            sj.add(String.valueOf(i));
        }
        System.out.println(sj);
    }

    private static int[] createIntArray(int size) {
        int[] retVal = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            retVal[i] = rand.nextInt();
        }
        return retVal;
    }

}
