# A Multithreaded Dot Product.  

# Java program (DotProduct.java) 
 Which, given two n-vectors, x and y, computes the dot product of the two vectors, that is,
 
       x · y = x[0]*y[0] + ··· + x[n-1]*y[n-1]
 
Here, n must be passed as a command-line argument. Generating random vectors of n integers for testing. Verify the correctness of the program and measure running time for large n. Will Record the results from your experiment in the header of the program.
 
To measure elapsed time for your program, use Java’s time utility as follows:

        long start = System.nanoTime();
        // Do something 
        ...
        long end = System.nanoTime();
        long elapsed = (end - start) / 1000000; // in milliseconds
        System.out.println("Execution time is " + elapsed + " milliseconds");
        
# Multi-threaded program (ThreadedDotProduct.java)
Which computes the dot product of two n-vectors using t threads, where n is a multiple of t. Both n and t must be passed as command-line arguments.
 
The elements of the vectors must be equally distributed among t threads. Using an array of t integers to store local sums computed by each thread. Based on the values stored in this array, the main thread computes the global sum, which is the dot product.
 
Verify the correctness of the program. Measure running time for different values of t. Compare its running time with that of the sequential program. Will Record the results from my experiments in the header of my program.\

# Multi-threaded program using global sum instead of array (ThreadedDotProductSem.java)
Modify ThreadedDotProduct.java so that the global sum is computed without using an array of t integers that stores local sums. Use semaphores to synchronize threads.
 
Measuring the running time for different values of t. Record the results from your experiment in the header of my program.
 
