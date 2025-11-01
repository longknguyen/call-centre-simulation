package edu.virginia.apma.probability;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * A utility class for basic statistical operations.
 */
public class Statistics {

    /**
     * Calculates the mean (average) of an array of numbers
     *
     * @param arr an array of doubles
     * @return the mean of the numbers in the array
     */
    public static double mean(double[] arr) {
        return Arrays.stream(arr)
                .average()
                .orElse(0);
    }

    /**
     * Returns the p-th percentile from a sorted array
     *
     * @param sorted an array of doubles sorted in ascending order
     * @param p a percentile value between 0 and 100
     * @return the p-th percentile value
     */
    public static double percentile(double[] sorted, double p) {
        double pos = p * (sorted.length + 1) / 100.0;

        if (pos <= 1)
            return sorted[0];
        if (pos >= sorted.length)
            return sorted[sorted.length - 1];

        int lower = (int) Math.floor(pos) - 1;
        int upper = lower + 1;
        double frac = pos - Math.floor(pos);
        return sorted[lower] + frac * (sorted[upper] - sorted[lower]);
    }

    /**
     * Computes the empirical probability that a randomly selected value
     * from the sorted array is less than or equal to the given threshold
     *
     * @param sorted an array of doubles sorted in ascending order
     * @param t the threshold value
     * @return the proportion of values ≤ t
     */
    public static double probLE(double[] sorted, double t) {
        return (double) Arrays.stream(sorted)
                .filter(v -> v <= t + 1e-12)
                .count() / sorted.length;
    }

    /**
     * Computes the empirical probability that a randomly selected value
     * from the sorted array is greater than or equal to the given threshold
     * @param sorted an array of doubles sorted in ascending order
     * @param t the threshold value
     * @return the proportion of values > t
     */
    public static double probGT(double[] sorted, double t) {
        return 1.0 - probLE(sorted, t);
    }
}
