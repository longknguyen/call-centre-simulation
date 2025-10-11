package edu.virginia.apma.probability;

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
        IntStream.range(50, 54).forEach(i -> {
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
    }
}
