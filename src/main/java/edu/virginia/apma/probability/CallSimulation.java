package edu.virginia.apma.probability;

/**
 * Simulates a customer attempting to connect via phone call.
 * Each call can result in different outcomes and takes time depending on the path.
 */
public class CallSimulation {
    private final LCG rng;

    private static final int MAX_ATTEMPTS = 4;
    private static final double DIAL = 6.0;
    private static final double VOICEMAIL = 3.0;
    private static final double RING = 25.0;
    private static final double HANGUP = 1.0;

    /**
     * Constructs a CallSimulation using a given linear congruential generator (LCG).
     *
     * @param rng a pseudo-random number generator
     */
    public CallSimulation(LCG rng) {
        this.rng = rng;
    }

    /**
     * Simulates a single customer making up to MAX_ATTEMPTS calls.
     * Each attempt has random outcomes and adds different amounts of time.
     *
     * @return total time taken for the customer's call attempts (in seconds)
     */
    public double simulateCustomer() {
        // TODO
        return 0.0;
    }
}
