package edu.virginia.apma.probability;

/**
 * Linear Congruential Generator (LCG) for generating pseudo-random numbers in [0, 1).
 */
public class LCG {
    private final long a, c, k;
    private long x;

    /**
     * Constructs an LCG with specified parameters and initial seed.
     *
     * @param a multiplier
     * @param c increment
     * @param k modulus
     * @param seed initial seed value
     */
    public LCG(long a, long c, long k, long seed) {
        this.a = a;
        this.c = c;
        this.k = k;
        this.x = seed;
    }

    /**
     * Generates the next pseudo-random number in [0, 1).
     *
     * @return a uniform random number between 0 (inclusive) and 1 (exclusive)
     */
    public double nextUniform() {
        // TODO
        return 0.0;
    }

    /**
     * Resets the generator to a new seed value.
     *
     * @param seed the new seed value
     */
    public void reset(long seed) {
        // TODO
        return;
    }
}
