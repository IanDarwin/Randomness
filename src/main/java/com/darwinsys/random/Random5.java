package com.darwinsys.random;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.util.Random;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;


/** Print "n" calls to nextDouble() and nextGaussian() in raw form
 * using java.util.Random.next*(); results are plotted using
 * the "R" script randomnesshistograms5.r via javax.script and "renjin"
 */
public class Random5 {
	private static final String R_SCRIPT_FILE = "randomnesshistograms.r";
	private static final String PLOT_FILE = "randomness.png";
	private static int N = 100_000_000;

	public static void main(String[] argv) throws Exception {
		if (argv.length == 1) {
			try {
				N = Integer.parseInt(argv[0]);
			} catch (NumberFormatException ex) {
				System.out.printf("Number %s invalid, using %d\n", argv[0], N);
			}
		}
		// java.util.Random methods are non-static; we need an instance
		Random r = new Random(12345);
		System.out.println("First 5 random ints are:");
		for (int i = 0; i < 5; i++) {
			System.out.print(r.nextInt() + " ");
		}
		System.out.println();
		System.out.println("Generating " + N + " randoms using " + r.getClass().getSimpleName());
		double[] us = new double[N], ns = new double[N];
		long time_t0 = System.currentTimeMillis();
		for (int i=0; i<N; i++) {
			us[i] = r.nextDouble();
			ns[i] =r.nextGaussian(); }
		long time_t1 = System.currentTimeMillis();
		System.out.printf("Generating randoms took %d mSec%n", time_t1 - time_t0);
		System.out.println("Generating histograms");

		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("Renjin");
		if (engine == null) {
			System.out.println("Renjin not on classpath, alas.");
			return;
		}
		System.out.println("Engine is " + engine);
		engine.put("us", us);
		engine.put("ns", ns);
		engine.eval(Files.readString(Path.of(R_SCRIPT_FILE)));

		System.out.println("Done; output in " + PLOT_FILE);
	}
}
