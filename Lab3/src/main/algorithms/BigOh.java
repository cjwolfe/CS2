package algorithms;

import java.util.Random;

// package main;

public class BigOh {
    // public static void main(String[] args) {
    //     // Your code here
    private static final double MILLISECONDS_PER_SECOND = 1000;
    private static final int NUM_TRIALS = 5;
    private final Random rand = new Random();


    public static void main(String[] args)
    {
        System.out.println("this is the main method;");

    }

    // public void BigOh()
    // {

    // }

    // public void BigOh(Random rand)
    // {
    // }

    /**
     * @param choice is the algorithm to choose
     * @param numElements is the number of N
     * @return returns an int from the algorithms
     */
    public int runAlgorithm(int choice, int numElements)
    {
        int output = -1;
        switch (choice) 
        {
            case 1 -> output = MysteryAlgorithms.alg1(numElements, rand);
        
            case 2 -> output = MysteryAlgorithms.alg2(numElements, rand);
            case 3 -> output = MysteryAlgorithms.alg3(numElements, rand);
            case 4 -> output = MysteryAlgorithms.alg4(numElements, rand);
            case 5 -> output = MysteryAlgorithms.alg5(numElements, rand);
            case 6 -> output = MysteryAlgorithms.alg6(numElements, rand);
            
            default -> {
            }
        }
        return output;
    }

    /**
     * @param choice
     * @param n
     * @return -1 if error, n^x otherwise
     */
    public double bigOhFunc(int choice, double n)
    {
        return switch (choice) {
            case 1 -> Math.pow(n,1);
            case 2 -> Math.pow(n,3);
            case 3 -> Math.pow(n,2);
            case 4 -> Math.pow(n,2);
            case 5 -> Math.pow(n,2);
            case 6 -> Math.pow(n,2);
            default -> -1.0;
        };

        
    }

    /**
     * @param choice
     * @param n
     * @return the time of the run
     */
    public double timeAlgorithm(int choice, int n)
    {
        System.gc();
        long initTimeStamp = System.currentTimeMillis();
        runAlgorithm(choice, n);
        long finalTimeStamp = System.currentTimeMillis();
        return (finalTimeStamp-initTimeStamp) * MILLISECONDS_PER_SECOND;
    }

    /**
     * @param choice
     * @param n
     * @return double of the average time
     */
    public double robustTimeAlgorithm(int choice, int n)
    {
        double[] runTimes = new double[NUM_TRIALS];
        for (int i = 0; i < NUM_TRIALS; i++) {
            runTimes[i] = timeAlgorithm(choice, n);
        }
        double smallestTime = Double.MAX_VALUE;
        for (double time : runTimes) 
        {
            if (time < smallestTime) 
            {
                smallestTime = time;
            }
        }
        return smallestTime;
    }
     
    public double estimateTiming(int choice, int n1, double t1, int n2)
    {
        return t1 * (Math.pow(n2, bigOhFunc(choice, n2)) 
            / Math.pow(n1, bigOhFunc(choice, n1)));
    }

    public double percentError (double correct, double estimate)
    {

        return ((estimate-correct)/correct)*100;
    }

    public double computePercentError(int choice, int n1, int n2)
    {
        double t1 = robustTimeAlgorithm(choice, n1);
        double estimatedTime = estimateTiming(choice, n1, t1, n2);
        double actualTime = robustTimeAlgorithm(choice, n2);
        double error = percentError(actualTime, estimatedTime);
        return error;
        //return .01;
    }
};
