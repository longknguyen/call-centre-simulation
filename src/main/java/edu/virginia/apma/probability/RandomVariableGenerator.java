package edu.virginia.apma.probability;

/**
 * A class to generate values of random variables using inverse transform sampling.
 */
public class RandomVariableGenerator {
    private static final double MEAN_EXP = 12.0;
    private static final double P_VOICEMAIL = 0.2;
    private static final double P_UNAVAILABLE = 0.3;

    /**
     * Maps a uniform random number to a discrete outcome.
     *
     * @param u a uniform random number in [0, 1)
     * @return a string representing the outcome (e.g. 'unavailable', 'voicemail', 'answered')
     */
    public static String discreteOutcome(double u) {
        return u < P_VOICEMAIL
                ? "voicemail"
                : (P_VOICEMAIL + P_UNAVAILABLE > u ? "unavailable" : "answered");
    }

    /**
     * Generates a sample from an exponential distribution using inverse transform sampling
     *
     * @param u a uniform random number in [0, 1)
     * @return a sample from an exponential distribution with mean MEAN_EXP
     */
    public static double exponentialSample(double u) {
        // See https://www.omscs-notes.com/simulation/random-variate-generation/?utm_source
        return -MEAN_EXP * Math.log(1.0 - Math.max(u, 1e-15));
    }
}
