/*
@author Ziad Sakr
@version 1.0 December 10- 2019
 * This program mult two vectors: C = A * B using n from the command line

java -Xmx6g DotProduct  280435456
Execution time is 312 milliseconds

java -Xmx6g DotProduct 100000000
Execution time is 57 milliseconds

java -Xmx6g DotProduct 200000000
Execution time is 121 milliseconds

java -Xmx6g DotProduct 134217728
Execution time is 72 milliseconds
 */

public class DotProduct {
	private static int num;
    public static void main(String[] args) {

    	if(args.length > 0)
    		num = Integer.parseInt(args[0]);
        int[] A = new int[num];
        int[] B = new int[num];
        int[] C = new int[num];
        int ans = 0;
        int sum = 0;
        // initialize vectors
        for (int i = 0; i < num; i++) {
            A[i] = i;
            B[i] = i*5;
        }
   	long start = System.nanoTime();
        // C = A * B
        System.out.print("sum: ");
        for (int i = 0; i < num; i++)
            ans += A[i] * B[i];
            System.out.print(ans + " ");
            long end = System.nanoTime();
            long elapsed = (end - start) / 1000000;
            System.out.println("\n\nExecution time is " + elapsed + " milliseconds");



    }
}
