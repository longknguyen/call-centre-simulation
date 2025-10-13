package edu.virginia.apma.probability;

import java.math.BigInteger;

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
        //this.x = seed;
        reset(seed);
    }

    /**
     * Generates the next pseudo-random number in [0, 1).
     *
     * @return a uniform random number between 0 (inclusive) and 1 (exclusive)
     */
    public double nextUniform() {
        // TODO implement  x_{n+1} = (a * x_n + c) mod k

        BigInteger A = BigInteger.valueOf(a);
        BigInteger C = BigInteger.valueOf(c);
        BigInteger K = BigInteger.valueOf(k);
        BigInteger X = new BigInteger(Long.toString(x));

        BigInteger nextplus1 = A.multiply(X).add(C).mod(K);

        nextplus1Output = nextplus1.longValue()

        return (double) nextplus1Output / (double) k
    }

    /**
     * Resets the generator to a new seed value.
     *
     * @param seed the new seed value
     */
    public void reset(long seed) {
        //make the reset to normalize to [0, k)

        long r = seed % k;

        this.x = (r < 0) ? r + k : r;
    }
}
