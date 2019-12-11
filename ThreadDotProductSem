/*
/*
@author Ziad Sakr
@version 1.0 December 10- 2019
 * This program mult two vectors using n threads: C = A * B

java -Xmx6g ThreadDotProductSem 16777216 4
Execution time is 36 milliseconds

java -Xmx6g ThreadDotProductSem 268435456 6
Execution time is 355 milliseconds

java -Xmx6g ThreadDotProductSem 268435456 8
Execution time is 148 milliseconds

java -Xmx6g ThreadDotProductSem 67108864 8
Execution time is 81 milliseconds
 */
 import java.util.Scanner;
 import java.util.concurrent.*;

public class ThreadDotProductSem extends Thread {
    private int lo, hi;
    private int[] a, b;
    private static int num;
    private static int num2;
    private static int globalSum;
    private static Semaphore sem;
    private static int sumVar = 0;

    public ThreadDotProductSem(int[] a, int[] b, Semaphore sem, int lo, int hi ) {
        this.a = a;
        this.b = b;
        this.lo = lo;
        this.hi = hi;
        this.sem = sem;

    }

    public void run(){

        for (int i = lo; i < hi; i++) {
            sumVar += a[i] * b[i];
        }
        try{
              sem.acquire();
              globalSum += sumVar;

        }
        catch(Exception InterruptedException){
            System.out.println("Excetion caught!!");
        }
        finally{
          sem.release();
        }
    }

    public static void mult(int[] a, int[] b, Semaphore sem) throws InterruptedException {
        int len = a.length;

        // Create and start 10 threads.
        ThreadDotProductSem[] mythread = new ThreadDotProductSem[num];
        for (int i = 0; i < num; i++) {
            mythread[i] = new ThreadDotProductSem(a, b, sem, (i*len)/num, ((i+1)*len/num));
            mythread[i].start();

        }
        // Wait for the threads to finish
        for (int i = 0; i < num; i++) {
            mythread[i].join();
        }
    }

    public static void main(String[] args) throws InterruptedException {
      Semaphore sem = new Semaphore(8);
    	if(args.length > 0){
    		 num = Integer.parseInt(args[1]);
    	 	num2 = Integer.parseInt(args[0]);
    		}
        int[] A = new int[num2];
        int[] B = new int[num2];

        int sum = 0;


        for (int i = 0; i < num; i++) {
            A[i] = i;
            if((num % num2) == 0)
              sum = i * (num/num2);
            else
              sum = i * (num%num2);
        }

      System.out.println("Threads: "+ num);

    	long start = System.nanoTime();
        mult(A, B, sem);
        long end = System.nanoTime();
        long elapsed = (end - start) / 1000000;
        System.out.println("\n\nExecution time is " + elapsed + " milliseconds");

        System.out.print("Sum: ");
          //sum = C[i] + sum;
           System.out.print(sum + " ");
           System.out.println();

    }
}
