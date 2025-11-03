package edu.virginia.apma.probability;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        // LCG params; see project document
        long a = 24693, c = 3517, k = 1<<17, seed = 1000;
        LCG rng = new LCG(a, c, k, seed);

        double[] uValues = new double[60];
        System.out.println("First 60 random numbers");
        for (int i = 0; i < 60; i++) {
            uValues[i] = rng.nextUniform();
            System.out.printf(
                    "%2d: %.4f%s",
                    i + 1,
                    uValues[i],
                    (i % 6 == 5)
                            ? "\n"
                            : "\t"
            );
        }

        IntStream.range(0, 3).forEach(i ->
                System.out.printf(
                        "\nu%d=%.4f",
                        i + 1,
                        uValues[i]
                ));

        System.out.println("\n\nDiscrete & exponential samples from u51,u52,u53:");
        IntStream.range(50, 53).forEach(i -> {
            String outcome = RandomVariableGenerator.discreteOutcome(uValues[i]);
            double expSample = RandomVariableGenerator.exponentialSample(uValues[i]);
            System.out.printf(
                    "u%d=%.4f => outcome=%s, exp=%.4f s\n",
                    i + 1,
                    uValues[i],
                    outcome,
                    expSample
            );
        });

        rng.reset(seed);
        CallSimulation sim = new CallSimulation(rng);
        int N = 1000;
        double[] W = new double[N];
        for (int i = 0; i < N; i++)
            W[i] = sim.simulateCustomer();

        W = Arrays.stream(W)
                .boxed()
                .sorted(Double::compare)
                .mapToDouble(Double::doubleValue)
                .toArray();

        Arrays.stream(W).forEach(System.out::println);

        double mean = Statistics.mean(W);
        double q1 = Statistics.percentile(W, 25);
        double median = Statistics.percentile(W, 50);
        double q3 = Statistics.percentile(W, 75);

        // Right-hand Tail
        double w5 = Statistics.percentile(W, 85);
        double w6 = Statistics.percentile(W, 90);
        double w7 = Statistics.percentile(W, 95);

        System.out.println("\nSimulation Results:");
        System.out.printf("Mean=%.4f, Q1=%.4f, Median=%.4f, Q3=%.4f\n", mean, q1, median, q3);
        System.out.printf("P(W ≥ 15)=%.4f\n", Statistics.probLE(W,15));
        System.out.printf("P(W ≥ 20)=%.4f\n", Statistics.probLE(W,20));
        System.out.printf("P(W ≥ 30)=%.4f\n", Statistics.probLE(W,30));
        System.out.printf("P(W > 40)=%.4f\n", Statistics.probGT(W,40));
        System.out.printf("P(W > %.2f) = %.4f\n", w5, Statistics.probGT(W, w5));
        System.out.printf("P(W > %.2f) = %.4f\n", w6, Statistics.probGT(W, w6));
        System.out.printf("P(W > %.2f) = %.4f\n", w7, Statistics.probGT(W, w7));
    }
}
