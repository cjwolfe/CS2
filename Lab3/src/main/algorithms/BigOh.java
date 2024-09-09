package algorithms;

import java.util.Random;

// package main;
public class BigOh {

    // public static void main(String[] args) {
    //     // Your code here
    private static final double MILLISECONDS_PER_SECOND = 1000;
    private static final int NUM_TRIALS = 5;
    private final Random rand;

    public BigOh() {
        this(new Random());

    }

    public BigOh(Random rand) {
        this.rand = rand;
        int seed = rand.nextInt(6);
        int elements = rand.nextInt(3);
        // run the methods built
        // first runAlgorithm
        //int whichBigO = bigOhFunc(seed, 3);

        double actualTimeCompleted = timeAlgorithm(seed, elements);
        long convTime = System.currentTimeMillis();
        double estimatedTimeCompleted = estimateTiming(seed, elements, convTime, elements);

        //from here run most every algorithm in semi-obvious order
    }

    /**
     * @param choice is the algorithm to choose
     * @param numElements is the number of N
     * @return returns an int from the algorithms
     */
    public int runAlgorithm(int choice, int numElements) {
        int output = -1;
        switch (choice) {
            case 1:
                output = MysteryAlgorithms.alg1(numElements, rand);
                break;
            case 2:
                output = MysteryAlgorithms.alg2(numElements, rand);
                break;
            case 3:
                output = MysteryAlgorithms.alg3(numElements, rand);
                break;
            case 4:
                output = MysteryAlgorithms.alg4(numElements, rand);
                break;
            case 5:
                output = MysteryAlgorithms.alg5(numElements, rand);
                break;
            case 6:
                output = MysteryAlgorithms.alg6(numElements, rand);
                break;
            default:
                break;
        }
        return output;
    }

    /**
     * @param choice
     * @param n
     * @return -1 if error, n^x otherwise
     */
    public double bigOhFunc(int choice, double n) {
        double result = -1.0;
        switch (choice) {
            case 1:
                result = Math.pow(n, 1);
                break;
            case 2:
                result = Math.pow(n, 3);
                break;
            case 3:
                result = Math.pow(n, 2);
                break;
            case 4:
                result = Math.pow(n, 2);
                break;
            case 5:
                result = Math.pow(n, 2);
                break;
            case 6:
                result = Math.pow(n, 2);
                break;
            default:
                break;
        }
        return result;

    }

    /**
     * @param choice
     * @param n
     * @return the time of the run
     */
    public double timeAlgorithm(int choice, int n) {
        System.gc();
        long initTimeStamp = System.currentTimeMillis();
        runAlgorithm(choice, n);
        long finalTimeStamp = System.currentTimeMillis();
        return (finalTimeStamp - initTimeStamp) * MILLISECONDS_PER_SECOND;
    }

    /**
     * @param choice
     * @param n
     * @return double of the average time
     */
    public double robustTimeAlgorithm(int choice, int n) {
        double[] runTimes = new double[NUM_TRIALS];
        for (int i = 0; i < NUM_TRIALS; i++) {
            runTimes[i] = timeAlgorithm(choice, n);
        }
        double smallestTime = Double.MAX_VALUE;
        for (double time : runTimes) {
            if (time < smallestTime) {
                smallestTime = time;
            }
        }
        return smallestTime;
    }

    public double estimateTiming(int choice, int n1, double t1, int n2) {
        return t1 * (Math.pow(n2, bigOhFunc(choice, n2))
                / Math.pow(n1, bigOhFunc(choice, n1)));
    }

    public double percentError(double correct, double estimate) {

        return ((estimate - correct) / correct) * 100;
    }

    public double computePercentError(int choice, int n1, int n2) {
        double t1 = robustTimeAlgorithm(choice, n1);
        double estimatedTime = estimateTiming(choice, n1, t1, n2);
        double actualTime = robustTimeAlgorithm(choice, n2);
        double error = percentError(actualTime, estimatedTime);
        return error;
        //return .01;
    }
};
