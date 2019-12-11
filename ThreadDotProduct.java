/*
/*
@author Ziad Sakr
@version 1.0 December 10- 2019
 * This program mult two vectors using n threads: C = A * B

java -Xmx6g ThreadDotProduct 280435456 8
 Execution time is 720 milliseconds

 java -Xmx6g ThreadDotProduct 134217728 8
Execution time is 147 milliseconds

ava -Xmx6g ThreadDotProduct 280435456 4
Execution time is 1091 milliseconds

java -Xmx6g ThreadDotProduct 16777216 4
Execution time is 57 milliseconds
 */
 import java.util.Scanner;

public class ThreadDotProduct extends Thread {
    private int lo, hi;
    private int[] a, b, c;
    private static int num;
    private static int num2;
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
        ThreadDotProduct[] mythread = new ThreadDotProduct[num];
        for (int i = 0; i < num; i++) {
            mythread[i] = new ThreadDotProduct(a, b, c, (i*len)/num, ((i+1)*len/num));
            mythread[i].start();
        }
        // Wait for the threads to finish
        for (int i = 0; i < num; i++) {
            mythread[i].join();
        }
    }

    public static void main(String[] args) throws InterruptedException {

    	if(args.length > 0){
    		num = Integer.parseInt(args[1]);
    		num2 = Integer.parseInt(args[0]);
    		}
        int[] A = new int[num2];
        int[] B = new int[num2];

        int[] C = new int[num2];
        int sum = 0;
        for (int i = 0; i < num; i++) {
            A[i] = i;
            if((num % num2) == 0)
            sum = i * (num / num2);
            else
              sum = i * (num % num2);
        }

        System.out.println("Threads: "+ num);
    	  long start = System.nanoTime();
        mult(A, B, C);
        System.out.print("Sum: ");

        System.out.println(sum);
        long end = System.nanoTime();
        long elapsed = (end - start) / 1000000;
        System.out.println("\n\nExecution time is " + elapsed + " milliseconds");




    }
}
