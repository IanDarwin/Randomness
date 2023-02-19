package com.darwinsys.random;

import java.util.random.*;

public class TimeAllGenerators {

	static int N = 10_000_000;

    public static void main(String[] args) {
        RandomGeneratorFactory.all()
				.map(rgFactory->rgFactory.create())
                .forEach(TimeAllGenerators::timeGenerator);
    }

	static void timeGenerator(RandomGenerator r) {
		double[] randoms = new double[N];
		long time_t0 = System.currentTimeMillis();
		for (int i=0; i<N; i++) {
			randoms[i] = r.nextDouble();
		}
		long time_t1 = System.currentTimeMillis();
		System.out.printf("Generating %d randoms took %d mSec using %s%n", N, time_t1 - time_t0, r.getClass().getSimpleName());
	}
}
