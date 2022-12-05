package com.darwinsys.random;

import java.io.IOException;
import java.io.PrintStream;
import java.util.random.RandomGenerator;

public class CrappyRandomDemo {
    static long total;
    public static void main(String[] args) {
        System.out.println("Hello world!");
        RandomGenerator random = new CrappyRandom();
        // ((CrappyRandom)random).setKnuthBadParams();;
        random.longs(20).forEach(System.out::println);
        total = 0;
        try (PrintStream longOuts = new PrintStream("longs.txt");
            PrintStream dblOuts = new PrintStream("doubles.txt")
        ) {
            random.longs(1000).forEach(l -> {longOuts.println(l); total += l;});
            random.doubles(1000).forEach(dblOuts::println);
        } catch (IOException ex) {
            System.out.println("IOException = " + ex);
        }
        double avgLongs = total / 1000.0;
        System.out.println("avgLongs = " + avgLongs);
        System.out.println("nextLong() with bound: " + random.nextLong(1024L));
    }
}