/*
 * This program mult two vectors: C = A * B using n from the command line
 */
public class DotProduct {
	private static int n;
    public static void main(String[] args) {
     	long start = System.nanoTime();
    	if(args.length > 0)
    		n = Integer.parseInt(args[0]);
        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];

        // initialize vectors
        for (int i = 0; i < n; i++) {
            A[i] = i;
            B[i] = i*5;
        }

        // C = A * B
        for (int i = 0; i < n; i++) 
            C[i] = A[i] * B[i];

        System.out.print("A: ");
        for (int i=0; i<n; i++)
           System.out.print(A[i] + " ");
        System.out.println();

        System.out.print("B: ");
        for (int i=0; i<n; i++)
           System.out.print(B[i] + " ");
        System.out.println();

        System.out.print("C: ");
        for (int i=0; i<n; i++)
           System.out.print(C[i] + " ");
        System.out.println();
        long end = System.nanoTime();
        long elapsed = (end - start) / 1000000;
        System.out.println("\n\nExecution time is " + elapsed + " milliseconds");
    }
}
