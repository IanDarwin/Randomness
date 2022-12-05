package com.darwinsys.random;

import java.util.random.RandomGenerator;

/**
 * Please *do not* use this for anything; it produces terribly bad random numbers.
 * It is just here to show that - IF you write a decent algorithm - the interface
 * will massage its results to provide the other value types needed to complete the interface.
 */
public class CrappyRandom implements RandomGenerator {

    /** The attacker has a hard time guessing the exact nanosecond at which this is initialized */
    private long x0 = (21 * System.nanoTime()) & 0xffff;
    private long a = (long) Math.pow(2,7) + 1;
    private long c = 1024;   // The increment
    private long mod = (long) Math.pow(2,32);  // The modulus
    private long lastVal = x0;

    public void setKnuthBadParams() {
        // As per knuth , to get 7 6 9 0, 7 6 9 0, ...
        mod = 10;
        lastVal = x0 = a = c = 7;
    }

    @Override
    /**
     * This is a crude implementation just to get us going.
     * Tests will reveal its quality (or lack thereof).
     */
    public long nextLong() {
        return lastVal = (a * lastVal + c) % mod;
    }
}
