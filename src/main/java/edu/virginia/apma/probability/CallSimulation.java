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
        double total = 0.0;

        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
            total += DIAL;
            double u = rng.nextUniform();
            String outcome = RandomVariableGenerator.discreteOutcome(u);

            if (outcome.equals("voicemail"))
                total += VOICEMAIL + HANGUP;
            else if (outcome.equals("unavailable"))
                total += RING + HANGUP;
            else {
                // double u2 = rng.nextUniform();
                double x = RandomVariableGenerator.exponentialSample(u);
                if (x > RING)
                    total += RING + HANGUP;
                else {
                    total += x;
                    return total;
                }
            }
        }
        return total;
    }
}
