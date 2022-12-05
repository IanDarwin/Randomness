package com.darwinsys.random;

import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

public class GenerateLmxDemo {
    public static void main(String[] args) {
        String algorithm = "L64X1024MixRandom";
        RandomGenerator genx = RandomGeneratorFactory
                .of(algorithm)
                .create();
        genx
                .doubles(10)
                .forEach(System.out::println);
    }
}
