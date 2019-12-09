/*
 * This program mult two vectors using n threads: C = A * B
 */
 import java.util.Scanner;

public class ThreadDotProduct extends Thread {
    private int lo, hi;
    private int[] a, b, c;
    private static int n;
    private static int n2;
    public ThreadDotProduct(int[] a, int[] b, int[] c, int lo, int hi) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.lo = lo;
        this.hi = hi;
    }

    public void run() {
        for (int i = lo; i < hi; i++) {
            c[i] = a[i] * b[i];
        }
    }

    public static void mult(int[] a, int[] b, int[] c) throws InterruptedException {
        int len = a.length;

        // Create and start 10 threads.
        ThreadDotProduct[] mythread = new ThreadDotProduct[n];
        for (int i = 0; i < n; i++) {
            mythread[i] = new ThreadDotProduct(a, b, c, (i*len)/n, ((i+1)*len/n));
            mythread[i].start();
        }
        // Wait for the threads to finish
        for (int i = 0; i < n; i++) {
            mythread[i].join();
        }
    }

    public static void main(String[] args) throws InterruptedException {
    	long start = System.nanoTime();
    	if(args.length > 0){
    		n = Integer.parseInt(args[0]);
    		n2 = Integer.parseInt(args[1]);
    		}
        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];

        for (int i = 0; i < n; i++) {
            A[i] = i;
            if((n % n2) == 0)
              B[i] = i * (n/n2);
            else
              B[i] = i * (n%n2);
        }

        mult(A, B, C);

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
